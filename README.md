# Gerenciamento de Empréstimos de Livros com Spring Boot e JSF PrimeFaces

Este projeto implementa um sistema web para gerenciar empréstimos de livros, utilizando Spring Boot para o backend e JSF PrimeFaces para o frontend.

## Funcionalidades

* Listagem de empréstimos (com filtros).
* Registro de empréstimos.
* Registro de devoluções.
* Cálculo automático da data de devolução prevista.
* Atualização da disponibilidade do livro ao registrar uma devolução.
* (Opcional) Cálculo de multa por atraso na devolução.

## Tecnologias

### Backend

* Spring Boot
* Spring Data JPA
* Banco de dados relacional (H2, MySQL, PostgreSQL, etc.)
* Maven ou Gradle



### Endpoints da API

## livros

| Método | Endpoint                     | Descrição                                           |
| ------ |------------------------------|-----------------------------------------------------|
| GET    | `/livros`                    | Retorna a lista de todos os Livros                  |
| GET    | `/livros/{id}`               | Retorna um Livro específico pelo ID.                |
| GET    | `/livros/filterTitle?title=` | Retorna uma lista de Livros com titulo específico.  |
| GET    | `/livros/filterAutor?autor=` | Retorna uma lista de Livros de um Autor específico. |
| POST   | `/livros`                    | Cria um novo Livro.                                 |
| PUT    | `/livros/{id}`               | Atualiza um Livro existente.                        |
| DELETE | `/livros/{id}`               | Deleta um Livro pelo ID.                            |

## usuarios

| Método | Endpoint         | Descrição                              |
| ------ |------------------|----------------------------------------|
| GET    | `/usuarios`      | Retorna a lista de todos os Usuarios   |
| GET    | `/usuarios/{id}` | Retorna um Usuario específico pelo ID. |
| POST   | `/usuarios`      | Cria um novo Usuario.                  |
| PUT    | `/usuarios/{id}` | Atualiza um Usuario existente.         |
| DELETE | `/usuarios/{id}` | Deleta um Usuario pelo ID.             |

## emprestimo

| Método | Endpoint                     | Descrição                                   |
| ------ |------------------------------|---------------------------------------------|
| GET    | `/emprestimos`               | Retorna a lista de todos os Empretimos      |
| GET    | `/emprestimos?condicao=false` | Retorna um Emprestimo  ainda não finalizado |
| GET    | `/emprestimos?condicao=true` | Retorna um Emprestimo finalizado            |
| POST   | `/emprestimos/`              | Cria um novo Emprestimo.                    |
| PUT    | `/usuarios/devolucao`        | Atualiza o status de um Emprestimo          |


### Frontend (não implementado)

* JSF (JavaServer Faces)
* PrimeFaces
* XHTML

## Componentes PrimeFaces

* DataTable para listagem de dados.
* InputText, SelectOneMenu, Calendar, etc., para formulários.
* Dialog para pop-ups de confirmação ou detalhes.
* Messages ou Growl para exibir mensagens de sucesso/erro.

## Regras de Negócio

* Um livro só pode ser emprestado se estiver disponível.
* A data de devolução prevista deve ser calculada automaticamente.
* Ao registrar uma devolução, a disponibilidade do livro deve ser atualizada.
* (Opcional) Calcular multa por atraso na devolução.

## Projeto não Finalizado.