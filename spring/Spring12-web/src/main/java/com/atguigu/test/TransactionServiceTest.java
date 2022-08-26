package com.atguigu.test;

import com.atguigu.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileNotFoundException;

@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testTransaction() {
        try {
            transactionService.multiUpdate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTransactionPropagation() {
        transactionService.multiTransactional();
    }

}
