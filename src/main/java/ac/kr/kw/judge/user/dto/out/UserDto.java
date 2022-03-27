package ac.kr.kw.judge.user.dto.out;

import ac.kr.kw.judge.user.domain.User;

public class UserDto {
    private Long id;
    private String name;
    private int accumulateScore;

    private UserDto(Long id, String name, int accumulateScore) {
        this.id = id;
        this.name = name;
        this.accumulateScore = accumulateScore;
    }

    public static UserDto fromEntity(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getAccumulateScore());
    }
}
