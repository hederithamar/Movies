package briix.com.domain.repositories;

import briix.com.domain.entities.auth.TokenEntity;
import briix.com.domain.entities.auth.CreateAccessTokenEntity;
import io.reactivex.Observable;

public interface  AuthRepository {

    Observable<TokenEntity> getToken(String redirectTo);

    Observable<CreateAccessTokenEntity> createAccessToken(String redirectTo);
}
