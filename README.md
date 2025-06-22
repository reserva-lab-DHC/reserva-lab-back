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
Controlador responsável por gerenciar as reservas de salas.

---

### **1. Criar Reserva**

- **Endpoint:** `POST /reserva`
- **Descrição:** Cria uma nova reserva de sala.
- **Corpo da Requisição:** `ReservaDTO`

```json
{
  "dataReserva": "2025-06-24",
  "diasReservados": [
    {
      "diaReserva": "SEG",
      "horarios": ["H08_00", "H08_50"]
    },
    {
      "diaReserva": "QUA",
      "horarios": ["H11_40"]
    }
  ],
  "status": "PENDENTE",
  "solicitanteId": "04e88769-e0fa-421a-a7b9-39e266874549",
  "salaReservadaId": "2878abd2-d047-4773-888e-a398419820e1",
  "disciplinaRelacionada": "Banco de DadoSs II",
  "motivoReserva": "Apresentação de projeto final",
  "dataInicio": "2025-06-22T00:00:00",
  "dataConclusao": "2025-09-22T00:00:00"
}

```

- **Respostas:**
  - `201 Created`: Reserva criada com sucesso.
  - `409 Conflict`: Reserva duplicada.
  - `400 Bad Request`: Erro de validação no corpo da requisição.

---

### **2. Listar Reservas por Sala e Status**

- **Endpoint:** `GET /reserva/{uuid}/{status}`
- **Descrição:** Lista reservas de uma sala específica, filtradas por status.
- **Parâmetros de Caminho:**
  - `uuid` (UUID): ID da sala.
  - `status` (`PENDENTE`, `APROVADA`, `REJEITADA`, `CANCELADA`, `ALL`)
- **Resposta:**
  - `200 OK`: Lista de reservas.
 
  O esperado de se receber é algo como:
```json
[
    {
        "id": "9b8b272e-0ae8-4272-94a8-2ad3c47d5cac",
        "dataReserva": "2025-06-24",
        "diasReservados": null,
        "status": "PENDENTE",
        "solicitante": {
            "id": "04e88769-e0fa-421a-a7b9-39e266874549",
            "email": "joaozinho@email.com",
            "role": "ALUNO",
            "userName": "joaozinho",
            "validUser": true,
            "createdAt": "2025-06-11T21:40:21.518719"
        },
        "salaReservada": {
            "id": "2878abd2-d047-4773-888e-a398419820e1",
            "nomeSala": "sala1",
            "predio": 1,
            "andar": 3
        },
        "disciplinaRelacionada": "Banco de DadoSs II",
        "motivoReserva": "Apresentação de projeto final",
        "dataInicio": "2025-06-22T00:00:00",
        "dataConclusao": "2025-09-22T00:00:00",
        "dataDaSolicitacao": "2025-06-22T19:40:58.027386"
    },
    {
        "id": "256b2244-ebaf-49df-9165-e2bc1e654938",
        "dataReserva": "2025-06-24",
        "diasReservados": null,
        "status": "PENDENTE",
        "solicitante": {
            "id": "04e88769-e0fa-421a-a7b9-39e266874549",
            "email": "joaozinho@email.com",
            "role": "ALUNO",
            "userName": "joaozinho",
            "validUser": true,
            "createdAt": "2025-06-11T21:40:21.518719"
        },
        "salaReservada": {
            "id": "2878abd2-d047-4773-888e-a398419820e1",
            "nomeSala": "sala1",
            "predio": 1,
            "andar": 3
        },
        "disciplinaRelacionada": "Banco de DadoSs II",
        "motivoReserva": "Apresentação de projeto final",
        "dataInicio": "2025-06-22T00:00:00",
        "dataConclusao": "2025-09-22T00:00:00",
        "dataDaSolicitacao": "2025-06-22T19:45:54.575201"
    }
]
```

---

### **3. Listar Reservas por Status**

- **Endpoint:** `GET /reserva/list/{status}`
- **Descrição:** Lista todas as reservas com base no status.
- **Parâmetros de Caminho:**
  - `status` (`PENDENTE`, `APROVADA`, `REJEITADA`, `CANCELADA`, `ALL`)
- **Resposta:**
  - `200 OK`: Lista de reservas.
    
 o esperado de se receber é algo como o `Listar Reservas por Sala e Status`

---

### **4. Editar Reserva**

- **Endpoint:** `PUT /reserva/{uuidString}`
- **Descrição:** Atualiza uma reserva existente.
- **Parâmetros de Caminho:**
  - `uuidString` (UUID): ID da reserva.
- **Corpo da Requisição:** `ReservaDTO` (igual ao de criação)
- **Respostas:**
  - `200 OK`: Reserva atualizada.
  - `404 Not Found`: Reserva não encontrada.
  - `500 Internal Server Error`: Erro inesperado ao editar.

---

### **5. Deletar Reserva**

- **Endpoint:** `DELETE /reserva/{uuidString}`
- **Descrição:** Remove uma reserva existente.
- **Parâmetros de Caminho:**
  - `uuidString` (UUID): ID da reserva.
- **Respostas:**
  - `204 No Content`: Reserva deletada com sucesso.
  - `404 Not Found`: Reserva não encontrada.
  - `500 Internal Server Error`: Erro inesperado ao deletar.
