package umc.study.service.MemberService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.StoreRepository.StoreRepository;
import umc.study.repository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final MemberMissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MissionRepository missionMissionRepository;

    @Override
    public Member findMemberByMemberId(Long memberId) {
        return memberRepository.findByMemberId(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with memberId: " + memberId));
    }

    @Override
    public Page<MemberMission> getMissionList(Long memberId, Integer page) {
        // MemberId로 Member 객체를 조회
        Member member = memberRepository.findById(memberId).get();
                //.orElseThrow(() -> new IllegalArgumentException("Member not found with id: " + memberId));

        // MemberMission 테이블에서 해당 Member와 연결된 미션 목록을 가져옴 (페이지네이션 포함)
        Page<MemberMission> missionPage = missionRepository.findAllByMember(
                member,
                PageRequest.of(page, 10)
        );

        return missionPage;
    }

    @Override
    public Page<Mission> getMissionListByStore(Long storeId, Integer page) {
        // storeId로 Store 객체를 조회
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with id: " + storeId));

        // MemberMission 테이블에서 해당 Store와 연결된 미션 목록을 가져옴 (페이지네이션 포함)
        Page<Mission> missionPage = missionMissionRepository.findAllByStore(
                store,
                PageRequest.of(page, 10)
        );

        return missionPage;
    }



}
