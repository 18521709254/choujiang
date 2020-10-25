package com.zwy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.zwy"})
public class PackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackingApplication.class, args);
	}

}
