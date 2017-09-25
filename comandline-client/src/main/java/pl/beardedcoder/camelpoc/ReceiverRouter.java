package pl.beardedcoder.camelpoc;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ReceiverRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("activemq:topic:cmd-client")
                .log(LoggingLevel.INFO, "Receive message ${body}")
                .to("stream:out");
    }
}
