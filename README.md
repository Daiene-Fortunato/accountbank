## :computer: <font color=green>Desafio IT Experts (REST API)</font>  - Bem vindo(a)!



Este repositório contém todas as informações referentes ao desenvolvimento do **Projeto Final  da trilha Java da jornada IT Experts**, promovido pela [ShareRH](https://sharerh.com/sobre/) como forma de entrada em processo seletivo para patrocinadores da empresa. As aulas ocorreram de segunda (19h-22h) a sábado(9h-16h) iniciado em 10/01/22  e finalizado em 25/03/22, totalizando 186h.

O objetivo foi a criação de uma WEB API REST acessada via AWS para atender uma conta bancária; acesso e leitura de informações sobre os dados da conta, cartões e limite. Abaixo, você pode acompanhar todas as informações sobre o meu desenvolvimento.



### <font color=grey>Conhecimentos adquiridos (necessários):</font>

------

- Lógica de Programação Orientada à objetos

- Sintaxe **Java**

- **API REST** com Framework **Spring Boot**

- Injeção de dependências via **Maven**

- Documentação e manipulação via **Swagger**

- Criação de banco e manipulação de dados **MySQL ** 

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

- Swagger 2.0

- Postman (9.15.2) (opcional)

- MySQL Workbench (8.0 CE)

- Git (2.34.1)

  

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

Abaixo eu pontuei cada uma das regras a serem cumpridas em dois estágios: o "obrigatório", que considera o básico do funcionamento da API para o projeto e o "avançado" que implementa outras funcionalidades e foca na capacidade de criar e gerenciar uma pipeline na AWS. Caso o aluno não conseguisse gerar a pipeline, ele poderia apresentar pelo seu localhost

Link de vídeo (Youtube) com o passo a passo da construção: [disponível após 08/04/22]()



**Nível Obrigatório:** :handshake:

------



- [x] Criar uma WEB API de conta bancária vinculada a um banco de dados MySQL contendo as tabelas conta, cartão e tipo de cartão;

- [x] Necessário utilizar SPRING BOOT, o acesso e documentação devem ser feitos via SWAGGER;

  

  * **Run do Projeto no Spring Boot**:

    

  ![Imagem código API](https://github.com/Daiene-Fortunato/accountbank/blob/1b5a55b3dd49da04072bef09a7b09a345cd26e69/images/codigoapi.png?raw=true)

  

  - **Acesso e documentação da API pelo Swagger:**

    

  ![imagem swagger](https://github.com/Daiene-Fortunato/accountbank/blob/1b5a55b3dd49da04072bef09a7b09a345cd26e69/images/swaggerhome.png?raw=true)

  

- [x] Implementar CREATE, READ e DELETE para Account e Card;

- [x] Todos os campos são de preenchimento obrigatório, sendo necessário tratar exceções para preenchimento nulo;

- [x] A API deve listar todas as contas e os cartões relacionados à elas;

- [x] As contas devem ser criadas junto com seus respectivos cartões;

- [x] Para o DELETE, não é possível deletar a conta bancária se houver algum cartão vinculado à ela (primeiro deletar cartões, depois conta);

- [x] Fornecer o Script de criação do banco de dados;

  

  - **Script manual para criação do banco e das tabelas (com as restrições e relacionamentos):**

    

  ![Imagem Script Create](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/scriptcreate.png?raw=true)



- [x] Usar Maven ou Gradle para gerenciar as dependências;

  

  - **Arquivo pom.xml com as configurações de dependências:**

    

  ![Imagem Maven](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/maven.png?raw=true)



- [x] Usar Git, comitar cada processo e disponibilizar o projeto em um repositório público.




### **Nível Avançado:**  :woman_student:

------



- [x] Documentar via Swagger;

  - **Imagem da configuração do Swagger:**

  ![Imagem Swagger.Config](https://github.com/Daiene-Fortunato/accountbank/blob/a888481563cc4c674a4d28a00463d6172bda5298/images/swaggerconfig.png?raw=true)

- [x] Criar UPDATE apenas para a mudança dos tipos de cartões vinculados às contas;

- [x] Tratar um erro de exceção se tentar excluir o tipo de cartão quando este possuir cartões vinculados;

- [x] Implementar o projeto na nuvem utilizando AWS através do AWS Code Pipeline (CI/CD) e fornecer a Url.

  - **Criação com êxito do Pipeline**:

    ![Imagem pipeline](https://github.com/Daiene-Fortunato/accountbank/blob/d05619b899116eb57f7d7859f88a740baf13bd59/images/pipeline.png?raw=true)

  - **Ambiente funcionando:**

    ![Imagem Instancia T2 EC2](https://github.com/Daiene-Fortunato/accountbank/blob/d05619b899116eb57f7d7859f88a740baf13bd59/images/ambienteelasticbeans.png?raw=true)

  - **Banco de dados funcionando:**

    ![Imagem Instancia RDS T2](https://github.com/Daiene-Fortunato/accountbank/blob/d05619b899116eb57f7d7859f88a740baf13bd59/images/bancodedadosrds.png?raw=true)

  

- [x] Executar o projeto localmente.



## Facilitadores e Agradecimentos

As aulas de Java, REST API e criação de Pipeline foram ministradas pelo facilitador **Huelton Santos** ([Linkedin](https://www.linkedin.com/in/hueltondihonsantos/) | [GitHub](https://github.com/huelton)).

Conceitos e funcionalidades da AWS foram ministradas pelo facilitador **Atos Ramos**([Linkedin](https://www.linkedin.com/in/atosramos/)). 

Banco de dados SQL (Oracle) foram ministradas pelo facilitador **Felipe dos Santos** ([Linkedin](https://www.linkedin.com/in/fdsantosdba/)).

Deixo aqui meus agradecimentos aos professores e colegas de turma, foi um aprendizado significativo que com certeza me beneficiou como profissional e pessoa. Também agradeço à equipe da SharedRH pelo apoio durante todo o período de aprendizado, principalmente ao **Vinícius de Souza** e a **Dayana Cruz**, que além das dúvidas também nos concederam uma aula preparatória para entrevistas muito bacana.

## Contribuindo

​		Teve uma ideia que pode melhorar ou acrescentar algo bacana ao projeto? Leia [CONTRIBUTING.md](https://github.com/Daiene-Fortunato/wcloud/blob/main/CONTRIBUTING.md) para obter detalhes sobre o processo de envio de solicitações pull.



## Autora

Contribuiu com:

1.  Todo o projeto.

:woman_student: [**Daiene Fortunato**](https://www.linkedin.com/in/daienefortunato/) - Analista de Dados e Desenvolvedora de Sistemas

:email:  daiene.fortunato@gmail.com



## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE.md](https://github.com/Daiene-Fortunato/accountbank/blob/main/LICENSE.md) para detalhes
