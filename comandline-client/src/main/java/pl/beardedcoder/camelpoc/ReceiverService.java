package pl.beardedcoder.camelpoc;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Body;
import org.apache.camel.Consume;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverService {

    @EndpointInject(uri="stream:out")
    ProducerTemplate producer;

    @Consume(uri = "activemq:topic:cmd-client")
    public void onMessage(@Body String body) {
        log.info("Message arrived: {}", body);
        producer.sendBody(body);
    }
}
