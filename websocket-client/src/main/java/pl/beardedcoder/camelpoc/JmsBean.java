package pl.beardedcoder.camelpoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsBean {

    @JmsListener(destination = "global")
    public void receiver(String msg) {
        log.info("Message arrived: {}", msg);
    }
}
