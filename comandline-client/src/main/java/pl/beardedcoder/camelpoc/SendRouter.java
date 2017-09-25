package pl.beardedcoder.camelpoc;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("stream:in?promptMessage=> ")
                .log(LoggingLevel.INFO, "Sending message ${body}")
                .to("activemq:queue:ws-client");
    }
}
