package pl.beardedcoder.camelpoc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendService {

    @EndpointInject(uri = "activemq:topic:ws-client")
    ProducerTemplate producer;
    
    @Consume(uri = "stream:in?promptMessage=>>> ")
    public void sendMessage(@Body String body) {
        log.info("Sending message {}", body);
        producer.sendBody(body);
    }
}
