package cn.liy.messagedeliver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.liy.messagedeliver"})

public class MessageDeliverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageDeliverApplication.class, args);
    }

}
