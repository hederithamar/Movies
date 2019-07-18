package briix.com.data.mvp.model.response;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseCreateAccessToken {

    @SerializedName("status_code")
    @Expose
    public int statusCode;

    @SerializedName("status_message")
    @Expose
    public String statusMessage;

    @SerializedName("success")
    @Expose
    public boolean success;

    @SerializedName("access_token")
    @Expose
    public String accessToken;

    @SerializedName("account_id")
    @Expose
    public String accountId;

    public ResponseCreateAccessToken(int statusCode, String statusMessage, boolean success,
                                     String accessToken, String accountId) {
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

    @NonNull
    @Override
    public String toString() {
        return " \n\"ResponseCreateAccessToken\" : { " +
                " \n   \"status:\" : \"" + statusCode + '\"' + "," +
                " \n   \"mensaje:\" : \"" + statusMessage + '\"' + "," +
                " \n   \"success:\" : \"" + success + '\"' + "," +
                " \n   \"accessToken :\" : \"" + accessToken + '\"' + "," +
                " \n   \"accountId:\" : \"" + accountId + '\"' + "," +
                " \n}";
    }
}
