package ac.kr.kw.judge.user.service.command;

public class AuthLoginCommand {
    private String username;
    private String password;

    public AuthLoginCommand(String username, String password) {
        checkArgument();

        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
