package ac.kr.kw.judge.user.domain.event;

public class ParticipantResult {
    private String username;
    private int challengeScore;

    public ParticipantResult() {
    }

    public String getUsername() {
        return username;
    }

    public int getChallengeScore() {
        return challengeScore;
    }
}
