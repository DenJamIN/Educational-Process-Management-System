FROM apache/spark:3.4.0

ENV SPARK_HOME=/opt/spark
ENV PATH=$SPARK_HOME/bin:$PATH

ENV SPARK_LOCAL_DIRS=/tmp/spark
ENV IVY_CACHE_DIR=/home/spark/.ivy2/cache

RUN mkdir -p /home/spark/.ivy2/cache /tmp/spark && \
    chown -R spark:spark /home/spark/.ivy2 /tmp/spark

RUN mkdir -p /app/checkpoints && \
    chown -R spark:spark /app/checkpoints

COPY target/spark-structured-streaming-1.0-SNAPSHOT.jar /app/

CMD ["spark-submit", "--class", "com.example.education.spark.SparkStructuredStreamingApp", "--packages", "org.apache.spark:spark-sql-kafka-0-10_2.12:3.4.0", "--conf", "spark.jars.ivy=/home/spark/.ivy2", "/app/spark-structured-streaming-1.0-SNAPSHOT.jar"]
