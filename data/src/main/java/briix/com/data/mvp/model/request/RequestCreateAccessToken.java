package briix.com.data.mvp.model.request;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestCreateAccessToken {

    @SerializedName("request_token")
    @Expose
    public String redirectTo;

    public RequestCreateAccessToken(String redirectTo) {
        this.redirectTo = redirectTo;
    }

    public String getRedirectTo() {
        return redirectTo;
    }

    public void setRedirectTo(String redirectTo) {
        this.redirectTo = redirectTo;
    }

    @NonNull
    @Override
    public String toString() {
        return " \n\"RequestCreateAccessToken\" : { " +
                " \n   \"request_token:\" : \"" + redirectTo + '\"' + "," +
                " \n}";
    }
}
