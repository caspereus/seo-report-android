package studio.tay.reporting.view;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.Client;

public interface LoginView extends BaseView {

    void onSuccessLogin(String status, Client client);

}
