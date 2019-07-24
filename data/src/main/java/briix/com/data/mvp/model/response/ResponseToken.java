package briix.com.data.mvp.model.response;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseToken {

    @SerializedName("status_code")
    @Expose
    public int statusCode;

    @SerializedName("status_message")
    @Expose
    public String statusMessage;

    @SerializedName("success")
    @Expose
    public boolean success;

    @SerializedName("request_token")
    @Expose
    public String requestToken;

    public ResponseToken(int statusCode, String statusMessage, boolean success, String requestToken) {
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

    @NonNull
    @Override
    public String toString() {
        return " \n\"ResponseToken\" : { " +
                " \n   \"status:\" : \"" + statusCode + '\"' + "," +
                " \n   \"mensaje:\" : \"" + statusMessage + '\"' + "," +
                " \n   \"success:\" : \"" + success + '\"' + "," +
                " \n   \"requestToken:\" : \"" + requestToken + '\"' + "," +
                " \n}";
    }
}
