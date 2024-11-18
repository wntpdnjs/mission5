package umc.study.service.MemberService;

import jakarta.transaction.Transactional;
import umc.study.domain.Member;
import umc.study.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    @Transactional
    Member joinMember(MemberRequestDTO.JoinDto request);
}
