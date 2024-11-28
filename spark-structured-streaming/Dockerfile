FROM apache/spark:3.4.0

ENV SPARK_HOME=/opt/spark
ENV PATH=$SPARK_HOME/bin:$PATH

COPY target/spark-structured-streaming-1.0-SNAPSHOT.jar /app/

CMD ["spark-submit", "--class", "com.example.education.spark.SparkStructuredStreamingApp", "/app/spark-structured-streaming-1.0-SNAPSHOT.jar"]
