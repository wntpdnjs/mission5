package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.Mission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.MissionDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    // 미션 목록 가져오기
    public List<MissionDto> getMissionList() {
        List<Mission> missions = missionRepository.findAll();
        return missions.stream()
                .map(mission -> new MissionDto(
                        mission.getId(),
                        mission.getMissionSpec(),
                        mission.getStore().getId())) // store 객체에서 ID 가져오기
                .collect(Collectors.toList());
    }

    // 미션 도전하기
    public String challengeMission(Long memberId, Long missionId) {
        // 1. Mission 테이블에서 해당 미션이 존재하는지 확인
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found with ID: " + missionId));

        // 2. MemberMission 테이블에서 이미 완료한 미션인지 확인
        MemberMission existingMission = memberMissionRepository.findByMemberIdAndMissionId(memberId, missionId);

        if (existingMission != null) {
            return "You have already completed this mission.";
        }

        // 3. 새로운 도전 추가
        MemberMission memberMission = toEntity(memberId, mission);

        memberMissionRepository.save(memberMission);
        return "Mission successfully challenged.";
    }

    // MemberMission 엔티티 생성 메서드
    private MemberMission toEntity(Long userId, Mission mission) {
        return MemberMission.builder()
                .userId(userId)
                .mission(mission)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .status("CHALLENGED")
                .build();
    }
}
