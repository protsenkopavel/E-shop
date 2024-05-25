# E-shop v 1.0

Пет-проект для демонстрации навыков в проектировании и разработке микросервисной архитектуры,
работы с современными технологиями и инструментами, а также понимание принципов DevOps и CI/CD.

features:
- Аутентификация, авторизация, регистрация пользователей
- Защита веб-приложения
- Просмотр товаров, корзина, формирование заказов
- Управление корзиной
- Фильтрация / сортировка товаров
- Оплата (?)
- Валидация вводимых данных
- Оповещение по email

services:
- Каталог товаров: управление списком товаров, их характеристиками, фотографиями и категориями.
- Корзина покупок: хранение товаров, которые пользователь добавил в корзину.
- Заказы: обработка заказов, управление статусами заказов.
- Оплата: интеграция с различными платежными системами.
- Пользователи: управление регистрацией и авторизацией пользователей.
- Отзывы: система отзывов и рейтингов для товаров.

additional:
- ломбок отказался работать, выяснить
- добавить postman запросы в проект

technologies:
- spring boot
- web
- security
- thymeleaf -> vaadin
- jdbc -> hibernate / spring data jpa
- postgres + redis + ?
- liquibase
- spring cloud ? (аркестрация и управление микросервисами)
- zuul / spring cloud gateway (маршрутизация запросов)
- kafka / rabbit (взаимодействие между сервисами)
- docker + k8s
- ELK (elasticsearch, logstash, kibana)

e-store:
- api-gateway/ (Spring Cloud Gateway или Zuul)
- config-service/ (Spring Cloud Config)
- discovery-service/ (Eureka)
- cart-service/
- catalog-service/
- order-service/
- payment-service/
- review-service/
- auth-service/
- user-service/ +
- monitoring/ (ELK Stack)
- infrastructure/ (Docker, k8s, CI/CD)

entities:
1. Product:
- id
- title
- price
- categories
- sales

2. Order:
- id
- created date
- last change date
- completed date
- address
- user
- status (NEW, CANCELED, PAID, CLOSED, RETURNED)
- details (product, price, amount, comment)

3. Category
- id
- title

4. Bucket
- id
- user
- details (product, amount) / product list
