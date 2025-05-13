package com.pickle.socket.chat;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private String username;
    private Long room;
    private String content;
    private LocalDateTime timestamp;
    
    public Chat toEntity() {
        Chat chat = new Chat();
        chat.setUsername(this.username);
        chat.setRoom(this.room);
        chat.setContent(this.content);
        chat.setTimestamp(this.timestamp != null ? this.timestamp : LocalDateTime.now());
        return chat;
    }
} 