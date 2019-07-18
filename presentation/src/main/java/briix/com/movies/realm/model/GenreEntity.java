package briix.com.movies.realm.model;

import io.realm.RealmObject;

public class GenreEntity extends RealmObject {

    public static final String KEY_GENRE = "GenreEntity";
    protected String id;
    protected String name;

    public GenreEntity() {

    }

    public GenreEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
