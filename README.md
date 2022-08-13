## Enunciado

Crie uma API em Quarkus com a base de dados H2Database em memória que suporte.

GET /client/list
    Listar todos os clientes em JSON.

PUT /client/{id}
    Alterar os dados do cliente associado ao ID.

POST /client
    Criar um novo cliente.

DELETE /client/{id}
    Remover do sistema o cliente assosiado ao ID.

O cliente tem os seguintes dados:

    Name, mínimo 5 legras e no máximo 100 caractéres
    Age, mínimo 18 anos
    VAT Number, exemplo XX999999999
    Email

Os dados do cliente são obrigatórios e precisam ser validados, não deve permitir inserir ou alterar dados inválidos.

Utilizar classe DTO, evitar retornar exceção e utilizar camada de serviço (service).

Cada cliente tem que pertencer a uma Categoria, que deve ter um modelo de dados próprio, contendo o nome e o código.

Ao criar ou editar um cliente tem que permitir alterar a Categoria a partir do código respectivo da Categoria.

Deve existir pelo duas Categorias quando a API iniciar que devem ser pré carregados, como Categoria de Programador e Comerciante.

As categorias devem suportar os mesmos métodos de serviços REST que os clientes, como GET, PUT, POST e DELETE, seguindo a mesma lógica.



# cliente-api Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/cliente-api-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- SmallRye OpenTracing ([guide](https://quarkus.io/guides/opentracing)): Trace your services with SmallRye OpenTracing
- Hibernate ORM ([guide](https://quarkus.io/guides/hibernate-orm)): Define your persistent model with Hibernate ORM and JPA
- Hibernate Validator ([guide](https://quarkus.io/guides/validation)): Validate object properties (field, getter) and method parameters for your beans (REST, CDI, JPA)
- REST Client Classic ([guide](https://quarkus.io/guides/rest-client)): Call REST services
- RESTEasy Classic JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy Classic
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

### REST Client

Invoke different services through REST with JSON

[Related guide section...](https://quarkus.io/guides/rest-client)

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
