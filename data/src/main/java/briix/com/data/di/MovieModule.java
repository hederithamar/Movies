package briix.com.data.di;

import javax.inject.Singleton;

import briix.com.data.mvp.presenter.MovieMvpPresenter;
import briix.com.data.mvp.presenter.MoviePresenter;
import briix.com.data.mvp.view.MovieView;
import briix.com.data.preferences.Preferences;
import briix.com.data.preferences.PreferencesImpl;
import briix.com.data.services.MovieApi;
import briix.com.data.services.MovieServices;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiMovieModule.class})
public class MovieModule {

    @Provides
    @Singleton
    public MovieServices provideMovieServices(final MovieApi movieApi) {
        return new MovieServices(movieApi);
    }

    @Provides
    public MovieMvpPresenter<MovieView> provideMoviePresenter(MovieServices movieServices) {
        return new MoviePresenter<>(movieServices);
    }
}
