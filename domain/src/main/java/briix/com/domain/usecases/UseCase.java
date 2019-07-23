package briix.com.domain.usecases;

import java.util.Map;

import briix.com.domain.common.Transformer;
import io.reactivex.Observable;

public abstract class UseCase<T> {

    private Transformer<T> transformer;

    public UseCase(Transformer<T> transformer) {
        this.transformer = transformer;
    }

    public abstract Observable<T> createObservable(Map<String, String> mOptions);

    public Observable<T> observable (Map<String, String> mOptions) {

        return createObservable(mOptions).compose(transformer);
    }


}
