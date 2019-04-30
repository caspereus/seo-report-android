package studio.tay.reporting.model;

public class Bill {
    String client_id,title,status,attachment,created_at;

    public Bill(String client_id, String title, String status, String attachment, String created_at) {
        this.client_id = client_id;
        this.title = title;
        this.status = status;
        this.attachment = attachment;
        this.created_at = created_at;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public String getAttachment() {
        return attachment;
    }

    public String getCreated_at() {
        return created_at;
    }
}
