package briix.com.data.repositories.home;

import java.util.Map;

import briix.com.data.mappers.home.MoviesMapper;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.data.services.MovieApi;
import briix.com.domain.entities.home.MoviesEntity;
import briix.com.domain.repositories.HomeRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class MovieServices implements HomeRepository {
    MovieApi mMovieApi;
    MoviesMapper mMoviesMapper = new MoviesMapper();

    public MovieServices(MovieApi MovieApi) {
        mMovieApi = MovieApi;
    }

    @Override
    public Observable<MoviesEntity> getListMovies(int mListId, Map<String, String> mOptions) {
        return mMovieApi.getListMovies(mListId, mOptions).toObservable().map(new Function<ResponseMovies, MoviesEntity>() {
            @Override
            public MoviesEntity apply(ResponseMovies responseMovies) throws Exception {
                return mMoviesMapper.mapFrom(responseMovies);
            }
        });
    }

    @Override
    public Observable<MoviesEntity> getPopularMovies(Map<String, String> mOptions) {
        return mMovieApi.getPopularMovies(mOptions).toObservable().map(new Function<ResponseMovies, MoviesEntity>() {
            @Override
            public MoviesEntity apply(ResponseMovies responseMovies) throws Exception {
                return mMoviesMapper.mapFrom(responseMovies);
            }
        });
    }

    @Override
    public Observable<MoviesEntity> getTopRatedMovies(Map<String, String> mOptions) {
        return mMovieApi.getTopRatedMovies(mOptions).toObservable().map(new Function<ResponseMovies, MoviesEntity>() {
            @Override
            public MoviesEntity apply(ResponseMovies responseMovies) throws Exception {
                return mMoviesMapper.mapFrom(responseMovies);
            }
        });
    }

    @Override
    public Observable<MoviesEntity> getUpcomingMovies(Map<String, String> mOptions) {
        return mMovieApi.getUpcomingMovies(mOptions).toObservable().map(new Function<ResponseMovies, MoviesEntity>() {
            @Override
            public MoviesEntity apply(ResponseMovies responseMovies) throws Exception {
                return mMoviesMapper.mapFrom(responseMovies);
            }
        });
    }

    @Override
    public Observable<MoviesEntity> searchMovie(String movie, Map<String, String> mOptions) {
        return mMovieApi.searchMovie(movie, mOptions).toObservable().map(new Function<ResponseMovies, MoviesEntity>() {
            @Override
            public MoviesEntity apply(ResponseMovies responseMovies) throws Exception {
                return mMoviesMapper.mapFrom(responseMovies);
            }
        });
    }

    @Override
    public Observable<MoviesEntity> getMovieDetails(int id, Map<String, String> mOptions) {
        return mMovieApi.getMovieDetails(id, mOptions).toObservable().map(new Function<ResponseMovies, MoviesEntity>() {
            @Override
            public MoviesEntity apply(ResponseMovies responseMovies) throws Exception {
                return mMoviesMapper.mapFrom(responseMovies);
            }
        });
    }


}
