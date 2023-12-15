# AdwardAPI

API RESTful para possibilitar a leitura da lista de indicados e vencedores
da categoria Pior Filme do Golden Raspberry Awards.

## Requisitos

- Java JDK 11 ou superior
- Gradle (Opcional, pois o Gradle Wrapper já está incluído no projeto)

## Executando o Projeto

Para executar o projeto, siga estes passos:

1. Clone o repositório:
git clone https://github.com/alexandregiordanelli/demo
cd demo

2. Execute o projeto usando o Gradle Wrapper:

```
./gradlew bootRun
```

Isso iniciará a aplicação na porta padrão 8080.

## Acessando a Aplicação

Após iniciar a aplicação, você pode acessar o endpoint da API em:

http://localhost:8080/api/awards/intervals

## Executando Testes de Integração

Para executar os testes de integração, use o seguinte comando:

```
./gradlew test
```

Os relatórios dos testes podem ser encontrados em `build/reports/tests/test/index.html` após a execução dos testes.

