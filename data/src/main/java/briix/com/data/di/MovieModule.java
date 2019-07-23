package briix.com.data.di;

import javax.inject.Singleton;

import briix.com.data.mvp.presenter.MovieMvpPresenter;
import briix.com.data.mvp.presenter.MoviePresenter;
import briix.com.data.mvp.view.MovieView;
import briix.com.data.repositories.auth.AuthServices;
import briix.com.data.services.MovieApi;
import briix.com.data.repositories.home.MovieServices;
import briix.com.domain.repositories.AuthRepository;
import briix.com.domain.repositories.HomeRepository;
import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiMovieModule.class})
public class MovieModule {

    @Provides
    @Singleton
    public HomeRepository provideHomeRepository(final MovieApi movieApi) {
        return new MovieServices(movieApi);
    }

    @Provides
    @Singleton
    public AuthRepository provideAuthRepository(final MovieApi movieApi){
        return new AuthServices(movieApi);
    }

    @Provides
    public MovieMvpPresenter<MovieView> provideMoviePresenter(HomeRepository homeRepository, AuthRepository authRepository) {
        return new MoviePresenter<>(homeRepository, authRepository);
    }
}
