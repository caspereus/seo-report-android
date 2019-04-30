package studio.tay.reporting.model;

public class SMOFacebook {
    String id,report_id,facebook_id,page_likes_this_month,page_likes_last_month,page_likes_percentage,reviews_this_month,reviews_last_month,reviews_percentage,comment_this_month,comment_last_month,comment_percentage,likes_post_this_month,likes_post_last_month,likes_post_percentage,share_this_month,share_last_month,share_percentage,created_at;
    String page_likes_note, reviews_note, comment_note, like_post_note, share_note;

    public SMOFacebook(String id, String report_id, String facebook_id, String page_likes_this_month, String page_likes_last_month, String page_likes_percentage, String reviews_this_month, String reviews_last_month, String reviews_percentage, String comment_this_month, String comment_last_month, String comment_percentage, String likes_post_this_month, String likes_post_last_month, String likes_post_percentage, String share_this_month, String share_last_month, String share_percentage, String created_at, String page_likes_note, String reviews_note, String comment_note, String like_post_note, String share_note) {
        this.id = id;
        this.report_id = report_id;
        this.facebook_id = facebook_id;
        this.page_likes_this_month = page_likes_this_month;
        this.page_likes_last_month = page_likes_last_month;
        this.page_likes_percentage = page_likes_percentage;
        this.reviews_this_month = reviews_this_month;
        this.reviews_last_month = reviews_last_month;
        this.reviews_percentage = reviews_percentage;
        this.comment_this_month = comment_this_month;
        this.comment_last_month = comment_last_month;
        this.comment_percentage = comment_percentage;
        this.likes_post_this_month = likes_post_this_month;
        this.likes_post_last_month = likes_post_last_month;
        this.likes_post_percentage = likes_post_percentage;
        this.share_this_month = share_this_month;
        this.share_last_month = share_last_month;
        this.share_percentage = share_percentage;
        this.created_at = created_at;
        this.page_likes_note = page_likes_note;
        this.reviews_note = reviews_note;
        this.comment_note = comment_note;
        this.like_post_note = like_post_note;
        this.share_note = share_note;
    }

    public String getId() {
        return id;
    }

    public String getReport_id() {
        return report_id;
    }

    public String getFacebook_id() {
        return facebook_id;
    }

    public String getPage_likes_this_month() {
        return page_likes_this_month;
    }

    public String getPage_likes_last_month() {
        return page_likes_last_month;
    }

    public String getPage_likes_percentage() {
        return page_likes_percentage;
    }

    public String getReviews_this_month() {
        return reviews_this_month;
    }

    public String getReviews_last_month() {
        return reviews_last_month;
    }

    public String getReviews_percentage() {
        return reviews_percentage;
    }

    public String getComment_this_month() {
        return comment_this_month;
    }

    public String getComment_last_month() {
        return comment_last_month;
    }

    public String getComment_percentage() {
        return comment_percentage;
    }

    public String getLikes_post_this_month() {
        return likes_post_this_month;
    }

    public String getLikes_post_last_month() {
        return likes_post_last_month;
    }

    public String getLikes_post_percentage() {
        return likes_post_percentage;
    }

    public String getShare_this_month() {
        return share_this_month;
    }

    public String getShare_last_month() {
        return share_last_month;
    }

    public String getShare_percentage() {
        return share_percentage;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getPage_likes_note() {
        return page_likes_note;
    }

    public String getReviews_note() {
        return reviews_note;
    }

    public String getComment_note() {
        return comment_note;
    }

    public String getLike_post_note() {
        return like_post_note;
    }

    public String getShare_note() {
        return share_note;
    }
}
