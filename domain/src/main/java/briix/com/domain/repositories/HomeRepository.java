package briix.com.domain.repositories;

import java.util.Map;
import briix.com.domain.entities.home.MoviesEntity;
import io.reactivex.Observable;

public interface HomeRepository {

    Observable<MoviesEntity> getListMovies(int mListId, Map<String, String> mOptions);

    Observable<MoviesEntity> getPopularMovies(Map<String, String> mOptions);

    Observable<MoviesEntity> getTopRatedMovies(Map<String, String> mOptions);

    Observable<MoviesEntity> getUpcomingMovies(Map<String, String> mOptions);

    Observable<MoviesEntity> searchMovie(String movie, Map<String, String> mOptions);

    Observable<MoviesEntity> getMovieDetails(int id, Map<String, String> mOptions);
}
