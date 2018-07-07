package cn.nb.nbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 服务注册中心
 * @Author niuwang
 */
@SpringBootApplication
@EnableEurekaServer
public class NbServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbServerApplication.class, args);
    }
}
