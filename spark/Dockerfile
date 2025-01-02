FROM openjdk:11

# Установка Python и необходимых зависимостей
RUN apt-get update && \
    apt-get install -y python3 python3-pip curl && \
    pip3 install pyspark==3.4.0 kafka-python

# Копирование приложения и скрипта ожидания
COPY app /app
COPY wait-for-it.sh /app/wait-for-it.sh

# Установка прав на выполнение для скрипта
RUN chmod +x /app/wait-for-it.sh

WORKDIR /app

# Установка дополнительных зависимостей Python
COPY requirements.txt .
RUN pip3 install -r requirements.txt

# Запуск Spark приложения с ожиданием Spark Master
CMD ["./wait-for-it.sh", "spark-master:7077", "--", "spark-submit", "--master", "spark://spark-master:7077", "spark_app.py"]
