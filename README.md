# Projeto Java do Treinamento da Minsait

Projeto CRUD Spring: API Rest para Controle de Contatos.
  
## Requisitos  
 - JDK 17.0.6
 - Maven 3.8.1  
 - Spring Boot 3.0.12
 - UI Swagger 3
 - MySql
  
## Rodando  
 - Clone o projeto: https://github.com/Nathaliarsilva/projeto-treinamento-java`  
 - Abra o terminal e execute: `mvn spring-boot:run`  
 - Acesse: http://localhost:8080/swagger-ui.html  
 - Abra a aba pessoa-controller  
 - Pode testar os endpoints referente a Pessoa
 - Abra a aba contato-controller  
 - Pode testar os endpoints referente a Contato

[VÍDEO DO PROJETO FUNCIONANDO](https://www.loom.com/share/5a6652c534f84542844b6faf9a841233?sid=3090dc27-3cfe-423d-b56c-0e18b9718aef)
 
## API endpoints  
Esses endpoints permitem que você faça operações de criação, leitura, atualização e exclusão de pessoas:
&nbsp;

### Pessoas:
|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|POST|/api/pessoas|Cria uma nova pessoa|--|
 
**BodyRequest** 
```json
{
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string"
}
```

**BodyResponse**
```json
{
  "id": 0,
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string",
  "contatos": [
    {
      "id": 0,
      "tipo": 0,
      "contato": "string",
      "pessoa_id": 0
    }
  ]
}
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|GET|/api/pessoas|Retorna todas as pessoas cadastradas|--|

**BodyResponse**
```json
[
 {
  "id": 0,
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string",
  "contatos": []
 }
]
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|GET|/api/pessoas|Retorna todas as pessoas cadastradas|--|

**BodyResponse**
```json
[
 {
  "id": 0,
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string",
  "contatos": []
 }
]
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|GET|/api/pessoas/{id}|Retorna todas as pessoas cadastradas|Long id - identificador da pessoa|

**BodyResponse**
```json
{
  "id": 0,
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string",
  "contatos": []
}
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|GET|/api/pessoas/maladireta/{id}|Retorna uma pessoa pelo seu id para mala direta|Long id - identificador da pessoa|

**BodyResponse**
```json
{
  "id": 0,
  "nome": "string",
  "malaDireta": "string"
}
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|PUT|/api/pessoas/{id}|Atualiza uma pessoa pelo seu id|Long id - identificador da pessoa|
 
**BodyRequest** 
```json
{
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string"
}
```

**BodyResponse**
```json
{
  "id": 0,
  "nome": "string",
  "endereco": "string",
  "cep": "string",
  "cidade": "string",
  "uf": "string",
  "contatos": [
    {
      "id": 0,
      "tipo": 0,
      "contato": "string",
      "pessoa_id": 0
    }
  ]
}
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|DELETE|/api/pessoas/{id}|Exclui uma pessoa pelo seu id|Long id - identificador da pessoa|
&nbsp;
  
### Contatos:
|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|POST|/api/pessoas/{id}/contatos|Cria um novo contato para uma pessoa pelos eu id|Long id - identificador da pessoa|
 
**BodyRequest** 
```json
{
  "tipo": 0,
  "contato": "string"
}
```

**BodyResponse**
```json
{
  "id": 0,
  "tipo": 0,
  "contato": "string",
  "pessoa_id": 0
}
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|GET|/api/pessoas/{idPessoa}/contatos|Retorna todas os contatos vinculados a uma pessoa (pelo seu id)|Long id - identificador da pessoa|

**BodyResponse**
```json
[
  {
    "id": 0,
    "tipo": 0,
    "contato": "string",
    "pessoa_id": 0
  }
]
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|GET|/api/contatos/{id}|Retorna um contato pelo seu id|Long id - identificador do contato|

**BodyResponse**
```json
{
  "id": 0,
  "tipo": 0,
  "contato": "string",
  "pessoa_id": 0
}
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|PUT|/api/contatos/{id}|Atualiza um contato pelo seu id|Long id - identificador do contato|
 
**BodyRequest** 
```json
{
  "tipo": 0,
  "contato": "string"
}
```

**BodyResponse**
```json
{
  "id": 0,
  "tipo": 0,
  "contato": "string",
  "pessoa_id": 0
}
```
&nbsp;

|Método | EndPoint | Descrição| PathVariable|
|--|--|--|--|
|DELETE|/api/contatos/{id}|Exclui um contato pelo seu id|Long id - identificador do contato|
&nbsp;

## Validações
### Pessoas/Nome
 - Não pode ter números;
 - Não pode ter caracteres especiais;

|Exemplos de Nome| Resultado da Validação  |
|--|--|
|Fulano de Tal  | POSITIVO  |
|Ful4no de Tal  | NEGATIVO  |
|Fulano de T@l  | NEGATIVO |

### Pessoas/UF
 - Tamanho máximo de 2 caracteres;
 - Não pode ter números;
 - Não pode ter caracteres especiais;

|Exemplos de UF| Resultado da Validação  |
|--|--|
|SP | POSITIVO  |
|SSP | NEGATIVO  |
|$P | NEGATIVO |
|5P | NEGATIVO |

### Contatos/Tipo
 - Deve ser somente 0 (para telefone) ou 1 (para celular);

|Exemplos de UF| Resultado da Validação  |
|--|--|
|0 | POSITIVO  |
|22 | NEGATIVO  |
|2 | NEGATIVO |
