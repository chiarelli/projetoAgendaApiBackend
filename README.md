# 📋 Projeto Agenda API

Este é um projeto de estudo desenvolvido durante o curso de **Spring Boot Web Developer**, com o objetivo de praticar conceitos como:

- Desenvolvimento de APIs REST com Spring Boot  
- Persistência com Spring Data JPA  
- Integração com banco de dados PostgreSQL  
- Documentação automática com Swagger (SpringDoc OpenAPI)  
- Validações com Bean Validation  
- Boas práticas de versionamento de API  

---

### 🛠 Tecnologias utilizadas

- Java 21  
- Spring Boot 3.4.5  
- Spring Data JPA  
- PostgreSQL (via Docker)  
- Maven  
- SpringDoc OpenAPI  
- Bean Validation  
- Docker + Docker Compose  

---

### 🧪 Entidades principais

#### 📁 Categoria

- `id`: UUID  
- `nome`: String (único)  
- `tarefas`: Lista de tarefas relacionadas  

#### 📝 Tarefa

- `id`: UUID  
- `titulo`: String  
- `dataHora`: Date (com data e hora)  
- `finalizado`: Boolean  
- `categoria`: Categoria associada (chave estrangeira)  

---

### 🔄 Endpoints principais (Swagger)

A API possui documentação interativa disponível via Swagger:

> 🔗 Acesse: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

#### 🧾 Tarefas

- `POST /api/v1/tarefas` – Criar nova tarefa  
- `GET /api/v1/tarefas` – Listar todas as tarefas  
- `GET /api/v1/tarefas/{id}` – Buscar tarefa por ID  
- `PATCH /api/v1/tarefas/{id}` – Atualizar uma tarefa  
- `DELETE /api/v1/tarefas/{id}` – Remover uma tarefa  

#### 📂 Categorias

- `GET /api/v1/categorias` – Listar categorias  
- `GET /api/v1/categorias/{name}` – Buscar categoria por nome  

---

### ▶️ Como executar o projeto

#### 1. Subir o banco de dados PostgreSQL com Docker

Certifique-se de que o Docker está instalado e rodando.

```bash
docker-compose up -d
```
#### 2. Rodar a aplicação

No terminal (ou pela IDE):
```bash
./mvnw clean package
java -jar ./target/projetoAgendaApi-0.0.1-SNAPSHOT.jar
```
---
### ✅ Status atual
- [x] listagem de Categorias (apenas leitura)

- [ ] Criação de tarefas

- [ ] Listagem, busca, atualização e exclusão de tarefas

- [ ] Validações completas e tratamento de exceções

- [ ] Testes automatizados
---
###### 👨‍💻 Autor

Feito por Raphael Mathias Chiarelli Gomes durante o curso de Spring Boot Web Developer na COTI.