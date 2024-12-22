MICROSSERVIÇOS

Este repositório contém o código dos servicos de compra/venda de productos.


SERVIÇOS
A aplicação é composta de três microserviços, a user-api, a product-api e a shopping-api.

A user-api possui os serviços para gerenciar os usuários da aplicação.

A product-api possui os serviços para gerenciar os produtos disponíveis para compras.

A shopping-api os serviços para que usuários realizem compras.


ARQUITETURA

Aplicado arquitetura MVC com aplicação do modelo SOLID


STACK IMPLEMENTADA
Back-end : 
Java 17
Spring boot 3.3.6
Banco de dados: Spring Data Jpa, PostgreSql 12, Flyway para migrations
Testes: Junit, Mockito, OkHttp3, MockWebServer

