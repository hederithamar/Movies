package briix.com.data.repositories.auth;

import briix.com.data.mappers.auth.CreateAccessTokenMapper;
import briix.com.data.mappers.auth.TokenMapper;
import briix.com.data.mvp.model.request.RequestCreateAccessToken;
import briix.com.data.mvp.model.request.RequestToken;
import briix.com.data.mvp.model.response.ResponseCreateAccessToken;

import briix.com.data.mvp.model.response.ResponseToken;
import briix.com.data.services.MovieApi;
import briix.com.domain.entities.auth.TokenEntity;
import briix.com.domain.entities.auth.CreateAccessTokenEntity;
import briix.com.domain.repositories.AuthRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class AuthServices implements AuthRepository {
    MovieApi mMovieApi;
    TokenMapper tokenMapper = new TokenMapper();
    CreateAccessTokenMapper createAccessTokenMapper = new CreateAccessTokenMapper();

    public AuthServices(MovieApi MovieApi) {
        mMovieApi = MovieApi;
    }

    @Override
    public Observable<TokenEntity> getToken(String redirectTo) {
        RequestToken mRequest = new RequestToken(redirectTo);
        return mMovieApi.getToken(mRequest).toObservable().map(new Function<ResponseToken, TokenEntity>() {
            @Override
            public TokenEntity apply(ResponseToken responseToken) throws Exception {
                return tokenMapper.mapFrom(responseToken);
            }
        });
    }


    @Override
    public Observable<CreateAccessTokenEntity> createAccessToken(String requestToken) {
        RequestCreateAccessToken mRequest = new RequestCreateAccessToken(requestToken);
        return mMovieApi.createAccessToken(mRequest).toObservable().map(new Function<ResponseCreateAccessToken, CreateAccessTokenEntity>() {
            @Override
            public CreateAccessTokenEntity apply(ResponseCreateAccessToken responseCreateAccessToken) throws Exception {
                return createAccessTokenMapper.mapFrom(responseCreateAccessToken);
            }
        });
    }

}
