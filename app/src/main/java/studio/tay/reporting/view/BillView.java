package studio.tay.reporting.view;

import java.util.List;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.Bill;

public interface BillView  extends BaseView{

    void onSuccessLoadBill(List<Bill> bills);

}
