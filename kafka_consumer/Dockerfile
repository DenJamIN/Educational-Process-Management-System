# Используем официальный образ Python
FROM python:3.9-slim

WORKDIR /app

# Установка необходимых пакетов и зависимостей
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        netcat-openbsd \
        ca-certificates && \
    rm -rf /var/lib/apt/lists/*

# Копирование скрипта ожидания
COPY wait-for-it.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh

# Копирование зависимостей и установка
COPY requirements.txt /app/requirements.txt
RUN pip install --no-cache-dir -r /app/requirements.txt

# Копирование приложения
COPY consumer.py /app/consumer.py

# Запуск Kafka Consumer с ожиданием Kafka Broker и MongoDB
CMD ["./wait-for-it.sh", "kafka:9092", "--timeout=60", "--strict", "--", "./wait-for-it.sh", "mongo:27017", "--timeout=60", "--strict", "--", "python", "consumer.py"]
