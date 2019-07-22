package briix.com.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;


public class PreferencesImpl implements Preferences {

    private static final String APP_PREFERENCES = "consar";
    private static final String APP_PREFERENCES_LEGACY = "e-sar";

    private static final String IS_LOGGED = "is_logged";
    private static final String ACCOUNT_ID = "account_id";
    private static final String ACCESS_TOKEN = "access_token";

    private static PreferencesImpl mInstance;
    private final SharedPreferences preferences;
    private final SharedPreferences preferencesLegacy;
    private final Context mContext;


    public PreferencesImpl(Context context) {
        mContext = context;
        preferences = mContext.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        preferencesLegacy = mContext.getSharedPreferences(APP_PREFERENCES_LEGACY, Context.MODE_PRIVATE);
    }

    public static synchronized Preferences getInstance(@NonNull Context context) {
        if (mInstance == null) {
            mInstance = new PreferencesImpl(context);
        }
        return mInstance;
    }


    public boolean isLogged() {
        return preferences.getBoolean(IS_LOGGED, false);
    }

    @Override
    public void setLogged(boolean status) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(IS_LOGGED);
        editor.apply();
    }

    @Override
    public String getAccountId() {
        return preferences.getString(ACCOUNT_ID, "");
    }

    @Override
    public void setAccountId(String accountId) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(ACCOUNT_ID);
        editor.apply();
    }

    @Override
    public String getAccessToken() {
        return preferences.getString(ACCESS_TOKEN, "");
    }

    @Override
    public void setAccessToken(String accountId) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(ACCESS_TOKEN);
        editor.apply();
    }
}
