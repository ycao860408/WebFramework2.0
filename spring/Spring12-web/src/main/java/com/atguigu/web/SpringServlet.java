package com.atguigu.web;

import com.atguigu.service.TransactionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "springServlet", value = "/springServlet")
public class SpringServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:bean.xml");
        TransactionService transactionService = cpx.getBean("transactionService", TransactionService.class);
        transactionService.multiTransactional();*/

        WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        TransactionService transactionService = wac.getBean("transactionService", TransactionService.class);
        transactionService.multiTransactional();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
