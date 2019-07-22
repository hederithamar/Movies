package briix.com.data.di;

import android.content.Context;

import javax.inject.Inject;

import briix.com.data.preferences.Preferences;
import briix.com.data.preferences.PreferencesImpl;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class PreferencesModule {

    @Provides
    @Inject
    Preferences providePreferences(Context context) {
        return PreferencesImpl.getInstance(context);
    }

}