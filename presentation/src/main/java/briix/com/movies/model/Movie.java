package briix.com.movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Locale;

import briix.com.data.mvp.model.response.ResponseMovie;
import briix.com.movies.realm.model.ComingMovieEntity;
import briix.com.movies.realm.model.GeneralMovieEntity;
import briix.com.movies.realm.model.MovieDetailsEntity;
import briix.com.movies.realm.model.TopRatedMovieEntity;
import briix.com.movies.realm.model.PopularMovieEntity;
import io.realm.annotations.PrimaryKey;

public class Movie implements Parcelable {

    public static final String KEY_MOVIE = "Movie";
    public static final String posterBaseUrl = "https://image.tmdb.org/t/p/w342";
    public static final String posterSmallBaseUrl = "https://image.tmdb.org/t/p/w185";
    public static final String backdropBaseUrl = "https://image.tmdb.org/t/p/w780";
    public static final String youTubeBaseUrl = "https://www.youtube.com/watch?v=";

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
    protected String posterSmallPath;
    protected String originalLanguage;
    protected String originalTitle;
    protected String backdropPath;
    protected String releaseDate;
    protected String overview;
    protected int service;

    public Movie() {
    }

    public Movie(ResponseMovie movie, int service) {
        this.id = movie.getId();
        this.voteCount = movie.getVoteCount();
        this.video = movie.isVideo();
        this.voteAverage = movie.getVoteAverage();
        this.popularity = movie.getPopularity();
        this.adult = movie.isAdult();
        //this.details = movie.getDetails();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.posterSmallPath = movie.getPosterPath();
        this.originalLanguage = movie.getOriginalLanguages();
        this.originalTitle = movie.getOriginalTitle();
        this.backdropPath = movie.getBackdropPath();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
        this.service = service;
    }

    public Movie(GeneralMovieEntity movie) {
        this.id = movie.getId();
        this.voteCount = movie.getVoteCount();
        this.video = movie.isVideo();
        this.voteAverage = movie.getVoteAverage();
        this.popularity = movie.getPopularity();
        this.adult = movie.isAdult();
        //this.details = movie.getDetails();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.posterSmallPath = movie.getPosterPath();
        this.originalLanguage = movie.getOriginalLanguage();
        this.originalTitle = movie.getOriginalTitle();
        this.backdropPath = movie.getBackdropPath();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
        this.service = service;
    }


    public Movie(TopRatedMovieEntity movie) {
        this.id = movie.getId();
        this.voteCount = movie.getVoteCount();
        this.video = movie.isVideo();
        this.voteAverage = movie.getVoteAverage();
        this.popularity = movie.getPopularity();
        this.adult = movie.isAdult();
        //this.details = movie.getDetails();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.posterSmallPath = movie.getPosterPath();
        this.originalLanguage = movie.getOriginalLanguage();
        this.originalTitle = movie.getOriginalTitle();
        this.backdropPath = movie.getBackdropPath();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
        this.service = service;
    }

    public Movie(PopularMovieEntity movie) {
        this.id = movie.getId();
        this.voteCount = movie.getVoteCount();
        this.video = movie.isVideo();
        this.voteAverage = movie.getVoteAverage();
        this.popularity = movie.getPopularity();
        this.adult = movie.isAdult();
        //this.details = movie.getDetails();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.posterSmallPath = movie.getPosterPath();
        this.originalLanguage = movie.getOriginalLanguage();
        this.originalTitle = movie.getOriginalTitle();
        this.backdropPath = movie.getBackdropPath();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
        this.service = service;
    }

    public Movie(ComingMovieEntity movie) {
        this.id = movie.getId();
        this.voteCount = movie.getVoteCount();
        this.video = movie.isVideo();
        this.voteAverage = movie.getVoteAverage();
        this.popularity = movie.getPopularity();
        this.adult = movie.isAdult();
        //this.details = movie.getDetails();
        this.title = movie.getTitle();
        this.posterPath = movie.getPosterPath();
        this.posterSmallPath = movie.getPosterPath();
        this.originalLanguage = movie.getOriginalLanguage();
        this.originalTitle = movie.getOriginalTitle();
        this.backdropPath = movie.getBackdropPath();
        this.releaseDate = movie.getReleaseDate();
        this.overview = movie.getOverview();
        this.service = service;
    }


    protected Movie(Parcel in) {
        id = in.readInt();
        voteCount = in.readInt();
        video = in.readByte() != 0;
        voteAverage = in.readDouble();
        popularity = in.readDouble();
        adult = in.readByte() != 0;
        title = in.readString();
        posterPath = in.readString();
        posterSmallPath = in.readString();
        originalLanguage = in.readString();
        originalTitle = in.readString();
        backdropPath = in.readString();
        releaseDate = in.readString();
        overview = in.readString();
        service = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

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
        return posterBaseUrl + posterPath;
    }

    public String getPosterSmallPath() {
        return posterSmallBaseUrl + posterSmallPath;
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
        return backdropBaseUrl + backdropPath;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(voteCount);
        dest.writeByte((byte) (video ? 1 : 0));
        dest.writeDouble(voteAverage);
        dest.writeDouble(popularity);
        dest.writeByte((byte) (adult ? 1 : 0));
        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeString(posterSmallPath);
        dest.writeString(originalLanguage);
        dest.writeString(originalTitle);
        dest.writeString(backdropPath);
        dest.writeString(releaseDate);
        dest.writeString(overview);
        dest.writeInt(service);
    }
}
