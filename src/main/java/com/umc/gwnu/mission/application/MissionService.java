package com.umc.gwnu.mission.application;

import com.umc.gwnu.global.apipayload.code.GeneralErrorCode;
import com.umc.gwnu.global.apipayload.exception.GeneralException;
import com.umc.gwnu.member.infrastructure.MemberRepository;
import com.umc.gwnu.mission.domain.MemberMission;
import com.umc.gwnu.mission.infrastructure.MemberMissionRepository;
import com.umc.gwnu.mission.infrastructure.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    public Long createMemberMission(Long memberId, Long missionId) {
        var member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        var mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(GeneralErrorCode.NOT_FOUND));

        MemberMission memberMission = MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();

        return memberMissionRepository.save(memberMission).getId();
    }
}
