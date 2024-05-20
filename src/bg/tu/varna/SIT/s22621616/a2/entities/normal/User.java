package bg.tu.varna.SIT.s22621616.a2.entities.normal;

import bg.tu.varna.SIT.s22621616.a2.enums.Authorization;

public class User extends BaseUser {
    private Authorization authorization;

    public User(String username, String password, boolean isAdmin) {
        super(username, password);
        this.authorization = Authorization.BASIC;
        if(isAdmin) {
            this.authorization = Authorization.ADMIN;
        }
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
}
