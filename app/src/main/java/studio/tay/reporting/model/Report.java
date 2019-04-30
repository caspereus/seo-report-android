package studio.tay.reporting.model;

public class Report {
    String id,title,message,client_id,smo_facebook_id,smo_instagram_id,smo_ads_id,seo_id,mor_id,publish,created_at,updated_at,seo_type;

    public Report(String id, String title, String message, String client_id, String smo_facebook_id, String smo_instagram_id, String smo_ads_id, String seo_id, String mor_id, String publish, String created_at, String updated_at, String seo_type) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.client_id = client_id;
        this.smo_facebook_id = smo_facebook_id;
        this.smo_instagram_id = smo_instagram_id;
        this.smo_ads_id = smo_ads_id;
        this.seo_id = seo_id;
        this.mor_id = mor_id;
        this.publish = publish;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.seo_type = seo_type;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getSmo_facebook_id() {
        return smo_facebook_id;
    }

    public String getSmo_instagram_id() {
        return smo_instagram_id;
    }

    public String getSmo_ads_id() {
        return smo_ads_id;
    }

    public String getSeo_id() {
        return seo_id;
    }

    public String getMor_id() {
        return mor_id;
    }

    public String getPublish() {
        return publish;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public String getSeo_type() {
        return seo_type;
    }
}
