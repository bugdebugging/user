package ac.kr.kw.judge.user.adapter.in.event;

import ac.kr.kw.judge.user.domain.event.ChallengeFinished;
import ac.kr.kw.judge.user.service.port.in.UserScoreChangeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChallengeFinishListener {
    private final ObjectMapper objectMapper;
    private final UserScoreChangeService userScoreChangeService;

    @KafkaListener(topics = "challengeFinish", groupId = "user-consumer-group")
    public void consumeChallengeFinishEvent(String message) {
        try {
            ChallengeFinished challengeFinished = objectMapper.readValue(message, ChallengeFinished.class);
            userScoreChangeService.syncChallengeScoreToUser(challengeFinished);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
