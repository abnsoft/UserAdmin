
1. ��� ������ ������� ����� Maven (������������ ������ 3.2.5), JDK 1.7
    ������� WAR :
    mvn package 

2. ��������� ������� � �� MySQL 
    ������� ����� �� ����� : \src\webapp\WEB-INF\spring\db.config
    
    2.1 ����� �������� �� ���� ��������� ������� � �� 

        db1.jdbc.url=jdbc:mysql://v-mysql-2.host-lux.ru:3306/DEVABN01
        db1.jdbc.username=devabn2
        db1.jdbc.password=7yyfhsALPX5dZ5EZ

    2.2 ���� �� ����� � ����� � ����� DEVABN01.sql - ��� ����� �������� �������� � ����� �� .�.2.1 hibernate.hbm2ddl.auto=validate �� create, ����� ������� �� validate/

3. �������� ���������� : 
    - �������� ������, ����� ������ 
    - �������� ������ 
    - ���������� ����� : �������� �������, ���������� �������, �������������� �������.

- * - * - * - * - * - * - * - * - * - * - * - * - * - * 

- find address by country+city+street+house, if none - create new one.

    