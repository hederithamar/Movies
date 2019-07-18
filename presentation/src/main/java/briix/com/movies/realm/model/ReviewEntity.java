package briix.com.movies.realm.model;

import io.realm.RealmObject;

public class ReviewEntity extends RealmObject {

    public static final String KEY_REVIEW = "ReviewEntity";
    protected String id;
    protected String author;
    protected String content;

    public ReviewEntity() {

    }

    public ReviewEntity(String id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
