package com.stereo.websocketdemo.controller;

import com.stereo.websocketdemo.model.Message;
import com.stereo.websocketdemo.service.WSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WSController {
    @Autowired
    WSService wsService;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody Message message){
        wsService.sendMessage(message.getMessageContent());
    }

    @PostMapping("/send-private-message/{id}")
    public void sendPrivateMessage(@RequestBody Message message, @PathVariable String id){
        wsService.sendPrivateMessage(message.getMessageContent(),id);
    }

    @RequestMapping(value = "/send-notification-global",method = RequestMethod.POST)
    public void sendNotification(@RequestBody Message message){
        System.out.println("hello");
        wsService.sendNotification(message.getMessageContent());
    }

    @RequestMapping(value = "/send-notification-private/{id}",method = RequestMethod.POST)
    public void sendPrivateNotification(@RequestBody Message message, @PathVariable String id){
        wsService.sendPrivateNotification(message.getMessageContent(),id);
    }
}
