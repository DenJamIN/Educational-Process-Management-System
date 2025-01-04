from kafka import KafkaConsumer
from pymongo import MongoClient
import json

# Настройки Kafka
KAFKA_BOOTSTRAP_SERVERS = 'kafka:9092'
KAFKA_TOPIC = 'education_topic'
GROUP_ID = 'education_consumer_group'

# Настройки MongoDB
MONGO_URI = 'mongodb://mongo:27017/'
MONGO_DB = 'education_db'
MONGO_COLLECTION = 'courses'

# Подключение к MongoDB
client = MongoClient(MONGO_URI)
db = client[MONGO_DB]
collection = db[MONGO_COLLECTION]

# Подключение к Kafka
consumer = KafkaConsumer(
    KAFKA_TOPIC,
    bootstrap_servers=KAFKA_BOOTSTRAP_SERVERS,
    group_id=GROUP_ID,
    value_deserializer=lambda x: json.loads(x.decode('utf-8'))
)

for message in consumer:
    data = message.value
    try:
        collection.insert_one(data)
        print(f"Inserted document: {data}")
    except Exception as e:
        print(f"Failed to insert document: {data}, error: {e}")
