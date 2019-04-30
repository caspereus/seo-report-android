package studio.tay.reporting.model;

public class Notification {

    String id,client_id,title,message,type,created_at;

    public Notification(String id, String client_id, String title, String message, String type, String created_at) {
        this.id = id;
        this.client_id = client_id;
        this.title = title;
        this.message = message;
        this.type = type;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getCreated_at() {
        return created_at;
    }
}
