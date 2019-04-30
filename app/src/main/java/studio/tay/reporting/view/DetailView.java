package studio.tay.reporting.view;

import java.util.List;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.AwsDay;
import studio.tay.reporting.model.Mor;
import studio.tay.reporting.model.Report;
import studio.tay.reporting.model.SMOAds;
import studio.tay.reporting.model.SMOFacebook;
import studio.tay.reporting.model.SMOInstagram;
import studio.tay.reporting.model.Seo;

public interface DetailView extends BaseView {

    void onSuccessLoadDetail(SMOFacebook smoFacebook, SMOInstagram smoInstagram, SMOAds smoAds, Seo seo, List<AwsDay> awsDays, Mor mor, Report report);


}
