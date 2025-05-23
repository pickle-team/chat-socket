package com.pickle.socket.chat;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    List<Chat> findByRoomOrderByTimestampDesc(Long room);
}
