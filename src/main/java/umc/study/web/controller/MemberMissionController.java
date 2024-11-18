package umc.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.service.MemberMissionService;
import umc.study.web.dto.MissionDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    // 미션 목록 가져오기
    @GetMapping("/missions")
    public ApiResponse<List<MissionDto>> getMissionList() {
        List<MissionDto> missions = memberMissionService.getMissionList();
        return ApiResponse.onSuccess(missions);
    }

    // 특정 미션 도전
    @PostMapping("/{memberId}/missions/{missionId}")
    public ApiResponse<String> challengeMission(
            @PathVariable Long memberId,
            @PathVariable Long missionId) {

        String result = memberMissionService.challengeMission(memberId, missionId);
        return ApiResponse.onSuccess(result);
    }
}
