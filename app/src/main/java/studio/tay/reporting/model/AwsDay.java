package studio.tay.reporting.model;

public class AwsDay {
    String id,report_id,day,number_of_visit,pages,hits,bandwith;

    public AwsDay(String id, String report_id, String day, String number_of_visit, String pages, String hits, String bandwith) {
        this.id = id;
        this.report_id = report_id;
        this.day = day;
        this.number_of_visit = number_of_visit;
        this.pages = pages;
        this.hits = hits;
        this.bandwith = bandwith;
    }

    public String getId() {
        return id;
    }

    public String getReport_id() {
        return report_id;
    }

    public String getDay() {
        return day;
    }

    public String getNumber_of_visit() {
        return number_of_visit;
    }

    public String getPages() {
        return pages;
    }

    public String getHits() {
        return hits;
    }

    public String getBandwith() {
        return bandwith;
    }
}

