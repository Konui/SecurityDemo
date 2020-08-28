package cn.kion.kionhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
public class KionhubApplication {

    public static void main(String[] args) {
        SpringApplication.run(KionhubApplication.class, args);
    }

}
