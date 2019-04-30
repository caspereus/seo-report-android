package studio.tay.reporting.model;

public class Seo {
    String report_id,website_url,main_keyword,trafic_this_month,trafic_last_month,trafic_percentage,visitor_this_month,visitor_last_month,visitor_percentage,pageviews_this_month,pageviews_last_month,pageviews_percentage,search_engine,social,dirrect,refferal,keyword_1,keyword_2,keyword_3,keyword_4,keyword_5,id,created_at;
    String trafic_note,pageviews_note,visitor_note;

    public Seo(String report_id, String website_url, String main_keyword, String trafic_this_month, String trafic_last_month, String trafic_percentage, String visitor_this_month, String visitor_last_month, String visitor_percentage, String pageviews_this_month, String pageviews_last_month, String pageviews_percentage, String search_engine, String social, String dirrect, String refferal, String keyword_1, String keyword_2, String keyword_3, String keyword_4, String keyword_5, String id, String created_at, String trafic_note, String pageviews_note, String visitor_note) {
        this.report_id = report_id;
        this.website_url = website_url;
        this.main_keyword = main_keyword;
        this.trafic_this_month = trafic_this_month;
        this.trafic_last_month = trafic_last_month;
        this.trafic_percentage = trafic_percentage;
        this.visitor_this_month = visitor_this_month;
        this.visitor_last_month = visitor_last_month;
        this.visitor_percentage = visitor_percentage;
        this.pageviews_this_month = pageviews_this_month;
        this.pageviews_last_month = pageviews_last_month;
        this.pageviews_percentage = pageviews_percentage;
        this.search_engine = search_engine;
        this.social = social;
        this.dirrect = dirrect;
        this.refferal = refferal;
        this.keyword_1 = keyword_1;
        this.keyword_2 = keyword_2;
        this.keyword_3 = keyword_3;
        this.keyword_4 = keyword_4;
        this.keyword_5 = keyword_5;
        this.id = id;
        this.created_at = created_at;
        this.trafic_note = trafic_note;
        this.pageviews_note = pageviews_note;
        this.visitor_note = visitor_note;
    }

    public String getReport_id() {
        return report_id;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public String getMain_keyword() {
        return main_keyword;
    }

    public String getTrafic_this_month() {
        return trafic_this_month;
    }

    public String getTrafic_last_month() {
        return trafic_last_month;
    }

    public String getTrafic_percentage() {
        return trafic_percentage;
    }

    public String getVisitor_this_month() {
        return visitor_this_month;
    }

    public String getVisitor_last_month() {
        return visitor_last_month;
    }

    public String getVisitor_percentage() {
        return visitor_percentage;
    }

    public String getPageviews_this_month() {
        return pageviews_this_month;
    }

    public String getPageviews_last_month() {
        return pageviews_last_month;
    }

    public String getPageviews_percentage() {
        return pageviews_percentage;
    }

    public String getSearch_engine() {
        return search_engine;
    }

    public String getSocial() {
        return social;
    }

    public String getDirrect() {
        return dirrect;
    }

    public String getRefferal() {
        return refferal;
    }

    public String getKeyword_1() {
        return keyword_1;
    }

    public String getKeyword_2() {
        return keyword_2;
    }

    public String getKeyword_3() {
        return keyword_3;
    }

    public String getKeyword_4() {
        return keyword_4;
    }

    public String getKeyword_5() {
        return keyword_5;
    }

    public String getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getTrafic_note() {
        return trafic_note;
    }

    public String getPageviews_note() {
        return pageviews_note;
    }

    public String getVisitor_note() {
        return visitor_note;
    }
}
