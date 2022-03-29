## :computer: <font color=green>Desafio IT Experts (REST API)</font>  - Bem vindo(a)!



Este repositório contém todas as informações referentes ao desenvolvimento do **Projeto Final** do **Curso Intensivo em linguagem Java** do **IT Experts** da [Share RH](sharerh.com). (para maiores informações leia "Origem do projeto")

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
- Criação de ambiente, banco de dados e pipeline na **AWS**

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
- Postman (9.15.2)
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

![Diagrama de Relacionamento MySQL](https://github.com/Daiene-Fortunato/accountbank/blob/f3eba3eb137fd6610568f58c7059441944c1e4a2/images/diagramabanco.png?raw=true)



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

  ![Imagem Git Commits](https://github.com/Daiene-Fortunato/accountbank/blob/f3eba3eb137fd6610568f58c7059441944c1e4a2/images/gitcommit.png?raw=true)

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

  - **Criação com êxito do Pipeline**:

  

  - **Ambiente funcionando:**

    ![Imagem Instancia T2 EC2](https://github.com/Daiene-Fortunato/accountbank/blob/d05619b899116eb57f7d7859f88a740baf13bd59/images/ambienteelasticbeans.png?raw=true)

  - **Banco de dados funcionando:**

    ![Imagem Instancia RDS T2](https://github.com/Daiene-Fortunato/accountbank/blob/d05619b899116eb57f7d7859f88a740baf13bd59/images/bancodedadosrds.png?raw=true)

  

- [x] Executar o projeto localmente.



## Origem, Facilitadores e Agradecimentos

​				Este projeto foi o desafio final do curso Java da jornada IT Experts, promovido pela ShareRH. As aulas ocorreram de segunda (19-22h) a sábado(9h-16h) iniciado em 10/01/22 e finalizado em 25/03/22, totalizando 186h.

​				As aulas de Java, REST API e criação de Pipeline foram ministradas pelo facilitador **Huelton Santos** ([Linkedin](https://www.linkedin.com/in/hueltondihonsantos/) | [GitHub](https://github.com/huelton)).Conceitos e funcionalidades da AWS foram ministradas pelo facilitador **Atos Ramos**([Linkedin](https://www.linkedin.com/in/atosramos/)). Banco de dados SQL (Oracle) foram ministradas pelo facilitador **Felipe dos Santos** ([Linkedin](https://www.linkedin.com/in/fdsantosdba/)).

​				Deixo aqui meus agradecimentos aos professores, foi um aprendizado significativo que levarei por toda a carreira e também agradeço ao pessoal da SharedRH pelo apoio durante todo o período de aprendizado, principalmente o **Vinícius de Souza** e a **Dayana Cruz**.

## Contribuindo

​		Teve uma ideia que pode melhorar ou acrescentar algo bacana ao projeto? Leia [CONTRIBUTING.md](https://github.com/Daiene-Fortunato/wcloud/blob/main/CONTRIBUTING.md) para obter detalhes sobre o processo de envio de solicitações pull.



## Autora

Contribuiu com:

1.  Todo o projeto.

:woman_student: [**Daiene Fortunato**](https://www.linkedin.com/in/daienefortunato/) - Analista de Dados e Desenvolvedora de Sistemas

:email:  daiene.fortunato@gmail.com



## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE.md](https://github.com/Daiene-Fortunato/accountbank/blob/main/LICENSE.md) para detalhes
