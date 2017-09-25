package pl.beardedcoder.camelpoc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@Slf4j
public class WebSocketClient {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(WebSocketClient.class, args);
    }
}
