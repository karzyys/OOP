
public class OAuthLogin implements ILogin {
    private String validToken;

    public OAuthLogin(String token) {
        this.validToken = token;
    }

    @Override
    public boolean authenticate(String username, String token) {
        return validToken.equals(token);
    }
}

