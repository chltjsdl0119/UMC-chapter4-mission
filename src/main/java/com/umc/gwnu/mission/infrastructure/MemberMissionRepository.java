package com.umc.gwnu.mission.infrastructure;

import com.umc.gwnu.mission.domain.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
}
