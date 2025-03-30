package com.developer.chatApplication.controller;

import com.developer.chatApplication.common.Constant;
import com.developer.chatApplication.common.Path;
import com.developer.chatApplication.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping(Path.CHAT_REGISTER)
    @SendTo(Path.TOPIC_PUBLIC)
    public ChatMessage register(@Payload ChatMessage message, SimpMessageHeaderAccessor messageHeaderAccessor) {
        messageHeaderAccessor.getSessionAttributes().put(Constant.USERNAME, message.getSender());
        return message;
    }

    @MessageMapping(Path.CHAT_SEND)
    @SendTo(Path.TOPIC_PUBLIC)
    public ChatMessage sendMessage(@Payload ChatMessage message) {
        return message;
    }
}
