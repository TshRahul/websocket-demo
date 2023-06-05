package com.stereo.websocketdemo.controller;

import com.stereo.websocketdemo.model.Message;
import com.stereo.websocketdemo.model.ResponseMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/receive/message")
    public ResponseMessage getMessage(final Message message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("recived message");
        return new ResponseMessage("Hello, " + HtmlUtils.htmlEscape(message.getMessageContent()) + "!");
    }
}
