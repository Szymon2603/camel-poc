package pl.beardedcoder.camelpoc;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MainRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("stream:in?promptMessage=:>")
                .log(LoggingLevel.INFO, "Message arrived")
                .to("stream:out");
    }
}
