package com.umc.gwnu.mission.presentation;

import com.umc.gwnu.global.apipayload.CommonResponse;
import com.umc.gwnu.mission.application.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<CommonResponse<Long>> createMemberMission(@RequestParam Long missionId, @RequestParam Long memberId) {
        Long memberMissionId = missionService.createMemberMission(memberId, missionId);
        return ResponseEntity.ok(CommonResponse.onSuccess(memberMissionId));
    }
}
