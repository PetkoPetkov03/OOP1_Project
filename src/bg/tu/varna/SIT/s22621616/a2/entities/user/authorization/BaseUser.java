package bg.tu.varna.SIT.s22621616.a2.entities.user.authorization;

public abstract class BaseUser {
    private String username;
    private String password;

    public BaseUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}
