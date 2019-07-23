package briix.com.data.mappers.auth;

import javax.inject.Inject;
import javax.inject.Singleton;

import briix.com.data.mvp.model.response.ResponseToken;
import briix.com.domain.common.Mapper;
import briix.com.domain.entities.auth.TokenEntity;

@Singleton
public class TokenMapper extends Mapper<ResponseToken, TokenEntity> {

    @Inject
    public TokenMapper(){
    }

    @Override
    public TokenEntity mapFrom(ResponseToken from) {
        return new TokenEntity(
                from.getStatusCode(),
                from.getStatusMessage(),
                from.isSuccess(),
                from.getRequestToken());
    }
}
