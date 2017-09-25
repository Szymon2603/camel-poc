package pl.beardedcoder.camelpoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class WebSocketController {

    private JmsTemplate jmsTemplate;
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketController(JmsTemplate jmsTemplate, SimpMessagingTemplate messagingTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    public void sendTo(@Payload String message) {
        log.info("Sending : {}", message);
        jmsTemplate.send("cmd-client", session -> session.createTextMessage(message));
    }

    @JmsListener(destination = "ws-client")
    public void receiver(String msg) {
        log.info("Message arrived: {}", msg);
        messagingTemplate.convertAndSend("/queue/client", msg);
    }

}
