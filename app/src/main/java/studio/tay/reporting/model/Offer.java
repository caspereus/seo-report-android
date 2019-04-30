package studio.tay.reporting.model;

public class Offer {

    String id,title,summary,cover,created_at;

    public Offer(String id, String title, String summary, String cover, String created_at) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.cover = cover;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getCover() {
        return cover;
    }

    public String getCreated_at() {
        return created_at;
    }
}
