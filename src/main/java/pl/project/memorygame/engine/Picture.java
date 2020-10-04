package pl.project.memorygame.engine;

public class Picture {
    private Integer picId;
    private String link;

    public Picture(Integer picVal) {
        picId = picVal;
        link = "https://picsum.photos/id/" + picVal + "/310/310";
    }

    public String getLink() {
        return link;
    }

    public Integer getPicId() {
        return picId;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "picId=" + picId +
                ", link='" + link + '\'' +
                '}';
    }
}
