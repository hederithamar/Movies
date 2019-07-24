package briix.com.data.mvp.model.request;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestToken {

    @SerializedName("redirect_to")
    @Expose
    public String redirectTo;

    public RequestToken(String redirectTo) {
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
        return " \n\"RequestToken\" : { " +
                " \n   \"redirect_to:\" : \"" + redirectTo + '\"' + "," +
                " \n}";
    }
}
