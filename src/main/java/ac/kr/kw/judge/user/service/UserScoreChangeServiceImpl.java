package ac.kr.kw.judge.user.service;

import ac.kr.kw.judge.user.domain.User;
import ac.kr.kw.judge.user.domain.event.ChallengeFinished;
import ac.kr.kw.judge.user.domain.event.ParticipantResult;
import ac.kr.kw.judge.user.repository.UserRepository;
import ac.kr.kw.judge.user.service.port.in.UserScoreChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserScoreChangeServiceImpl implements UserScoreChangeService {
    private final UserRepository userRepository;

    @Override
    public void syncChallengeScoreToUser(ChallengeFinished challengeFinished) {
        Map<String, Integer> scoreByUsers = new HashMap<>();
        for (ParticipantResult result : challengeFinished.getParticipantResults()) {
            scoreByUsers.put(result.getUsername(), result.getChallengeScore());
        }
        List<User> users = userRepository.findUsersByUsernameIn(challengeFinished.getParticipantResults()
                .stream().map(participantResult -> participantResult.getUsername()).collect(Collectors.toList()));
        for (User user : users) {
            user.increaseScore(scoreByUsers.get(user.getUsername()));
        }
    }
}
