package briix.com.data.mvp.model.response;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMovies {

    @SerializedName("page")
    @Expose
    public int page;

    @SerializedName("total_results")
    @Expose
    public int totalResult;

    @SerializedName("total_pages")
    @Expose
    public int totalPages;

    @SerializedName("results")
    @Expose
    public List<ResponseMovie> movieList;

    public ResponseMovies(int page, int totalResult, int totalPages, List<ResponseMovie> movieList) {
        this.page = page;
        this.totalResult = totalResult;
        this.totalPages = totalPages;
        this.movieList = movieList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<ResponseMovie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<ResponseMovie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public String toString() {
        return " \n\"ResponseMovies\" : { " +
                " \n   \"status:\" : \"" + page + '\"' + "," +
                " \n   \"mensaje:\" : \"" + totalResult + '\"' + "," +
                " \n   \"success:\" : \"" + totalPages + '\"' + "," +
                " \n}";
    }
}
