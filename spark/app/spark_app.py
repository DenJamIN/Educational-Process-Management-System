from pyspark.sql import SparkSession
from pyspark.sql.functions import *
import os

spark = SparkSession.builder \
    .appName("EducationSparkStreaming") \
    .master("spark://spark-master:7077") \
    .getOrCreate()

# Чтение из локальной файловой системы
df = spark.readStream \
    .option("sep", ",") \
    .schema("course_id INT, course_name STRING, course_description STRING, credits INT, teacher_id INT") \
    .csv("/data/input")

# Запись в Kafka
df.selectExpr("CAST(course_id AS STRING) AS key", "to_json(struct(*)) AS value") \
    .writeStream \
    .format("kafka") \
    .option("kafka.bootstrap.servers", "kafka:9092") \
    .option("topic", "education_topic") \
    .option("checkpointLocation", "/data/checkpoint") \
    .start() \
    .awaitTermination()
