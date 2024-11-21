package umc.study.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface MemberQueryService {

    //Optional<Member> findMember(Long id);

    Member findMemberByMemberId(Long memberId);
    Page<MemberMission> getMissionList(Long memberId, Integer page);

    Page<Mission> getMissionListByStore(Long storeId, Integer page);
}