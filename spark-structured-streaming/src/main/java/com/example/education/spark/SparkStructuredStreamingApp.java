package com.example.education.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.streaming.StreamingQueryListener;

import java.util.concurrent.TimeoutException;

public class SparkStructuredStreamingApp {

    public static void main(String[] args) throws StreamingQueryException, TimeoutException {
        SparkSession spark = SparkSession.builder()
                .appName("StudentExportStreamingApp")
                .master("local[*]")
                .getOrCreate();

        spark.streams().addListener(new StreamingQueryListener() {
            @Override
            public void onQueryStarted(QueryStartedEvent event) {
                System.out.println("Запрос запущен: " + event.id());
            }

            @Override
            public void onQueryTerminated(QueryTerminatedEvent event) {
                System.out.println("Запрос остановлен: " + event.id());
            }

            @Override
            public void onQueryProgress(QueryProgressEvent event) {
                System.out.println("Прогресс запроса: " + event.progress());
            }
        });

        Dataset<Row> fileStream = spark.readStream()
                .format("json")
                .schema(getStudentSchema())
                .option("maxFilesPerTrigger", 1)
                .load("/app/data_exports");

        Dataset<Row> kafkaStream = fileStream.selectExpr("to_json(struct(*)) AS value");

        kafkaStream.writeStream()
                .format("kafka")
                .option("kafka.bootstrap.servers", "kafka:9092")
                .option("topic", "student_exports")
                .option("checkpointLocation", "/app/checkpoints")
                .start()
                .awaitTermination();
    }

    private static org.apache.spark.sql.types.StructType getStudentSchema() {
        return new org.apache.spark.sql.types.StructType()
                .add("studentId", "long")
                .add("firstName", "string")
                .add("lastName", "string")
                .add("email", "string")
                .add("enrollmentDate", "date");
    }
}