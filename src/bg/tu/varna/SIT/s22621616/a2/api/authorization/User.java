package bg.tu.varna.SIT.s22621616.a2.api.authorization;

/**
 * Represents a user with a username, password, and authorization level.
 */
public class User extends BaseUser {
    private Authorization authorization;

    /**
     * Constructs a User with the specified username, password, and authorization.
     *
     * @param username     The username of the user.
     * @param password     The password of the user.
     * @param authorization The authorization level of the user.
     */
    public User(String username, String password, Authorization authorization) {
        super(username, password);
        this.authorization = authorization;
    }

    /**
     * Returns the authorization level of the user.
     *
     * @return The user's authorization.
     */
    public Authorization getAuthorization() {
        return authorization;
    }

    /**
     * Sets the authorization level of the user.
     *
     * @param authorization The new authorization level for the user.
     */
    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }
}
