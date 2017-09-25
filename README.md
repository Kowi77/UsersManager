**Инструкция по установке:**

1) Context path приложения "/", после деплоя через Tomcat оно доступно по адресу http://localhost:8080/userslist/
2) Таблица userslist создается в БД "postgres" (url=jdbc:postgresql://localhost:5432/postgres, user=user, password=password, driver=org.postgresql.Driver)

**Интерфейс:**

RESTful

**Используемые технологии:**

1) DB: Postgre + Hibernate + Spring Data
2) Back-end: Spring web + webMVC с конфигурацией через аннотации в Java-классах
3) Front-end: JSP + JSTL + JQuery + AJAX + Bootstrap + Datatable

**Тестирование:**

Набор JUnit тестов

Исходный код приложения доступен на https://github.com/Kowi77/UsersManager

