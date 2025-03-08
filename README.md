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

### Frontend

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