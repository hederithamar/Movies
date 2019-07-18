package briix.com.movies.realm.model;


import briix.com.data.mvp.model.response.ResponseMovie;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PopularMovieEntity extends RealmObject {

    public static final String KEY_MOVIE = "PopularMovieEntity";

    @PrimaryKey
    protected int id;
    protected int voteCount;
    protected boolean video;
    protected double voteAverage;
    protected double popularity;
    protected boolean adult;
    protected MovieDetailsEntity details;
    protected String title;
    protected String posterPath;
    protected String originalLanguage;
    protected String originalTitle;
    protected String backdropPath;
    protected String releaseDate;
    protected String overview;
    protected int service;

    public PopularMovieEntity() {
    }

    public PopularMovieEntity(ResponseMovie movie, int service) {
        this.id = movie.getId();
        this.voteCount = movie.getVoteCount();
        this.video = movie.isVideo();
        this.voteAverage = movie.getVoteAverage();
        this.popularity = movie.getPopularity();
        this.adult = movie.isAdult();
        //this.details = movie.getDetails();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.originalLanguage = movie.getOriginalLanguages();
        this.originalTitle = movie.getOriginalTitle();
        this.backdropPath = movie.getBackdropPath();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
        this.service = service;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public MovieDetailsEntity getDetails() {
        return details;
    }

    public void setDetails(MovieDetailsEntity details) {
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }
}
