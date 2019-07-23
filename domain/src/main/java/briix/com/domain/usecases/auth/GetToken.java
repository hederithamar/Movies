package briix.com.domain.usecases.auth;

import java.util.Map;

import briix.com.domain.common.Transformer;
import briix.com.domain.entities.auth.TokenEntity;
import briix.com.domain.repositories.AuthRepository;
import briix.com.domain.usecases.UseCase;
import io.reactivex.Observable;

public class GetToken extends UseCase<TokenEntity> {
    private static final String PARAM_REDIRECT_TO = "param:redirect_to";
    private AuthRepository authRepository;
    private Transformer<TokenEntity> transformer;

    public GetToken(Transformer<TokenEntity> transformer, AuthRepository authRepository ) {
        super(transformer);
        this.authRepository = authRepository;
    }

    @Override
    public Observable createObservable(Map<String, String> mData) {
        String redirectTo = mData.get(PARAM_REDIRECT_TO);
        return authRepository.getToken(redirectTo);
    }
}
