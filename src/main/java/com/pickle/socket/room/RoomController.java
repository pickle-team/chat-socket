package com.pickle.socket.room;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomRepository roomRepository;

    @GetMapping("get")
    @ResponseBody
    public List<Room> getRoomsByUsername(@RequestParam String username) {
        return roomRepository.findByUsernameInMembers(username);
    }

    @PostMapping("add")
    @ResponseBody
    public Room AddRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }
}
