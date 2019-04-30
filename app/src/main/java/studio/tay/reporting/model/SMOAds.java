package studio.tay.reporting.model;

public class SMOAds {
    String id,report_id,publish_ads,cost_this_month,cost_last_month,hastag_this_month,hastag_last_month,reach,engagement,post_click,impression,cost_perclick,top_ads,created_at;

    public SMOAds(String id, String report_id, String publish_ads, String cost_this_month, String cost_last_month, String hastag_this_month, String hastag_last_month, String reach, String engagement, String post_click, String impression, String cost_perclick, String top_ads, String created_at) {
        this.id = id;
        this.report_id = report_id;
        this.publish_ads = publish_ads;
        this.cost_this_month = cost_this_month;
        this.cost_last_month = cost_last_month;
        this.hastag_this_month = hastag_this_month;
        this.hastag_last_month = hastag_last_month;
        this.reach = reach;
        this.engagement = engagement;
        this.post_click = post_click;
        this.impression = impression;
        this.cost_perclick = cost_perclick;
        this.top_ads = top_ads;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getReport_id() {
        return report_id;
    }

    public String getPublish_ads() {
        return publish_ads;
    }

    public String getCost_this_month() {
        return cost_this_month;
    }

    public String getCost_last_month() {
        return cost_last_month;
    }

    public String getHastag_this_month() {
        return hastag_this_month;
    }

    public String getHastag_last_month() {
        return hastag_last_month;
    }

    public String getReach() {
        return reach;
    }

    public String getEngagement() {
        return engagement;
    }

    public String getPost_click() {
        return post_click;
    }

    public String getImpression() {
        return impression;
    }

    public String getCost_perclick() {
        return cost_perclick;
    }

    public String getTop_ads() {
        return top_ads;
    }

    public String getCreated_at() {
        return created_at;
    }
}
