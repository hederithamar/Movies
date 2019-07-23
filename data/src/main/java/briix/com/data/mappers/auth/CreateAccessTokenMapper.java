package briix.com.data.mappers.auth;

import javax.inject.Inject;
import javax.inject.Singleton;

import briix.com.data.mvp.model.response.ResponseCreateAccessToken;
import briix.com.domain.common.Mapper;
import briix.com.domain.entities.auth.CreateAccessTokenEntity;

@Singleton
public class CreateAccessTokenMapper extends Mapper<ResponseCreateAccessToken, CreateAccessTokenEntity> {

    @Inject
    public CreateAccessTokenMapper(){
    }

    @Override
    public CreateAccessTokenEntity mapFrom(ResponseCreateAccessToken from) {
        return new CreateAccessTokenEntity(
                from.getStatusCode(),
                from.getStatusMessage(),
                from.isSuccess(),
                from.getAccessToken(),
                from.getAccountId());
    }
}
