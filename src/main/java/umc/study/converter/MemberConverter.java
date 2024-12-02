package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getMemberId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .role(request.getRole())   // 추가된 코드
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission memberMission) {
        return MemberResponseDTO.MissionPreViewDTO.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .status(memberMission.getStatus().name())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .point(memberMission.getMission().getReward())
                .build();
    }
    public static MemberResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<MemberMission> missionList){

        List<MemberResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }

    public static MemberResponseDTO.MissionPreViewStoreDTO missionPreViewStoreDTO(Mission mission) {
        return MemberResponseDTO.MissionPreViewStoreDTO.builder()
                .store(mission.getStore().getName())
                .reward(mission.getReward().toString())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewListStoreDTO missionPreViewListStoreDTO(Page<Mission> missionstoreList){

        List<MemberResponseDTO.MissionPreViewStoreDTO> missionPreViewDTOList = missionstoreList.stream()
                .map(MemberConverter::missionPreViewStoreDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreViewListStoreDTO.builder()
                .isLast(missionstoreList.isLast())
                .isFirst(missionstoreList.isFirst())
                .totalPage(missionstoreList.getTotalPages())
                .totalElements(missionstoreList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionstoreList(missionPreViewDTOList)
                .build();
    }

}