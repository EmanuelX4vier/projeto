# Spring CRUD Produtos

## Descrição
Este projeto é uma **API RESTful** em **Spring Boot** que implementa um **CRUD de produtos** com boas práticas como DTOs, validação, tratamento de exceções, autenticação e documentação Swagger.  
O banco de dados usado é **H2** (em memória), ideal para testes e desenvolvimento.

---

## Tecnologias utilizadas
- Java 17  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- Spring Validation  
- Spring Security (Basic Auth)  
- H2 Database (em memória)  
- Springdoc OpenAPI / Swagger  

---

## Estrutura do projeto
```
spring-crud-produtos/
 ├── pom.xml
 ├── src/main/java/com/seuprojeto/produtos
 │    ├── config/              # Configurações de segurança e Swagger
 │    ├── controllers/         # Endpoints REST
 │    ├── dto/                 # Data Transfer Objects
 │    ├── exceptions/          # Tratamento de exceções
 │    ├── models/              # Entidades JPA
 │    ├── repositories/        # Spring Data JPA
 │    ├── services/            # Lógica de negócio
 │    └── SpringCrudProdutosApplication.java
 └── src/main/resources/
      └── application.properties
```

---

## Configuração do banco H2
- **Tipo:** Em memória (somente enquanto a aplicação estiver rodando)  
- **JDBC URL:** `jdbc:h2:mem:testdb`  
- **Usuário:** `sa`  
- **Senha:** *(vazio)*  

### Acessando o console do H2
1. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
2. Abra o navegador em:
   ```
   http://localhost:8080/h2-console
   ```
3. Configure os dados de conexão:
   - **JDBC URL:** `jdbc:h2:mem:testdb`  
   - **User Name:** `sa`  
   - **Password:** *(vazio)*  
4. Clique em **Connect**.

---

## Endpoints da API

### Base: `/produtos`
| Método | Endpoint           | Descrição                       | Requisição Body           |
|--------|------------------|---------------------------------|--------------------------|
| GET    | `/produtos`       | Lista todos os produtos         | -                        |
| GET    | `/produtos/{id}`  | Busca um produto por ID         | -                        |
| POST   | `/produtos`       | Cria um novo produto            | `ProdutoDTO` JSON        |
| PUT    | `/produtos/{id}`  | Atualiza um produto existente   | `ProdutoDTO` JSON        |
| DELETE | `/produtos/{id}`  | Deleta um produto               | -                        |

### Exemplo de `ProdutoDTO` (JSON)
```json
{
  "nome": "Mouse Gamer",
  "preco": 150.0,
  "quantidade": 10
}
```

---

## Validação
- `nome` → obrigatório (`@NotBlank`)  
- `preco` → obrigatório e positivo (`@NotNull`, `@Positive`)  
- `quantidade` → obrigatório e não negativo (`@NotNull`, `@Min(0)`)

Erros de validação retornam JSON com campo e mensagem.

---

## Autenticação
- **Tipo:** Basic Auth  
- **Usuário:** `admin`  
- **Senha:** `1234`

Exemplo usando **curl**:
```bash
curl -u admin:1234 http://localhost:8080/produtos
```

---

## Documentação Swagger
- **URL:** `http://localhost:8080/swagger-ui/index.html`  
- Permite testar todos os endpoints diretamente do navegador.

---

## Execução do projeto
1. Clone o projeto e entre na pasta:
```bash
git clone <repo_url>
cd spring-crud-produtos
```
2. Compile e rode:
```bash
mvn spring-boot:run
```
3. Acesse os endpoints via Postman, curl ou Swagger UI.

---

## Observações
- O banco **H2 em memória** perde todos os dados quando a aplicação é desligada.  
- Para persistência, pode-se alterar o `application.properties` para H2 em arquivo:  
```properties
spring.datasource.url=jdbc:h2:file:./data/produtosdb
```
