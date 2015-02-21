
1. Для сборки проекта нужен Maven (использовася версия 3.2.5), JDK 1.7
    сборать WAR :
    mvn package 

2. Настройка конекта к БД MySQL 
    конифиг файлы БД лежат : \src\webapp\WEB-INF\spring\db.config
    
    2.1 нужно изменить на ваши параметры конекта к БД 

        db1.jdbc.url=jdbc:mysql://v-mysql-2.host-lux.ru:3306/DEVABN01
        db1.jdbc.username=devabn2
        db1.jdbc.password=7yyfhsALPX5dZ5EZ

    2.2 дамп БД лежит в корне в файле DEVABN01.sql - или можно изменить параметр в файле см .п.2.1 hibernate.hbm2ddl.auto=validate на create, затем вернуть на validate/

3. осталось недоделано : 
    - проверка логина, вывод ошибок 
    - проверка адреса 
    - обновление Юзера : просмотр адресов, добавление адресов, редактирование адресов.

- * - * - * - * - * - * - * - * - * - * - * - * - * - * 

- find address by country+city+street+house, if none - create new one.

    