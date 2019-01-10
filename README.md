# SpringBoot_Hibernate_shop
Try to create SpringBoot Web BootStrap application with PostgresDB

# Задание
Написать простое WEB приложение с использованием паттерна MVC
Имеется 2 таблицы Товары(Наименование, Цена) и Заказы(Номер заказа, ID товара, количество) - заполнить самостоятельно
В графическом интерфейсе реализовать выбор Номера заказа, по выбранному номеру отобразить: 
- Номер заказа
- Заказ(Наименование товара, Количество, Цена, Сумма)
- Итого по заказу

Сборщик Maven, БД любая(предпочтительно PostgreSQL)
Приложить dump
Стэк Servlet API(Spring MVC) + JDBC (Spring JPA) + интерфейс любым способом

# Описание
Задание выполнено используя Spring Boot, Hibernate. Интерфейс реализован самый простой.
В дальнейщем планируется переделать приложение в REST и создать UI с помощью Vue.js.
Зависимость в таблицах лкчше сделать @ManyToMany
