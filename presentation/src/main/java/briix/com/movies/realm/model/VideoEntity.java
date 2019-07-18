package briix.com.movies.realm.model;

import io.realm.RealmObject;

public class VideoEntity extends RealmObject {

    public static final String KEY_VIDEO = "VideoEntity";
    public static final String SOURCE_YOUTUBE = "YouTube";
    public static final String TYPE_TRAILER = "Trailer";

    protected String id;
    protected String name;
    protected String youtubeKey;

    public VideoEntity() {

    }

    public VideoEntity(String id, String name, String youtubeKey) {
        this.id = id;
        this.name = name;
        this.youtubeKey = youtubeKey;
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

    public String getYoutubeKey() {
        return youtubeKey;
    }

    public void setYoutubeKey(String youtubeKey) {
        this.youtubeKey = youtubeKey;
    }
}
