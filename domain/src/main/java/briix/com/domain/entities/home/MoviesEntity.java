package briix.com.domain.entities.home;


import java.util.List;

public class MoviesEntity {


    public int page;

    public int totalResult;

    public int totalPages;

    public List<MovieEntity> movieList;

    public MoviesEntity(int page, int totalResult, int totalPages, List<MovieEntity> movieList) {
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

    public List<MovieEntity> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieEntity> movieList) {
        this.movieList = movieList;
    }
}
