package com.basic.myspringboot.Runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MyRunner implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(MyRunner.class);
    @Value("${myboot.name}")
    private String name;

    @Value("${myboot.age}")
    private String age;

    @Autowired
    private DataSource datasource;

    @Autowired
    MybootProperties myBootProperties;

    public void run(ApplicationArguments args) throws Exception {
        logger.info("logger 구현객체 = {}", logger.getClass().getName());
        logger.info("datasource 구현객체 = {}", datasource.getClass().getName());
        logger.debug("Properties 설정값 name = {} : {}", name, myBootProperties.getName());
        logger.debug("Properties 설정값 age = {} : {}", age, myBootProperties.getAge());

        /*
        logger.debug("Profile : {}", hello);

        String fullName = environment.getProperty("myboot.fullName");
        logger.debug("Properties 설정값 fullName = " fullName);*/
        logger.info("VM Argument foo: " + args.containsOption("foo"));
        logger.info("program Argument bar : " + args.containsOption("bar"));
    }
}