package ac.kr.kw.judge.commons.api;

public class SimpleMessage {
    private String message;

    private SimpleMessage(String message) {
        this.message = message;
    }

    public static SimpleMessage of(String message) {
        return new SimpleMessage(message);
    }

    public String getMessage() {
        return message;
    }
}
