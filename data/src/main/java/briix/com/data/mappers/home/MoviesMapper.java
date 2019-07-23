package briix.com.data.mappers.home;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import briix.com.data.mvp.model.response.ResponseMovie;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.data.mvp.model.response.ResponseToken;
import briix.com.domain.common.Mapper;
import briix.com.domain.entities.auth.TokenEntity;
import briix.com.domain.entities.home.MovieEntity;
import briix.com.domain.entities.home.MoviesEntity;

@Singleton
public class MoviesMapper extends Mapper<ResponseMovies, MoviesEntity> {

    @Inject
    public MoviesMapper() {
    }

    @Override
    public MoviesEntity mapFrom(ResponseMovies from) {
        List<ResponseMovie> listFrom = from.getMovieList();
        List<MovieEntity> listDestination = new ArrayList<>();

        for (ResponseMovie item : listFrom) {
            listDestination.add(
                    new MovieEntity(
                            item.getVoteCount(),
                            item.getId(),
                            item.isVideo(),
                            item.getVoteAverage(),
                            item.getTitle(),
                            item.getPopularity(),
                            item.getPosterPath(),
                            item.getOriginalLanguages(),
                            item.getOriginalTitle(),
                            item.getGenreIds(),
                            item.getBackdropPath(),
                            item.isAdult(),
                            item.getOverview(),
                            item.getReleaseDate()
                    ));

        }


        return new MoviesEntity(
                from.getPage(),
                from.getTotalResult(),
                from.getTotalPages(),
                listDestination);
    }
}
