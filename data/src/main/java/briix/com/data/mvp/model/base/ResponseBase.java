package briix.com.data.mvp.model.base;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBase {

    @SerializedName("status_code")
    @Expose
    public int status;
    @SerializedName("status_message")
    @Expose
    public String message;
    @SerializedName("success")
    @Expose
    public boolean success;

    public ResponseBase(int status, String message, boolean success) {
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @NonNull
    @Override
    public String toString() {
        return " \n\"ResponseBase\" : { " +
                " \n   \"status:\" : \"" + status + '\"' + "," +
                " \n   \"mensaje:\" : \"" + message + '\"' + "," +
                " \n   \"success:\" : \"" + success + '\"' + "," +
                " \n}";
    }
}
