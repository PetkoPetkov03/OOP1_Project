package bg.tu.varna.SIT.s22621616.a2.entities.user.authorization;

/**
 * Represents a base user with a username and password.
 */
public abstract class BaseUser {
    private final String username;
    private final String password;

    /**
     * Constructs a BaseUser with the specified username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public BaseUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }
}
