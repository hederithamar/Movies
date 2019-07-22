package briix.com.data.utils;

public final class ApiEndPoint {
    //Ruta para login
    public static final String ENDPOINT_REQUEST_TOKEN = "auth/request_token?";

    public static final String ENDPOINT_CREATE_ACCESS_TOKEN = "auth/access_token?";

    public static final String ENDPOINT_GET_LIST_MOVIES= "list/{list_id}?";

    public static final String ENDPOINT_POPULAR_MOVIES = "movie/popular?";

    public static final String ENDPOINT_TOP_RATED_MOVIES = "movie/top_rated?";

    public static final String ENDPOINT_UPCOMING_MOVIES = "movie/upcoming?";

    public static final String ENDPOINT_SEARCH_MOVIE = "movie/movie?";

    public static final String ENDPOINT_MOVIE_DEATAILS = "movie/{id}?append_to_response=videos,reviews?";

}
