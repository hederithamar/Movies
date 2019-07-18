package briix.com.data.mvp.model.response;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMovie {

    @SerializedName("vote_count")
    @Expose
    public int voteCount;

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("video")
    @Expose
    public boolean video;

    @SerializedName("vote_average")
    @Expose
    public double voteAverage;

    @SerializedName("title")
    @Expose
    public String title;

    @SerializedName("popularity")
    @Expose
    public double popularity;

    @SerializedName("poster_path")
    @Expose
    public String posterPath;

    @SerializedName("original_language")
    @Expose
    public String originalLanguages;

    @SerializedName("original_title")
    @Expose
    public String originalTitle;

    @SerializedName("genre_ids")
    @Expose
    public List genreIds;

    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;

    @SerializedName("adult")
    @Expose
    public boolean adult;

    @SerializedName("overview")
    @Expose
    public String overview;

    @SerializedName("release_date")
    @Expose
    public String releaseDate;


    public ResponseMovie(int voteCount, int id, boolean video, double voteAverage, String title,
                         double popularity, String posterPath, String originalLanguages,
                         String originalTitle, List genreIds, String backdropPath, boolean adult,
                         String overview, String releaseDate) {
        this.voteCount = voteCount;
        this.id = id;
        this.video = video;
        this.voteAverage = voteAverage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguages = originalLanguages;
        this.originalTitle = originalTitle;
        this.genreIds = genreIds;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguages() {
        return originalLanguages;
    }

    public void setOriginalLanguages(String originalLanguages) {
        this.originalLanguages = originalLanguages;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @NonNull
    @Override
    public String toString() {
        return " \n\"ResponseMovie\" : { " +
                " \n   \"vote_count:\" : \"" + voteCount + '\"' + "," +
                " \n   \"id:\" : \"" + id + '\"' + "," +
                " \n   \"video:\" : \"" + video + '\"' + "," +
                " \n}";
    }
}
