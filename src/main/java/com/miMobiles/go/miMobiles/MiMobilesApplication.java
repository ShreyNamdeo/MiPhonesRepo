package com.miMobiles.go.miMobiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class MiMobilesApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(MiMobilesApplication.class, args);
	}

}

