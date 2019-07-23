package briix.com.domain.entities.auth;

public class CreateAccessTokenEntity {
    public int statusCode;
    public String statusMessage;
    public boolean success;
    public String accessToken;
    public String accountId;

    public CreateAccessTokenEntity(int statusCode, String statusMessage, boolean success, String accessToken, String accountId) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.success = success;
        this.accessToken = accessToken;
        this.accountId = accountId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
