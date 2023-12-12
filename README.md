# Documentação do Projeto Desafio CNAB

## Descrição
O projeto Desafio CNAB é uma aplicação Spring Boot que permite o processamento de arquivos CNAB para importação de transações financeiras e o cálculo de saldos em contas. Ele inclui um backend para o processamento de arquivos e um frontend para exibição dos resultados.

## Requisitos
- Java 17
- Spring Boot 3.1.3
- PostgreSQL
- Maven

## Estrutura do Projeto
O projeto está estruturado em pacotes e classes da seguinte forma:

- **com.ByCodersTec.model**: Classes de modelo que representam as entidades do projeto, incluindo a classe principal `TransacaoModel`.

- **com.ByCodersTec.repository**: Contém a interface `TransacaoRepository` para interação com o banco de dados.

- **com.ByCodersTec.service.Impl**: Classe `TransacaoServiceImpl` que implementa a interface `TransacaoService` e contém a lógica de negócio.

- **com.ByCodersTec.service**: Interface `TransacaoService` que define os métodos para processar e listar transações financeiras.

- **com.ByCodersTec.enums**: Enumeração `TipoTransacao` para representar os diferentes tipos de transações financeiras.

- **com.ByCodersTec.dto**: Classes DTO (Data Transfer Object) para representar as transações em formato de solicitação e resposta.

- **com.ByCodersTec.controller**: Classe `TransacaoController` que define os endpoints da API REST.

- **com.ByCodersTec.config**: Classes de configuração do projeto, incluindo `CorsConfig`, `SecurityConfig` e `WebConfig`.

## Dependências do Projeto
Principais dependências do projeto:

- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Web
- PostgreSQL
- Lombok
- Spring Boot Starter Test

## Como Executar o Projeto
1. Clone o repositório do projeto.
2. Certifique-se de que o PostgreSQL esteja instalado e em execução. Configure as credenciais no arquivo `application.properties`.
3. No diretório raiz do projeto, execute o seguinte comando para compilar e executar a aplicação:

```bash
# Comando para compilar e executar o projeto
mvn spring-boot:run
