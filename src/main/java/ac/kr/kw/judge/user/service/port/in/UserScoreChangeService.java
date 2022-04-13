package ac.kr.kw.judge.user.service.port.in;

import ac.kr.kw.judge.user.domain.event.ChallengeFinished;

public interface UserScoreChangeService {
    void syncChallengeScoreToUser(ChallengeFinished challengeFinished);
}
