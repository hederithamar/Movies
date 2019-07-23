package briix.com.domain.entities;

public class Optional<T> {

    private T value;

    private static Optional instance;

    private Optional() {

    }

    private Optional(T value) {
        this.value = value;
    }

    public static <T> Optional of(T values) {

        return new Optional(values);
    }

    public static Optional empty() {

        return new Optional();
    }


    public boolean hasValue() {
        return value != null;
    }

    public final T getValue() {
        return this.value;
    }
}
