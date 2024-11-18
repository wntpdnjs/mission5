package umc.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionDto {
    private Long id;
    private String missionSpec; // missionSpec 사용
    private Long storeId;
}
