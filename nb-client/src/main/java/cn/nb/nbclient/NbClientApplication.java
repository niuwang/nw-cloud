package cn.nb.nbclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * 服务提供者
 * @Author niuwang
 */
@SpringBootApplication
@EnableEurekaClient
public class NbClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbClientApplication.class, args);
    }
}
