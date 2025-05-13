package com.pickle.socket.chat;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
@CrossOrigin
public class ChatController {
    private final ChatRepository chatRepository;

    @GetMapping("/{room}")
    public List<Chat> getChatsByRoom(@PathVariable Long room) {
        return chatRepository.findByRoomOrderByTimestampDesc(room);
    }

    @PostMapping("/post")
    public Chat NewChat(@RequestBody Chat chat) {
        return chatRepository.save(chat);
    }
}
