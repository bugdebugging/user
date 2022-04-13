package ac.kr.kw.judge.user.domain.event;

import java.util.List;

public class ChallengeFinished {
    private Long challengeId;
    private List<ParticipantResult> participantResults;

    public ChallengeFinished() {
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public List<ParticipantResult> getParticipantResults() {
        return participantResults;
    }

}
