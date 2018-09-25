package com.hb.start_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hb.start_boot.dao")
public class StartBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartBootApplication.class, args);
	}
}
