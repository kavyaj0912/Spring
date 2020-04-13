package com.example.kavya.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.kavya.demo.model.account;
import com.example.kavya.demo.model.user;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) 

@FixMethodOrder(MethodSorters.DEFAULT)

public class DemoApplicationTests {
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }	 



@Test
public void testGetAlluser() {
HttpHeaders headers = new HttpHeaders();
   HttpEntity<String> entity = new HttpEntity<String>(null, headers);
   ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getAlluser",
   HttpMethod.GET, entity, String.class);  
   assertNotNull(response.getBody());
}

@Test
public void testUpdateuser() {
    int id = 1;
    user User = restTemplate.getForObject(getRootUrl() + "/updateuser/" + id, user.class);
    User.setFirstName("admin1");
    User.setLastName("admin2");
    restTemplate.put(getRootUrl() + "/updateuser/" + id, User);
    user updateduser = restTemplate.getForObject(getRootUrl() + "/updateuser/" + id, user.class);
    assertNotNull(updateduser);
}

@Test
public void testGetuserById() {
    user User = restTemplate.getForObject(getRootUrl() + "/getuser/1", user.class);
    System.out.println(User.getFirstName());
    assertNotNull(User);
}

@Test
public void testGetAllaccount() {
HttpHeaders headers = new HttpHeaders();
   HttpEntity<String> entity = new HttpEntity<String>(null, headers);
   ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/getAllaccount",
   HttpMethod.GET, entity, String.class);  
   assertNotNull(response.getBody());
}

@Test
public void testDeleteuser() {
     int id = 2;
     user User = restTemplate.getForObject(getRootUrl() + "/deleteuser/" + id, user.class);
     assertNotNull(User);
     restTemplate.delete(getRootUrl() + "/deleteuser/" + id);
     try {
          User = restTemplate.getForObject(getRootUrl() + "/deleteuser/" + id, user.class);
     } catch (final HttpClientErrorException e) {
          assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
     }

}

@Test
public void testUpdateaccount() {
    int id = 1;
    account Account = restTemplate.getForObject(getRootUrl() + "/updateaccount/" + id, account.class);
    Account.setAccountName("admin1");
    restTemplate.put(getRootUrl() + "/updateaccount/" + id, Account);
    account updatedaccount = restTemplate.getForObject(getRootUrl() + "/updateaccount/" + id, account.class);
    assertNotNull(updatedaccount);
}

@Test
public void testDeleteaccount() {
     int id = 2;
     account Account = restTemplate.getForObject(getRootUrl() + "/deleteaccount/" + id, account.class);
     assertNotNull(Account);
     restTemplate.delete(getRootUrl() + "/deleteaccount/" + id);
     try {
          Account = restTemplate.getForObject(getRootUrl() + "/deleteaccount/" + id, account.class);
     } catch (final HttpClientErrorException e) {
          assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
     }

}

}
