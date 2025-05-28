
public class BasicLogin implements ILogin {
    private String validUsername;
    private String validPassword;

    public BasicLogin(String username, String password) {
        this.validUsername = username;
        this.validPassword = password;
    }

    @Override
    public boolean authenticate(String username, String password) {
        return validUsername.equals(username) && validPassword.equals(password);
    }
}

