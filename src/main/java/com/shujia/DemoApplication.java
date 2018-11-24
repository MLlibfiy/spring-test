package com.shujia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

/**
 * 自动扫面包下面的加了@Component注解的类，并创建对象，当道spring容器里面
 *
 */
@ComponentScan(basePackages = "com.shujia")
public class DemoApplication {

	/**
	 * 启动spark容器
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
