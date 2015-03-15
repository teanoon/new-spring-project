package com.player.models.daos;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.player.configuration.PersistenceConfig;
import com.player.models.entities.Account;
import com.player.models.repositories.AccountRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class, loader = AnnotationConfigContextLoader.class)
public class AccountDaoTest {

    @Autowired
    private AccountRepo dao;

    private Account account;

    @Before
    @Transactional
    @Rollback(false)
    public void setup()
    {
        account = new Account();
        account.setLoginName("name");
        account.setPassword("password");
        dao.createAccount(account);
    }

    @Test
    @Transactional
    public void testFind()
    {
        assertNotNull(dao.findAccount(account.getId()));
    }
}