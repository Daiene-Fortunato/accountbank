package br.com.accountbank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AccountbankApplicationTests.class)
class AccountbankApplicationTests {

	@Test
	void contextLoads() {
	}

}

//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//
//    @Order(1)
//    @Test
//    public void whenTrySaveAccount_thenAccountShouldBeSave() {
//
//        HttpEntity<Account> httpAccount = new HttpEntity<Account>
//                (new Account("TestName", "1234", "12345678", "1", "123.123.123-12",null));
//        ResponseEntity<Account> response = testRestTemplate
//                .postForEntity("http://localhost:" + port + "/api/v1/accounts/", httpAccount, Account.class);
//
//        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
//        assertNotNull(response.getBody().getId());
//        assertEquals(response.getBody().getNameOwner(), "TestName");
//    }
//
//
//	@Order(2)
//    @Test
//    public void shouldUpdateAccount() {
//
//        HttpEntity<Account> httpAccount = new HttpEntity<Account>
//                (new Account("TesteNameAlter", "0000",
//                        "00000000", "0", "000.000.000-00", null));
//
//        testRestTemplate.put("http://localhost:" + port + "/api/v1/accounts/edit/2", httpAccount, "id");
//
//        ResponseEntity<Account> response = testRestTemplate.exchange(
//                "http://localhost:" + port + "/api/v1/accounts/2", HttpMethod.GET, httpAccount, Account.class);
//
//        assertEquals(response.getStatusCode(), HttpStatus.OK);
//        assertEquals(response.getBody().getId(), 2);
//        assertEquals(response.getBody().getNameOwner(), "Name test changed");
//        assertEquals(response.getBody().getAccountCode(), "87654321");
//    }