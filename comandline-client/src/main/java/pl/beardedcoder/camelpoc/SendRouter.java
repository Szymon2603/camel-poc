package pl.beardedcoder.camelpoc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendRouter extends RouteBuilder {

    @Override
    @SneakyThrows
    public void configure() {
        from("stream:in?promptMessage=>>> ")
                .log(LoggingLevel.INFO, "Sending message ${body}")
                .delay(10)
                .to("activemq:topic:ws-client");
    }
}
