package com.pickle.socket.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE :username MEMBER OF r.members")
    List<Room> findByUsernameInMembers(@Param("username") String username);
}
