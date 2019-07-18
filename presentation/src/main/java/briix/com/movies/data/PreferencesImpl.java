package briix.com.movies.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class PreferencesImpl implements Preferences {

    private static final String APP_PREFERENCES = "consar";
    private static final String APP_PREFERENCES_LEGACY = "e-sar";

    private static final String IS_LOGGED = "is_logged";

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

}
