package studio.tay.reporting.view;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.Contact;

public interface ContactView extends BaseView {

    void onSuccessLoadContact(Contact contact);

}
