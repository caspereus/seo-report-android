package studio.tay.reporting.view;

import java.util.List;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.Report;

public interface HistoryView extends BaseView {

    void onSuccessLoadHistory(List<Report> reports);

}
