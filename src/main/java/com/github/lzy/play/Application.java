package com.github.lzy.play;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stagemonitor.core.Stagemonitor;

/**
 * Description:
 *
 * @author liuzhengyang
 * @version 1.0
 * @since 2017-02-22
 */
@SpringBootApplication(scanBasePackages = "com.github.lzy.play")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
}
