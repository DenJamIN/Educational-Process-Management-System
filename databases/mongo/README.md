
> **Войти в MongoShell без авторизации**
> 
> ```shell
> docker exec -it mongo mongosh
> ```

Просмотр содержимого таблиц по аналогии
```mongo
db.students.find().pretty()
```