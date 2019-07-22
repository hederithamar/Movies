package briix.com.data.preferences;

public interface Preferences {
    boolean isLogged();

    void setLogged(boolean status);

    String getAccountId();

    void setAccountId(String accountId);

    String getAccessToken();

    void setAccessToken(String accountId);
}
