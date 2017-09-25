package pl.beardedcoder.camelpoc;

import lombok.SneakyThrows;
import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
public class ActivemqBrokerApplication {

    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(ActivemqBrokerApplication.class, args);
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61616");
        broker.start();
    }
}
