## :computer: <font color=green>Desafio IT Experts (REST API)</font>  - Bem vindo(a)!



Este repositório contém todas as informações referentes ao desenvolvimento do **Projeto Final** do **Curso Intensivo em linguagem Java** do **IT Experts** da [Share RH](sharerh.com), iniciado em 10/01/22 e finalizado em 25/03/22.

O objetivo foi a criação de uma API REST para atender uma conta bancária; acesso e leitura de informações sobre os dados da conta, cartões e limite. Abaixo, você pode acompanhar todas as informações sobre o meu desenvolvimento e também para construir o projeto por si mesmo.



### <font color=grey>Conhecimentos adquiridos (necessários):</font>

------

- Lógica de Programação Orientada à objetos

- Sintaxe **Java**

- **API REST** com Framework **Spring Boot**

- Injeção de dependências via **Maven**

- Conteinerização via **Docker**

- Documentação e manipulação via **Swagger**

- Criação, relacionamentos e querys de **MySQL database**

- Arquitetura Cloud **AWS** com implementação via **AWS Code Pipeline**
- Versionamento de código via **Git**



### <font color=grey>Tecnologias utilizadas:</font>

------

- Java (11.0.12)
- Java SE Runtime Environment (18.9)
- Java Development Kit (1.7)
- Spring Tool Suite 4
- Spring Boot
- Spring WEB
- Spring Data JPA
- Apache Maven (3.8.5)
- Docker
- Swagger 2.0
- MySQL Workbench (8.0 CE)
- Git (2.34.1)
- Windows 11

### O Projeto:

------

> ​	"You must implement a simple bank account web API. Account have (Id, agency, bankAccount, verificationDigital, Cards). The Cards must also be managed by Bank Account. have (id, name, typeOfCard, flag, number, code, limitBalance, nameOwner)".

#### Account:

- id: (generated automatically. Integer and incremental)
- nameOwner: chars field max size 50
- agencyCode: chars field max size 4
- accountCode: chars field max size 8
- verificationDigital: chars field max size 1
- Cards: from all Cards available in currency bank account.

#### Cards:

- Id: (generated automatically, integer and incremental)
- name: Must not be empty. All cards must have a name of Card. Max size 128 chars
- flag: (Mastercard, Visa, Elo) – you can create a Enum if you prefer
- typeCard: from Type entity available
- number: chars minimun size and max size 20 chars (9999.9999. 9999.9999)
- digitCode: chars field max size 5
- limitBalance: double value max size 20

#### Type:

- Id: (generated automatically, integer and incremental)
- name: kind of cards: (DEBIT_CARD, CREDIT_CARD, MEAL_CARD, GIFT_CARD ...)



### Modelo do Banco de Dados da API:

------

[Diagrama de Relacionamento MySQL](https://github.com/Daiene-Fortunato/accountbank/tree/main/imagesdiagramabanco.png)



### Desafios e Resoluções:

------

Nível Obrigatório:

- [x] Criar uma WEB API de conta bancária vinculada a um banco de dados MySQL contendo as tabelas conta, cartão e tipo de cartão;

- [x] Necessário utilizar SPRING BOOT, o acesso e documentação devem ser feitos via SWAGGER;

  * **Run do Projeto no Spring Boot**:

  ![Imagem código API](https://github.com/Daiene-Fortunato/accountbank/blob/1b5a55b3dd49da04072bef09a7b09a345cd26e69/images/codigoapi.png?raw=true)

  - **Acesso e documentação da API pelo Swagger:**

  ![Imagem home no swagger](https://github.com/Daiene-Fortunato/accountbank/blob/1b5a55b3dd49da04072bef09a7b09a345cd26e69/images/swaggerhome.png?raw=true)

  - **Banco de dados e tabelas:**

  

  ![Imagem do banco de dados](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/accountdata.png?raw=true)

- [x] Implementar CREATE, READ e DELETE;

  - **Codigos CRUD no controller:**

  ![Imagem codigo CRUD](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/codigocrud.png?raw=true)

  - **O recursos CRUD vistos pelo Swagger:**

  ![Imagem create no swagger](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/swaggercrud.png?raw=true)

- [ ] Todos os campos são de preenchimento obrigatório, sendo necessário tratar exceções para preenchimento nulo;

- [x] A API deve listar todas as contas e os cartões relacionados à elas;

  - **GET funcionando e listando todas as contas:** (mostrar)

  ![Imagem list all contas](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/listallcontas.png?raw=true)

- [x] As contas devem ser criadas junto com seus respectivos cartões;

  - **POST funcionando, criando a conta com cartão:**

  ![Imagem Create Conta](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/createconta.png?raw=true)

- [x] Para o DELETE, não é possível deletar a conta bancária se houver algum cartão vinculado à ela; Primeiro deletar cartões, depois conta;

  - **DELETE funcionando, deletando a conta pelo Id** (mostrar)

  ![Imagem Delete Conta](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/deleteconta.png?raw=true)

- [x] Fornecer o Script de criação do banco de dados;

  - **Script manual para criação do banco e das tabelas (com as restrições e relacionamentos):**

  ![Imagem Script Create](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/scriptcreate.png?raw=true)

  - **Script com inserts para testes:**

  ![Imagem Script Insert](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/scriptinsert.png?raw=true)

- [x] Usar Maven ou Gradle para gerenciar as dependências;

  - _Incluir atualização do comando <finalName>:_
  - **Arquivo pom.xml com as configurações de dependências:**

  ![Imagem Maven](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/maven.png?raw=true)

- [x] Usar Git, comitar cada processo e disponibilizar o projeto em um repositório público.

  [Imagem Git Commits](https://github.com/Daiene-Fortunato/accountbank/tree/main/images/gitcommit.png)

Nível Avançado:

- [x] Documentar via Swagger;

  - **Imagem da configuração do Swagger:**

  ![Imagem Swagger.Config](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/swaggerconfig.png?raw=true)

- [x] Criar UPDATE apenas para a mudança dos tipos de cartões vinculados às contas;

  - **Foi criado todo o CRUD como forma de treino, em evidência o UPDATE:**

  ![Imagem Update Type](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/codigoupdatetype.png?raw=true)

  - **PUT funcionando, atualizando o tipo de cartão pelo id:**

  ![Imagem put no swagger](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/swaggerputtype.png?raw=true)

- [ ] Tratar um erro de exceção se tentar excluir o tipo de cartão quando este possuir cartões vinculados;

- [x] Implementar o projeto na nuvem utilizando AWS através do AWS Code Pipeline (CI/CD) e fornecer a Url.

  - Utilizar uma instância T2 micro EC2 (backend) - Free Tier

  - Utilizar micro-instância RDS T2 (banco de dados) - Free Tier;

  [Imagem Instancia T2 EC2](https://github.com/Daiene-Fortunato/accountbank/tree/main/images/instanciat2ec2.png) 

  [Imagem Instancia RDS T2](https://github.com/Daiene-Fortunato/accountbank/tree/main/images/instanciardst2.png)

- [x] Executar o projeto localmente.

