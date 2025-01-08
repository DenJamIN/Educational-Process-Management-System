from pyspark.sql import SparkSession
from pyspark.sql.functions import *

spark = SparkSession.builder \
    .appName("EducationSparkStreaming") \
    .master("spark://spark-master:7077") \
    .getOrCreate()

df = spark.readStream \
    .option("sep", ",") \
    .schema("student_id INT, first_name STRING, last_name STRING, email STRING, enrollment_date DATE") \
    .csv("./data_exports")

df.selectExpr("CAST(student_id AS STRING) AS key", "to_json(struct(*)) AS value") \
    .writeStream \
    .format("kafka") \
    .option("kafka.bootstrap.servers", "kafka:9092") \
    .option("topic", "education_topic") \
    .option("checkpointLocation", "./checkpoints") \
    .start() \
    .awaitTermination()
