package com.itechartgroup.telemed.video.controller;

import com.itechartgroup.telemed.security.CurrentUser;
import com.itechartgroup.telemed.security.UserPrincipal;
import com.itechartgroup.telemed.video.dto.VideoRoomCreateRequest;
import com.itechartgroup.telemed.video.dto.VideoRoomUpdateRequest;
import com.itechartgroup.telemed.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video")
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @PostMapping(value = "room", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createVideoRoom(@CurrentUser UserPrincipal currentUser, @RequestBody VideoRoomCreateRequest request) {
        return videoService.createVideoRoom(currentUser.getName(), request.getRoomId());
    }

    @GetMapping("room")
    public String getVideoRoom(@CurrentUser UserPrincipal currentUser, @Param("roomId") String roomId) {
        return videoService.joinRoom(currentUser, roomId);
    }

    @PutMapping("room")
    public ResponseEntity<String> finishVideoRoom(@Param("roomId") VideoRoomUpdateRequest request) {
        if (request.isFinished()) {
            videoService.finishVideoRoom(request.getRoomId());
        }
        return ResponseEntity.ok("Video finished");
    }

}