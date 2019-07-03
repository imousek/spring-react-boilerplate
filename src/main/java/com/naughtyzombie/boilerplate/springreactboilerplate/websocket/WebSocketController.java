package com.naughtyzombie.boilerplate.springreactboilerplate.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Controller
@Slf4j
public class WebSocketController {

    private final SimpMessagingTemplate template;
    LogManager lgmngr = LogManager.getLogManager(); 
    Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Autowired
    WebSocketController(SimpMessagingTemplate template){
        this.template = template;
    }

	@Scheduled(fixedRate = 5000)
    public void sendUpdate() {
		String formattedDate = DateFormat.getTimeInstance().format(new Date());
		//log.debug("Sending Update {}", formattedDate);
		this.template.convertAndSend("/topic/update", formattedDate);
	}

	@MessageMapping("/hello")
	public String greeting(String message) throws Exception {
		//log.info("Message received {}", message);
		return String.format("Hello %s ", message);
	}
}
