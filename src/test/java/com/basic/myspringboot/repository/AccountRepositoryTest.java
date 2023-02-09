package com.basic.myspringboot.repository;

import com.basic.myspringboot.entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class AccountRepositoryTest {
    @Autowired
    AccountRepository reposotory;

    @Test
    public void account() {
        Account account = new Account();
        account.setUsername("boot");
        account.setUserpassword("boot1234");

        Account savedAccount = reposotory.save(account);
        assertEquals( "boot", savedAccount.getUsername() );
        assertEquals( "boot1234", savedAccount.getUserpassword() );
    }

    @Test
    public void account_select() {
        // given
        Optional<Account> optionalAccount = reposotory.findByUsername("boot");

        // when
        if(optionalAccount.isPresent()) {
            Account existAccount = optionalAccount.get();
            // then
            assertEquals("boot", existAccount.getUsername());
            log.info("Username : {}",  existAccount.getUsername());
        }
    }
}