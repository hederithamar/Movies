package briix.com.movies.realm.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class MovieDetailsEntity extends RealmObject {

    public static final String KEY_MOVIE_DETAILS = "MovieDetailsEntity";

    protected String imdbId;
    protected int budget;
    protected String homepage;
    protected String overview;
    protected int revenue;
    protected int runtime;
    protected String status;
    protected String tagline;
    protected RealmList<ReviewEntity> reviews;
    protected RealmList<VideoEntity> videos;
    protected RealmList<GenreEntity> genres;

    public MovieDetailsEntity() {
    }

    public MovieDetailsEntity(String imdbId, int budget, String homepage, String overview,
                              int revenue, int runtime, String status, String tagline,
                              RealmList<ReviewEntity> reviews, RealmList<VideoEntity> videos,
                              RealmList<GenreEntity> genres) {
        this.imdbId = imdbId;
        this.budget = budget;
        this.homepage = homepage;
        this.overview = overview;
        this.revenue = revenue;
        this.runtime = runtime;
        this.status = status;
        this.tagline = tagline;
        this.reviews = reviews;
        this.videos = videos;
        this.genres = genres;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public RealmList<ReviewEntity> getReviews() {
        return reviews;
    }

    public void setReviews(RealmList<ReviewEntity> reviews) {
        this.reviews = reviews;
    }

    public RealmList<VideoEntity> getVideos() {
        return videos;
    }

    public void setVideos(RealmList<VideoEntity> videos) {
        this.videos = videos;
    }

    public RealmList<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(RealmList<GenreEntity> genres) {
        this.genres = genres;
    }
}
