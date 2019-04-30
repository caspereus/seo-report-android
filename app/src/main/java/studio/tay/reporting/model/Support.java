package studio.tay.reporting.model;

public class Support {

    String id,question,client_id,answer,created_at,posted,attachment;

    public Support(String id, String question, String client_id, String answer, String created_at, String posted, String attachment) {
        this.id = id;
        this.question = question;
        this.client_id = client_id;
        this.answer = answer;
        this.created_at = created_at;
        this.posted = posted;
        this.attachment = attachment;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getAnswer() {
        return answer;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getPosted() {
        return posted;
    }

    public String getAttachment() {
        return attachment;
    }
}
