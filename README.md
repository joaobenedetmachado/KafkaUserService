# userflow-service

API simples de cadastro de usuários com envio de email de ativação usando **Kafka**, **Spring Boot** e **Envio de Email's**.

---

## ✨ Funcionalidades

- Criar usuários (`POST /users`)
- Listar apenas usuários ativados (`GET /users`)
- Enviar e-mail de ativação via Kafka
- Ativar conta com link enviado no e-mail (`GET /users/activate?token=...`)

---

## 🛠 Tecnologias usadas

- Java 21
- Spring Boot
  - Spring Web
  - Spring Data JPA
  - Spring Kafka
  - Spring Mail
- Kafka (via Docker)
- Mailtrap (para simular envio de email)
- H2 (banco em memória)

---

## 🚀 Como rodar

### Pré-requisitos

- Java 17+
- Docker e Docker Compose

### 1. Suba o Kafka com Docker

```bash
docker-compose up -d
```
