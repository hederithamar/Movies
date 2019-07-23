package briix.com.domain.entities.auth;

public class TokenEntity {
    public int statusCode;
    public String statusMessage;
    public boolean success;
    public String requestToken;

    public TokenEntity(int statusCode, String statusMessage, boolean success, String requestToken) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.success = success;
        this.requestToken = requestToken;
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

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }
}
