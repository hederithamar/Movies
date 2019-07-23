package briix.com.movies.realm;

import java.util.List;

import briix.com.data.mvp.model.response.ResponseMovie;
import briix.com.data.mvp.model.response.ResponseMovies;
import briix.com.movies.realm.model.ComingMovieEntity;
import briix.com.movies.realm.model.GeneralMovieEntity;
import briix.com.movies.realm.model.PopularMovieEntity;
import briix.com.movies.realm.model.TopRatedMovieEntity;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

import static briix.com.data.MServicesMovie.GET_LIST_MOVIES;
import static briix.com.data.MServicesMovie.GET_POPULAR_MOVIES;
import static briix.com.data.MServicesMovie.GET_TOP_RATED_MOVIES;
import static briix.com.data.MServicesMovie.GET_UPCOMING_MOVIES;


public class MasterCatalog extends RealmObject {

    public MasterCatalog() {

    }

    @PrimaryKey
    private int page;
    private int total_results;
    private int total_pages;
    private RealmList<GeneralMovieEntity> movieGeneralList;
    private RealmList<PopularMovieEntity> moviePopularList;
    private RealmList<TopRatedMovieEntity> movieTopList;
    private RealmList<ComingMovieEntity> movieComingList;

    public MasterCatalog(ResponseMovies response, int service) {
        buildRealmListObjects(response, service);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }


    public RealmList<PopularMovieEntity> getMoviePopularList() {
        return moviePopularList;
    }

    public void setMoviePopularList(RealmList<PopularMovieEntity> moviePopularList) {
        this.moviePopularList = moviePopularList;
    }

    public RealmList<TopRatedMovieEntity> getMovieTopList() {
        return movieTopList;
    }

    public void setMovieTopList(RealmList<TopRatedMovieEntity> movieTopList) {
        this.movieTopList = movieTopList;
    }

    public RealmList<ComingMovieEntity> getMovieComingList() {
        return movieComingList;
    }

    public void setMovieComingList(RealmList<ComingMovieEntity> movieComingList) {
        this.movieComingList = movieComingList;
    }

    public RealmList<GeneralMovieEntity> getMovieGeneralList() {
        return movieGeneralList;
    }

    public void setMovieGeneralList(RealmList<GeneralMovieEntity> movieGeneralList) {
        this.movieGeneralList = movieGeneralList;
    }

    private void buildRealmListObjects(ResponseMovies response, int service) {

        switch (service) {
            case GET_LIST_MOVIES:
                movieGeneralList = new RealmList<>();
                List<ResponseMovie> mGeneralList = response.getMovieList();
                if (mGeneralList != null)
                    for (ResponseMovie movie : mGeneralList) {
                        movieGeneralList.add(new GeneralMovieEntity(movie, service));
                    }
                break;
            case GET_POPULAR_MOVIES:
                moviePopularList = new RealmList<>();
                List<ResponseMovie> mPopularList = response.getMovieList();
                if (mPopularList != null)
                    for (ResponseMovie movie : mPopularList) {
                        moviePopularList.add(new PopularMovieEntity(movie, service));
                    }
                break;
            case GET_TOP_RATED_MOVIES:
                movieTopList = new RealmList<>();
                List<ResponseMovie> mTopList = response.getMovieList();
                if (mTopList != null)
                    for (ResponseMovie movie : mTopList) {
                        movieTopList.add(new TopRatedMovieEntity(movie, service));
                    }
                break;
            case GET_UPCOMING_MOVIES:
                movieComingList = new RealmList<>();
                List<ResponseMovie> mComingList = response.getMovieList();
                if (mComingList != null)
                    for (ResponseMovie psCountry : mComingList) {
                        movieComingList.add(new ComingMovieEntity(psCountry, service));
                    }
                break;
        }


        page = response.getPage();
        total_results = response.getTotalResult();
        total_pages = response.getTotalPages();
    }
}
