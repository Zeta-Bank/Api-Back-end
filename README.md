# 🏦 Zeta Bank — API Back-end

> API RESTful de um sistema bancário simplificado, com suporte a cadastro de usuários, gerenciamento de chaves Pix e transferências entre contas.

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias](#-tecnologias)
- [Arquitetura](#-arquitetura)
- [Estrutura de Pastas](#-estrutura-de-pastas)
- [Endpoints](#-endpoints)
  - [Usuários](#-usuários)
  - [Pix](#-pix)
  - [Transferências](#-transferências)
- [Tratamento de Erros](#-tratamento-de-erros)
- [Configuração e Execução](#-configuração-e-execução)
- [Documentação Swagger](#-documentação-swagger)

---

## 📌 Sobre o Projeto

A **Zeta Bank API** é o back-end de uma aplicação bancária que permite:

- Criar e gerenciar **contas de usuários** (com saldo inicial de R$ 1.000,00).
- Cadastrar **chaves Pix** do tipo `EMAIL` ou `ALEATÓRIO`.
- Realizar **transferências via Pix** entre usuários, com validação de saldo.
- Consultar o **histórico de transferências** de um usuário.

O projeto segue a arquitetura em camadas padrão do Spring Boot (Controller → Service → Repository) e expõe uma documentação interativa via Swagger UI.

---

## 🛠 Tecnologias

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

## 🏗 Arquitetura

```
Controller  →  Service  →  Repository  →  MySQL
     ↕              ↕
   DTOs         Entities
```

A aplicação usa o padrão **DTO (Data Transfer Object)** para separar as representações da API das entidades JPA, e trata erros globalmente através de `@ControllerAdvice`.

---

## 📂 Estrutura de Pastas

```
src/main/java/BL3/BackEnd/
│
├── BackEndApplication.java          # Classe principal
│
├── user/                            # Módulo de usuários
│   ├── User.java                    # Entidade JPA
│   ├── UserController.java          # Endpoints REST
│   ├── UserService.java             # Regras de negócio
│   ├── UserRepository.java          # Acesso ao banco
│   └── dto/
│       ├── UserCreationDto.java
│       ├── UserResponseDTO.java
│       └── UserUpdateDto.java
│
├── pix/                             # Módulo de chaves Pix
│   ├── Pix.java
│   ├── PixController.java
│   ├── PixService.java
│   ├── PixRepository.java
│   └── dto/
│       └── CreateChavePix.java
│
├── transferencia/                   # Módulo de transferências
│   ├── Transferencia.java
│   ├── TransferenciaController.java
│   ├── TransferenciaService.java
│   ├── TranferenciaRepository.java
│   └── dto/
│       ├── CreateTransferenciaDTO.java
│       └── TransferenciaDTO.java
│
├── security/
│   └── AuthService.java             # (em desenvolvimento)
│
└── exception/                       # Tratamento de erros
    ├── ExceptionResponse.java
    ├── PixException/
    ├── transferenciaException/
    ├── userException/
    └── advice/
```

---

## 🔗 Endpoints

### 👤 Usuários

Base path: `/users`

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/users` | Cria um novo usuário (saldo inicial: R$ 1.000,00) |
| `GET` | `/users/{id}` | Retorna um usuário pelo ID |
| `GET` | `/users/email/{email}` | Retorna um usuário pelo e-mail |
| `PUT` | `/users` | Atualiza os dados de um usuário |
| `DELETE` | `/users/{id}` | Remove um usuário |

**Corpo para criação (`POST /users`):**
```json
{
  "firstName": "João",
  "lastName": "Silva",
  "email": "joao.silva@email.com",
  "password": "senha123",
  "cpf": "123.456.789-00"
}
```

---

### 🔑 Pix

Base path: `/pix`

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/pix` | Cadastra uma nova chave Pix para o usuário |
| `GET` | `/pix/{idUser}` | Lista todas as chaves Pix de um usuário |

**Tipos de chave suportados:** `EMAIL` e `ALEATORIO`

**Corpo para criação (`POST /pix`):**
```json
{
  "id": 1,
  "tipo": "EMAIL"
}
```
> Ao usar `"tipo": "EMAIL"`, a chave Pix gerada será o próprio e-mail do usuário.  
> Ao usar `"tipo": "ALEATORIO"`, um UUID aleatório é gerado automaticamente.

---

### 💸 Transferências

Base path: `/transferencia`

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/transferencia/{userId}` | Retorna o histórico de transferências do usuário |
| `POST` | `/transferencia` | Realiza uma transferência via chave Pix |

**Corpo para transferência (`POST /transferencia`):**
```json
{
  "idRemetente": 1,
  "chavePixDestinario": "destinatario@email.com",
  "moneyAmount": 150.00
}
```

> O sistema valida se o remetente possui saldo suficiente antes de realizar a operação. O valor é debitado do remetente e creditado no destinatário atomicamente.

---

## ⚠️ Tratamento de Erros

A API possui tratamento centralizado de exceções via `@ControllerAdvice`. Os erros são retornados no formato `ExceptionResponse`.

| Exceção | Descrição |
|---|---|
| `UserAlreadyExistsException` | E-mail já cadastrado |
| `UserNotExistsException` | Usuário não encontrado |
| `UserCreationError` | Falha inesperada ao criar usuário |
| `UserUpdateError` | Falha inesperada ao atualizar usuário |
| `ChavePixJaExisteException` | Chave Pix já cadastrada |
| `ChavePixNaoEncontradaException` | Chave Pix de destino não encontrada |
| `SaldoInsuficienteException` | Saldo insuficiente para a transferência |
| `UserHaventTranferenciasException` | Usuário não possui transferências registradas |

---

## ⚙️ Configuração e Execução

### Pré-requisitos

- Java 17+
- MySQL rodando na porta `3308`
- Maven (ou usar o wrapper `./mvnw` incluso)

### Configuração do Banco de Dados

Crie o banco e o usuário no MySQL:

```sql
CREATE DATABASE zeta_data_base;
CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';
GRANT ALL PRIVILEGES ON zeta_data_base.* TO 'springstudent'@'localhost';
FLUSH PRIVILEGES;
```

As tabelas são criadas automaticamente pelo JPA/Hibernate na primeira execução.

### Variáveis de Ambiente (`application.properties`)

```properties
spring.application.name=BackEnd

spring.datasource.username=springstudent
spring.datasource.password=springstudent
spring.datasource.url=jdbc:mysql://localhost:3308/zeta_data_base
```

> **Atenção:** Para ambientes de produção, substitua as credenciais por variáveis de ambiente seguras.

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

## 📖 Documentação Swagger

Com a aplicação em execução, acesse a documentação interativa em:

```
http://localhost:8080/swagger-ui.html
```

A documentação é gerada automaticamente pelo **SpringDoc OpenAPI** e permite testar todos os endpoints diretamente pelo navegador.

---

## 🗃 Modelo de Dados

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

---

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/minha-feature`)
3. Commit suas alterações (`git commit -m 'feat: minha feature'`)
4. Push para a branch (`git push origin feature/minha-feature`)
5. Abra um Pull Request

---

*Projeto desenvolvido como parte do sistema bancário Zeta Bank.*
