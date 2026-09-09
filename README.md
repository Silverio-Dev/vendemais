# VendeMais

Sistema de gestão de vendas desenvolvido em Java com Spring Boot.

## Sobre o projeto

O VendeMais é uma API REST desenvolvida para gerenciar clientes, produtos e vendas, aplicando regras de negócio relacionadas a descontos, estoque, pagamentos e parcelamentos.

## Engenharia de Software

Antes do desenvolvimento, foram realizados:

- Levantamento de requisitos
- Definição das regras de negócio
- Definição dos requisitos funcionais
- Definição dos requisitos não funcionais
- Modelagem do sistema
- Implementação das regras de negócio
- Desenvolvimento da API REST
- Testes unitários

## Tecnologias utilizadas

- Java 26
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT
- MySQL
- Maven
- JUnit
- Mockito
- Postman
- Git e GitHub

## Funcionalidades

### Clientes

- Cadastro de clientes
- Listagem de clientes
- Busca de cliente por ID
- Alteração de cliente
- Exclusão de cliente

### Produtos

- Cadastro de produtos
- Listagem de produtos
- Alteração de preço
- Controle de estoque
- Baixa de estoque
- Aplicação de descontos
- Promoções

### Vendas

- Validação da forma de pagamento
- Validação da quantidade de itens
- Aplicação de descontos
- Parcelamento de vendas
- Validação de produtos acima de R$ 800

## Regras de negócio

O sistema possui regras relacionadas a:

- Desconto de aniversário
- Promoções
- Desconto de 30%
- Alteração de preço dos produtos
- Baixa de estoque
- Validação da quantidade de itens
- Parcelamento em até 5 vezes sem juros
- Parcelamento em 6 vezes ou mais com acréscimo
- Verificação de produtos acima de R$ 800
- Validação da forma de pagamento
- Controle de estoque

## Autenticação e segurança

O sistema utiliza Spring Security e JWT para autenticação e autorização dos usuários.

O usuário realiza o login e recebe um token JWT, utilizado para acessar os endpoints protegidos da aplicação.

## Testes

Foram desenvolvidos testes unitários utilizando:

- JUnit
- Mockito

Os testes abrangem serviços e regras de negócio do sistema.

## Banco de dados

O projeto utiliza MySQL para persistência dos dados.

As informações sensíveis, como a senha do banco de dados, são configuradas por meio de variáveis de ambiente e não ficam expostas no código-fonte.

## API REST

A aplicação disponibiliza endpoints para gerenciamento de:

- Clientes
- Produtos
- Usuários
- Vendas
- Autenticação

Os endpoints podem ser testados utilizando o Postman.

### Pré-requisitos

- Java 26
- MySQL
- Maven

### Altor
Silverio Italo
Projeto desenvolvido para esstudo e pratica de Engenharia de Software, desenvolvimento backend e construção de APIs REST com JAVA e SPRING Boot.

### Executando o projeto

Clone o repositório:

````bash
git clone https://github.com/Silverio-Dev/vendemais.git
