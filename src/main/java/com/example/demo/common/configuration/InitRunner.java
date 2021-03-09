package com.example.demo.common.configuration;

import java.sql.DatabaseMetaData;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


public class InitRunner implements CommandLineRunner{

    @Autowired
    private DataSource ds;

    Logger logger = LoggerFactory.getLogger(InitRunner.class);

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        DatabaseMetaData md = ds.getConnection().getMetaData();
        logger.info("{}", md.getDriverName());
        logger.info("{}", md.getURL());
        logger.info("{}", md.getUserName());
    }
    
}
