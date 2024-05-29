package bg.tu.varna.SIT.s22621616.a2.entities.user.authorization;

public class User extends BaseUser {
    private Authorization authorization;

    public User(String username, String password, Authorization authorization) {
        super(username, password);
        this.authorization = authorization;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
}
