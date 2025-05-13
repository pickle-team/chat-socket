package com.pickle.socket.chat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatRepository chatRepository;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        log.info("Received message: {}", chatMessage);
        
        // 타임스탬프가 없는 경우 현재 시간 설정
        if (chatMessage.getTimestamp() == null) {
            chatMessage.setTimestamp(LocalDateTime.now());
        }
        
        // DB에 메시지 저장
        Chat savedChat = chatRepository.save(chatMessage.toEntity());
        
        // 클라이언트에게 메시지 전송
        messagingTemplate.convertAndSend(
            "/topic/chat." + chatMessage.getRoom(), 
            savedChat
        );
    }
} 