package ac.kr.kw.judge.user.dto.out;

import ac.kr.kw.judge.user.domain.User;

public class UserDto {
    private Long id;
    private String name;
    private int accumulateScore;
    private String rank;

    private UserDto(Long id, String name, int accumulateScore, String rank) {
        this.id = id;
        this.name = name;
        this.accumulateScore = accumulateScore;
        this.rank = rank;
    }

    public static UserDto fromEntity(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getAccumulateScore(), user.getRank().getValue());
    }
}
