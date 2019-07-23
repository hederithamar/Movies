package briix.com.domain.common;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import briix.com.domain.entities.Optional;
import io.reactivex.Observable;

public abstract class Mapper<E, T> {

    public abstract T mapFrom(E from);

    public final Optional<T> mapOptional(Optional<E> from) {
        E value = from.getValue();
        if (value != null) {
            return Optional.of(this.mapFrom(value));
        } else {
            return Optional.empty();
        }
    }

    public final Observable<T> observable(final E from) {
        return Observable.fromCallable(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return mapFrom(from);
            }
        });
    }

    public final Observable<List<T>> observable(final List<E> from) {
        return Observable.fromCallable(new Callable<List<T>>() {
            @Override
            public List<T> call() throws Exception {
                List<E> start = from;
                List<T> destination = new ArrayList<>();

                for (E item: start) {
                    T var = mapFrom(item);
                    destination.add(var);
                }

                return destination;
            }
        });
    }

}
