# curso-jsf-e-primefaces

Nome: JSF e PrimeFaces

Descrição
---------

Projeto de exemplo desenvolvido durante um curso que demonstra uma aplicação web Java com JSF e PrimeFaces, persistência via JPA/Hibernate e integração com MySQL. Serve como base didática para aprender camadas (controller/service/repository), CDI, validação e deploy em servidor servlet.

O que o projeto faz
-------------------

- Cadastro, listagem, edição e remoção de empresas.
- Gerenciamento de ramos de atividade associados às empresas.
- Demonstra conversores JSF, validações, interceptors e uso de scripts SQL para popular o banco.

Qual problema resolve
---------------------

Fornece um esqueleto prático para aprender e demonstrar padrões de aplicações web corporativas Java, reduzindo o esforço inicial para montar um projeto com JSF + PrimeFaces + JPA.

Objetivo principal
------------------

Ser material de apoio/estudo que mostra a integração entre camadas, persistência e interface com componentes PrimeFaces.

Tecnologias utilizadas
----------------------

- Linguagem: Java 8 (JDK 1.8)
- Build: Maven
- JSF: `javax.faces` 2.3
- UI: `primefaces` 14.x
- Persistência: JPA com Hibernate (`hibernate-core` 5.6.x)
- Banco de dados: MySQL (conector `mysql-connector-java`)
- CDI: Weld
- Validação: Hibernate Validator
- Biblioteca extra: Apache POI (manipulação de planilhas)

Funcionalidades
---------------

- CRUD completo para `Empresa`.
- Associação e gerenciamento de `RamoAtividade`.
- Conversores e validações JSF.
- Script para popular dados iniciais (`META-INF/sql/dados-iniciais.sql`).

Como executar o projeto
-----------------------

1) Clonar repositório

```bash
git clone <URL-do-repositório>
cd curso-jsf-e-primefaces
```

2) Pré-requisitos

- JDK 1.8
- Maven
- MySQL (ou outro RDBMS compatível)
- Servlet container (Tomcat 8/9) ou executar pela IDE (Eclipse/IntelliJ)

3) Configurar o banco

- Verifique e ajuste as configurações em `src/main/resources/META-INF/persistence.xml` (unidade `ProjectJSFPU`).
- Por padrão o arquivo aponta para um MySQL local e carrega um script de dados iniciais: `META-INF/sql/dados-iniciais.sql`.

4) Build

```bash
mvn clean package
```

5) Deploy

- Copie o WAR gerado (`target/curso-jsf-e-primefaces-0.0.1-SNAPSHOT.war`) para o `webapps` do Tomcat e inicie o servidor.
- Ou importe o projeto como Maven project na sua IDE e rode em um servidor integrado.

6) Acesse

- Exemplo: `http://localhost:8080/curso-jsf-e-primefaces-0.0.1-SNAPSHOT/`

Organização de pastas
---------------------

- `src/main/java` — código Java
	- `com.valdeci.erp.controller` — beans JSF (`GestaoEmpresasBean.java`, `RamoAtividadeConverter.java`)
	- `com.valdeci.erp.model` — entidades JPA (`Empresa.java`, `RamoAtividade.java`, `TipoEmpresa.java`)
	- `com.valdeci.erp.repository` — repositórios (`Empresas.java`, `RamoAtividades.java`)
	- `com.valdeci.erp.service` — serviços (`CadastroEmpresaService.java`)
	- `com.valdeci.erp.util` — utilitários e produtores (`EntityManagerProducer.java`, `TransacionalInterceptor.java`)
- `src/main/resources/META-INF` — `persistence.xml`, `beans.xml`, scripts SQL
- `src/main/webapp` — páginas JSF (`GestaoEmpresas.xhtml`), templates e recursos estáticos

Padrões utilizados
-------------------

- Arquitetura em camadas (Controller / Service / Repository)
- CDI para injeção de dependências
- Repositório para abstrair acesso a dados
- Interceptor para gerenciamento transacional (`@Transacional`)

Aprendizados
------------

- Configuração e uso de JSF + PrimeFaces.
- Integração JPA/Hibernate com MySQL e script de carga de dados.
- Uso de CDI, produtores (`EntityManager`) e interceptors transacionais.

Desafios enfrentados
--------------------

- Gerenciar transações em ambiente sem container Java EE completo.
- Configurar corretamente `persistence.xml` e scripts de carga para diferentes ambientes.

Conceitos aplicados
-------------------

- Injeção de dependência (CDI)
- Mapeamento objeto-relacional (JPA/Hibernate)
- Componentes de UI com PrimeFaces
- Padrões de repositório e serviço

Próximos passos / Melhorias
---------------------------

- Externalizar configurações sensíveis (usuário/senha) para variáveis de ambiente ou `application.properties` seguro.
- Adicionar testes de integração para camadas de persistência.
- Melhorar tratamento de exceções e mensagens de erro amigáveis na UI.

Autor
-----

- Valdeci Novak Junior
- GitHub: https://github.com/ValdeciNovak
- LinkedIn: https://www.linkedin.com/in/valdecijuniordev/
