package briix.com.movies.di;


import javax.inject.Singleton;

import briix.com.data.di.MovieModule;
import briix.com.movies.ui.activities.SplashActivity;
import briix.com.movies.ui.fragments.SplashFragment;
import dagger.Component;

@Singleton
@Component(modules = {MovieModule.class})
public interface AppComponent {
    void inject(SplashActivity activity);
    void inject(SplashFragment fragment);
}
