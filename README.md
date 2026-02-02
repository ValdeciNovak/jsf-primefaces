# Curso JSF e PrimeFaces

## Descrição

Projeto de exemplo desenvolvido durante o curso "JSF e PrimeFaces". É uma aplicação web Java EE/Servlet com JSF e PrimeFaces para demonstrar conceitos de cadastro e gestão de empresas, persistência com JPA/Hibernate e integração com um banco MySQL.

## O que o projeto faz

- Permite cadastrar, listar, editar e remover empresas.
- Gerencia ramos de atividade associados às empresas.
- Demonstra uso de JSF, PrimeFaces, CDI, JPA/Hibernate e validação.

## Problema que resolve

Fornece uma base de código didática para aprender a montar aplicações web corporativas Java com camadas de controller, repositório e serviço, além de integração com banco de dados relacional.

## Objetivo principal

Servir como projeto de aprendizado e referência para implementar aplicações JSF/PrimeFaces com persistência e boa separação de responsabilidades.

## Tecnologias utilizadas

- Linguagem: Java 8
- Frameworks: JSF (javax.faces), PrimeFaces
- Persistência: JPA com Hibernate
- Banco de dados: MySQL (configurado em `src/main/resources/META-INF/persistence.xml`)
- Build: Maven
- Outros: CDI (Weld), Hibernate Validator, Apache POI (exemplo de uso)

## Dependências principais

- `javax.faces` 2.3.x
- `primefaces` 14.x
- `hibernate-core` 5.6.x
- `mysql-connector-java` 8.x

## Funcionalidades

- Cadastro de empresas (criar, editar, excluir)
- Listagem e pesquisa de empresas
- Gerenciamento de ramos de atividade
- Conversores e validações via JSF
- Script de dados iniciais para popular o DB: `src/main/resources/META-INF/sql/dados-iniciais.sql`

## Como executar o projeto

1. Clonar repositório

```bash
git clone <URL-do-repositório>
cd curso-jsf-e-primefaces
```

2. Pré-requisitos

- Java 8 (JDK 1.8)
- Maven
- MySQL (ou outro RDBMS compatível; alterar `persistence.xml` conforme necessário)
- Servlet container (Apache Tomcat 8/9 ou similar)

3. Configurar o banco de dados

- Por padrão a aplicação vem configurada para MySQL em `src/main/resources/META-INF/persistence.xml`:

  - URL: `jdbc:mysql://localhost:3306/cursojsfprimefaces?useSSL=false&serverTimezone=UTC`
  - usuário: `root`
  - senha: ``

- Altere essas propriedades conforme seu ambiente e crie o banco `cursojsfprimefaces`.
- Para popular dados iniciais, o projeto usa o script: `src/main/resources/META-INF/sql/dados-iniciais.sql`.

4. Compilar e empacotar

```bash
mvn clean package
```

5. Implantar

- Copie o arquivo WAR gerado em `target/curso-jsf-e-primefaces-0.0.1-SNAPSHOT.war` para o diretório `webapps` do Tomcat e inicie o Tomcat.
- Alternativamente, execute a aplicação diretamente a partir da sua IDE (importar como projeto Maven) e rode em um servidor integrado.

6. Acessar a aplicação

- Abra no navegador: `http://localhost:8080/curso-jsf-e-primefaces-0.0.1-SNAPSHOT` (ou ajuste conforme o contexto do seu servidor)

## Organização de pastas

- `src/main/java` — código fonte Java (controller, model, repository, service, util)
- `src/main/resources/META-INF` — configurações (persistence.xml, beans.xml, scripts SQL)
- `src/main/webapp` — páginas JSF (`.xhtml`), recursos estáticos (CSS, imagens)
- `target` — artefatos gerados (WAR, classes compiladas)

## Padrões utilizados

- Arquitetura em camadas (Controller / Service / Repository)
- CDI para injeção de dependências
- JPA/Hibernate para persistência
- Convenções de nomes e pacotes seguindo padrão Maven

## Aprendizados

- O que você pode aprender com este projeto:
  - Configuração e uso de JSF + PrimeFaces
  - Integração JPA/Hibernate com MySQL
  - Uso de CDI e interceptors (`TransacionalInterceptor`)
  - Validação e mensagens de faces

## Desafios enfrentados

- Gerenciar o ciclo de vida das transações e a integração com o container
- Configurar corretamente o `persistence.xml` e scripts de carga

## Conceitos aplicados

- Injeção de dependência (CDI)
- Mapeamento objeto-relacional (JPA/Hibernate)
- Componentes de interface com PrimeFaces
- Padrões de repositório e serviço


**Autor**

- Valdeci Novak Junior
- GitHub: https://github.com/ValdeciNovak
- LinkedIn - https://www.linkedin.com/in/valdecijuniordev/
