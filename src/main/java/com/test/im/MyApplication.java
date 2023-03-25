package com.test.im;

import com.test.im.netty.CoordinationNettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.test.im.dao")
public class MyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
    @Autowired
    private CoordinationNettyServer nettyServer;

    @Override
    public void run(String... args) throws Exception {
        nettyServer.start();
    }
}
