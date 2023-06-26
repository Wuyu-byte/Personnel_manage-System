package com.xlk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xlk.mapper")
@SpringBootApplication
public class XlkApplication {
    public static void main(String[] args) {
        SpringApplication.run(XlkApplication.class, args);
        System.out.println("                            _      _\n" +
                "  __ __   __ __   __ __    | |    | |__\n" +
                "  \\ \\ /   \\ \\ /   \\ \\ /    | |    | / /\n" +
                "  /_\\_\\   /_\\_\\   /_\\_\\   _|_|_   |_\\_\\\n" +
                "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|\n" +
                "\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\n");
    }
    }
