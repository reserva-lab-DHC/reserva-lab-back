# Introdução?
Repositório dedicado para a aplicação back end da disciplina PI-2. Uma solução para monitorar as reservas de laboratórios da Escola Superior Dom Helder Câmara.

# Como rodar local a release?
Basta definir a versao do java do computador como no mínimo o Java 21 (Recomendado Java 21) e rodar o .jar da release, a aplicacao irá rodar na porta `http://localhost:8080` então, as requests devem ser feitas nele

# Dicas
 - Clean code
   * (https://medium.com/arctouch/5-dicas-pr%C3%A1ticas-de-clean-code-que-todo-desenvolvedor-deveria-adotar-985e6b668544)
 - Bons repositórios tem bons commits
   * (https://demenezes.dev/posts/dicas-de-commit/)
 - Documentação Spring 
   * (https://angular.dev/overview)](https://docs.spring.io/spring-framework/reference/index.html)

A seguir está a documentação dos endpoints da API REST com base nos controladores.

## Documentação da API

Esta documentação detalha os endpoints para gerenciar usuários, salas e reservas.

---

### `UserController`
**Caminho base:** `/users`

Este controlador gerencia as operações CRUD para os usuários.

#### **1. Criar Usuário**
- **Endpoint:** `POST /users`
- **Descrição:** Cria um novo usuário no sistema.
- **Corpo da Requisição:** `UserDTO`
  ```json
  {
    "email": "string",
    "userName": "string",
    "role": "ALUNO"
  }
  ```
- **Respostas:**
  - `201 Created`: Retorna o objeto `User` criado.
  - `500 Internal Server Error`: Se ocorrer um erro durante a criação.

#### **2. Obter Usuário por ID**
- **Endpoint:** `GET /users/{uuidString}`
- **Descrição:** Busca um usuário específico pelo seu UUID.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID do usuário.
- **Respostas:**
  - `200 OK`: Retorna o objeto `User` correspondente.
  - `404 Not Found`: Se o usuário com o UUID fornecido não for encontrado.

#### **3. Editar Usuário**
- **Endpoint:** `PUT /users/{uuidString}`
- **Descrição:** Atualiza as informações de um usuário existente.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID do usuário a ser editado.
- **Corpo da Requisição:** `UserDTO`
  ```json
  {
    "email": "string",
    "userName": "string",
    "role": "PROFESSOR"
  }
  ```
- **Respostas:**
  - `200 OK`: Retorna o objeto `User` atualizado.
  - `500 Internal Server Error`: Se ocorrer um erro durante a atualização.

#### **4. Deletar Usuário**
- **Endpoint:** `DELETE /users/{uuidString}`
- **Descrição:** Remove um usuário do sistema.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID do usuário a ser deletado.
- **Respostas:**
  - `204 No Content`: Indica que o usuário foi deletado com sucesso.
  - `404 Not Found`: Retorna uma mensagem de erro se o usuário não for encontrado.
  - `500 Internal Server Error`: Retorna uma mensagem de erro se ocorrer um problema na exclusão.

---

### `SalaController`
**Caminho base:** `/sala`

Este controlador é responsável por gerenciar as salas.

#### **1. Criar Sala**
- **Endpoint:** `POST /sala`
- **Descrição:** Cria uma nova sala.
- **Corpo da Requisição:** `SalaDTO`
  ```json
  {
    "nomeSala": "string",
    "predio": integer,
    "andar": integer
  }
  ```
- **Respostas:**
  - `201 Created`: Retorna o objeto `Sala` que foi criado.

#### **2. Obter Sala por ID**
- **Endpoint:** `GET /sala/{uuidString}`
- **Descrição:** Retorna uma sala específica com base no seu UUID.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID da sala.
- **Respostas:**
  - `200 OK`: Retorna o objeto `Sala`.
  - `404 Not Found`: Se a sala não for encontrada.

#### **3. Editar Sala**
- **Endpoint:** `PUT /sala/{uuidString}`
- **Descrição:** Atualiza os dados de uma sala existente.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID da sala a ser editada.
- **Corpo da Requisição:** `SalaDTO`
- **Respostas:**
  - `200 OK`: Retorna o objeto `Sala` atualizado.
  - `404 Not Found`: Retorna uma mensagem de erro se a sala não for encontrada.
  - `500 Internal Server Error`: Retorna uma mensagem de erro genérica.

#### **4. Deletar Sala**
- **Endpoint:** `DELETE /sala/{uuidString}`
- **Descrição:** Remove uma sala do sistema.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID da sala a ser deletada.
- **Respostas:**
  - `200 OK`: Retorna uma mensagem de sucesso.
  - `404 Not Found`: Retorna uma mensagem de erro se a sala não for encontrada.
  - `500 Internal Server Error`: Retorna uma mensagem de erro genérica.

#### **5. Obter todas as Salas**
- **Endpoint:** `GET /sala`
- **Descrição:** Retorna um array com todas as salas.
- **Respostas:**
  - `200 OK`: Retorna o objeto `List<Sala>`.
  - `404 Not Found`: Se a sala não for encontrada.
---

### `ReservaController`
**Caminho base:** `/reserva`

Este controlador gerencia as reservas de salas.

#### **1. Criar Reserva**
- **Endpoint:** `POST /reserva`
- **Descrição:** Cria uma nova reserva para uma sala.
- **Corpo da Requisição:** `ReservaDTO`
  ```json
  {
    "dataReserva": "YYYY-MM-DD",
    "horariosReservados": ["H08_00", "H08_50"],
    "status": "PENDENTE",
    "solicitanteId": "uuid-string",
    "salaReservadaId": "uuid-string",
    "disciplinaRelacionada": "string",
    "motivoReserva": "string",
    "dataSolicitacao": "YYYY-MM-DDTHH:mm:ss"
  }
  ```
- **Respostas:**
  - `201 Created`: Retorna o objeto `Reserva` criado.

#### **2. Listar Reservas por Sala e Status**
- **Endpoint:** `GET /reserva/{uuid}/{status}`
- **Descrição:** Lista todas as reservas para uma sala específica, filtradas por status.
- **Parâmetros de Caminho:**
  - `uuid` (UUID): O UUID da sala.
  - `status` (StatusReserva): O status da reserva (`PENDENTE`, `APROVADA`, `REJEITADA`, `CANCELADA`, `ALL`).
- **Respostas:**
  - `200 OK`: Retorna uma lista de objetos `Reserva`.

#### **3. Editar Reserva**
- **Endpoint:** `PUT /reserva/{uuidString}`
- **Descrição:** Edita uma reserva existente.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID da reserva a ser editada.
- **Corpo da Requisição:** `ReservaDTO`
- **Respostas:**
  - `200 OK`: Retorna o objeto `Reserva` atualizado.
  - `404 Not Found`: Se a reserva não for encontrada.
  - `500 Internal Server Error`: Se ocorrer um erro ao editar a reserva.

#### **4. Deletar Reserva**
- **Endpoint:** `DELETE /reserva/{uuidString}`
- **Descrição:** Deleta uma reserva.
- **Parâmetros de Caminho:**
  - `uuidString` (string): O UUID da reserva a ser deletada.
- **Respostas:**
  - `204 No Content`: Indica que a reserva foi deletada com sucesso.
  - `404 Not Found`: Se a reserva não for encontrada.
  - `500 Internal Server Error`: Se ocorrer um erro ao deletar a reserva.
