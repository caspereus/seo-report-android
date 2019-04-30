package studio.tay.reporting.model;

public class SMOInstagram {
    String id,report_id,instagram_id,followers_this_month,followers_last_month,followers_percentage,post_this_month,post_last_month,post_percentage,comment_this_month,comment_last_month,comment_percentage,like_this_month,like_last_month,like_percentage,mention_this_month,mention_last_month,mention_percentage,dm_this_month,dm_last_month,dm_percentage,popular_1,popular_2,popular_3,created_at;
    String follower_note, post_note, comment_note, like_note, mention_note, dm_note;

    public SMOInstagram(String id, String report_id, String instagram_id, String followers_this_month, String followers_last_month, String followers_percentage, String post_this_month, String post_last_month, String post_percentage, String comment_this_month, String comment_last_month, String comment_percentage, String like_this_month, String like_last_month, String like_percentage, String mention_this_month, String mention_last_month, String mention_percentage, String dm_this_month, String dm_last_month, String dm_percentage, String popular_1, String popular_2, String popular_3, String created_at, String follower_note, String post_note, String comment_note, String like_note, String mention_note, String dm_note) {
        this.id = id;
        this.report_id = report_id;
        this.instagram_id = instagram_id;
        this.followers_this_month = followers_this_month;
        this.followers_last_month = followers_last_month;
        this.followers_percentage = followers_percentage;
        this.post_this_month = post_this_month;
        this.post_last_month = post_last_month;
        this.post_percentage = post_percentage;
        this.comment_this_month = comment_this_month;
        this.comment_last_month = comment_last_month;
        this.comment_percentage = comment_percentage;
        this.like_this_month = like_this_month;
        this.like_last_month = like_last_month;
        this.like_percentage = like_percentage;
        this.mention_this_month = mention_this_month;
        this.mention_last_month = mention_last_month;
        this.mention_percentage = mention_percentage;
        this.dm_this_month = dm_this_month;
        this.dm_last_month = dm_last_month;
        this.dm_percentage = dm_percentage;
        this.popular_1 = popular_1;
        this.popular_2 = popular_2;
        this.popular_3 = popular_3;
        this.created_at = created_at;
        this.follower_note = follower_note;
        this.post_note = post_note;
        this.comment_note = comment_note;
        this.like_note = like_note;
        this.mention_note = mention_note;
        this.dm_note = dm_note;
    }

    public String getId() {
        return id;
    }

    public String getReport_id() {
        return report_id;
    }

    public String getInstagram_id() {
        return instagram_id;
    }

    public String getFollowers_this_month() {
        return followers_this_month;
    }

    public String getFollowers_last_month() {
        return followers_last_month;
    }

    public String getFollowers_percentage() {
        return followers_percentage;
    }

    public String getPost_this_month() {
        return post_this_month;
    }

    public String getPost_last_month() {
        return post_last_month;
    }

    public String getPost_percentage() {
        return post_percentage;
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

    public String getLike_this_month() {
        return like_this_month;
    }

    public String getLike_last_month() {
        return like_last_month;
    }

    public String getLike_percentage() {
        return like_percentage;
    }

    public String getMention_this_month() {
        return mention_this_month;
    }

    public String getMention_last_month() {
        return mention_last_month;
    }

    public String getMention_percentage() {
        return mention_percentage;
    }

    public String getDm_this_month() {
        return dm_this_month;
    }

    public String getDm_last_month() {
        return dm_last_month;
    }

    public String getDm_percentage() {
        return dm_percentage;
    }

    public String getPopular_1() {
        return popular_1;
    }

    public String getPopular_2() {
        return popular_2;
    }

    public String getPopular_3() {
        return popular_3;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getFollower_note() {
        return follower_note;
    }

    public String getPost_note() {
        return post_note;
    }

    public String getComment_note() {
        return comment_note;
    }

    public String getLike_note() {
        return like_note;
    }

    public String getMention_note() {
        return mention_note;
    }

    public String getDm_note() {
        return dm_note;
    }
}
