# Web Service SOAP - Produtos

Projeto pronto para a atividade de Web Service SOAP com:

- Java 17
- Spring Boot
- Spring Web Services
- Maven
- XSD como contrato de dados
- JAXB2 Maven Plugin
- WebServiceConfig
- Endpoint
- SOAP UI

## 1. Pré-requisitos

Instale:

- JDK 17 ou superior
- Maven
- VS Code (recomendado com Extension Pack for Java)
- SOAP UI para o teste final

Confira no terminal:

```bash
java -version
mvn -version
```

## 2. Abrir no VS Code

Extraia o ZIP e abra a pasta `produto-soap` no VS Code.

Abra o terminal do VS Code:

```bash
mvn clean install
```

Depois rode:

```bash
mvn spring-boot:run
```

## 3. Verificar o WSDL

Com a aplicação rodando, abra:

http://localhost:8080/ws/produtos.wsdl

## 4. Testar no SOAP UI

Crie um projeto SOAP usando este WSDL:

http://localhost:8080/ws/produtos.wsdl

Use o código 1001 na requisição.

Exemplo:

```xml
<soapenv:Envelope
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:pro="http://exemplo.com/produtos">

    <soapenv:Header/>

    <soapenv:Body>
        <pro:getProdutoRequest>
            <pro:codigo>1001</pro:codigo>
        </pro:getProdutoRequest>
    </soapenv:Body>

</soapenv:Envelope>
```

Produtos cadastrados:

- 1001 = Notebook / Lenovo / estoque 15
- 1002 = Mouse / Logitech / estoque 30
- 1003 = Teclado / Redragon / estoque 20

Qualquer outro código retorna "Produto não encontrado".

## 5. Estrutura

```text
src/main/java/com/exemplo/produtosoap/
├── ProdutoSoapApplication.java
├── config/
│   └── WebServiceConfig.java
├── endpoint/
│   └── ProdutoEndpoint.java
└── service/
    └── ProdutoService.java

src/main/resources/
├── application.properties
└── xsd/
    └── produtos.xsd
```

As classes Java do JAXB são geradas automaticamente em:

```text
target/generated-sources/jaxb
```

Não edite essas classes manualmente.

## 6. Fluxo

SOAP UI
  -> /ws
  -> WebServiceConfig
  -> ProdutoEndpoint
  -> ProdutoService
  -> resposta SOAP

O XSD define o contrato e o JAXB gera as classes Java usadas pelo Endpoint.
