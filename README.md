# Desafio Dimensa CRUD

> O objetivo deste desafio é criar uma API RESTful capaz de gerenciar contatos e hospeda-la em nuvem. O desafio deve ter os endpoint:
  1. Listar todos os contatos
  2. Cadastrar um novo contato
  3. Alterar os dados de um contato
  4. Excluir um contato

## ☕ Tecnologias

. Spring Boot
. Spring Data JPA
. SpringDoc OpenAPI 3
. Mysql

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

- Você instalou a versão mais recente de `<Java / Maven / Postman / MySql>`
- Você tem uma máquina `<Windows / Linux / Mac>`.
- Você tem uma IDE `<Eclipse / SpringToolSuite / IntelliJ>`.
- Você leu `<https://desafio-dimensa-crud-production.up.railway.app/swagger-ui/index.html>` Documentação do CRUD.

## 🚀 Utilizando a API

Utilizar API por Swagger ou enviar as requisições pelo Postman:
```
https://desafio-dimensa-crud-production.up.railway.app/swagger-ui/index.html
```

API Endpoints

1. Buscar todos contatos.
```
curl -X 'GET' \
  'https://desafio-dimensa-crud-production.up.railway.app/contacts' \
  -H 'accept: */*'
```

2. Criar um novo contato.
```
curl -X 'POST' \
  'https://desafio-dimensa-crud-production.up.railway.app/contacts' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Nome Do Contato",
    "email": "teste@teste.com",
    "telefone": "(99)99999-9999",
    "dataNascimento": "yyyy-mm-dd",
    "endereco": [
        {
            "rua": "Rua teste",
            "cep": "99999-999",
            "numero": 99
        },
        {
            "rua": "Rua teste 2",
            "cep": "99999-999",
            "numero": 99
        },
    ]
}'
```

3. Deletar um contato.
```
curl -X 'DELETE' \
  'https://desafio-dimensa-crud-production.up.railway.app/contacts/1' \
  -H 'accept: */*'
```

4. Atualizar um contato.
```
curl -X 'PUT' \
  'https://desafio-dimensa-crud-production.up.railway.app/contacts/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Nome Do Contato",
    "email": "teste@teste.com",
    "telefone": "(99)99999-9999",
    "dataNascimento": "yyyy-mm-dd",
    "endereco": [
        {
            "rua": "Rua teste",
            "cep": "99999-999",
            "numero": 99
        },
        {
            "rua": "Rua teste 2",
            "cep": "99999-999",
            "numero": 99
        },
    ]
}'
```

5. Buscando um contato por ID.
```
curl -X 'GET' \
  'https://desafio-dimensa-crud-production.up.railway.app/contacts/1' \
  -H 'accept: */*'
```

## 📫 Contribuindo para o projeto

Para contribuir com <desafio-dimensa-crud>, siga estas etapas:

1. Bifurque este repositório.
2. Crie um branch: `git checkout -b <nome_branch>`.
3. Faça suas alterações e confirme-as: `git commit -m '<mensagem_commit>'`
4. Envie para o branch original: `git push origin <nome_do_projeto> / <local>`
5. Crie a solicitação de pull.

Como alternativa, consulte a documentação do GitHub em [como criar uma solicitação pull](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).
