# Zeta Bank — API Back-end

> API RESTful de um sistema bancário simplificado, com suporte a cadastro de usuários, gerenciamento de chaves Pix e transferências entre contas. 
> Parte do trabalho proposto pela faculdade.

---

## Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias](#tecnologias)
- [Configuração e Execução](#configuração-e-execução)
- [Documentação Swagger](#documentação-swagger)
- [Modelo de Dados](#modelo-de-dados)

---

## Sobre o Projeto

A **Zeta Bank API** é o back-end de uma aplicação bancária que permite:

- Criar e gerenciar **contas de usuários** (com saldo inicial de R$ 1.000,00).
- Cadastrar **chaves Pix** do tipo `EMAIL` ou `ALEATÓRIO`.
- Realizar **transferências via Pix** entre usuários, com validação de saldo.
- Consultar o **histórico de transferências** de um usuário.

O projeto segue a arquitetura em camadas padrão do Spring Boot (Controller → Service → Repository) e expõe uma documentação interativa via Swagger UI.

---

## Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 4.0.6 |
| Spring Data JPA | — |
| Spring Web MVC | — |
| SpringDoc OpenAPI (Swagger) | 3.0.2 |
| MySQL Connector/J | — |
| Maven | Wrapper incluso |

---

A aplicação usa o padrão **DTO (Data Transfer Object)** para separar as representações da API das entidades JPA, e trata erros globalmente através de `@ControllerAdvice`.


## Configuração e Execução

### Pré-requisitos

- Java 17+
- MySQL rodando na porta `3308`
- Maven (ou usar o wrapper `./mvnw` incluso)

### Configuração do Banco de Dados

#### Variáveis de Ambiente (`application.properties`)

```properties
spring.application.name=BackEnd
# Substitua esses 2 valores a baixo pelo seu usuário e senha mySql que tenha 
# o banco de dados do repositório com o script MySQL
spring.datasource.username=springstudent
spring.datasource.password=springstudent
spring.datasource.url=jdbc:mysql://localhost:3308/zeta_data_base
```

### Executando o projeto

```bash
# Clone o repositório
git clone https://github.com/Zeta-Bank/Api-Back-end.git
cd Api-Back-end

# Execute com Maven Wrapper
./mvnw spring-boot:run

# Ou no Windows
mvnw.cmd spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

---

## Documentação Swagger

Com a aplicação em execução, acesse a documentação interativa em:

```
http://localhost:8080/swagger-ui.html
```

A documentação é gerada automaticamente pelo **SpringDoc OpenAPI** e permite testar todos os endpoints diretamente pelo navegador.

---

## Modelo de Dados

```
user_table
  ├── id (PK)
  ├── first_name
  ├── last_name
  ├── email
  ├── password
  ├── cpf
  └── money_amount

pix_key_table
  ├── id (PK)
  ├── id_user (FK → user_table)
  └── key_pix

transferencias_pix_table
  ├── id (PK)
  ├── id_remetente (FK → user_table)
  ├── id_destinatario (FK → user_table)
  ├── id_key_destinatario (FK → pix_key_table)
  └── money_amount
```