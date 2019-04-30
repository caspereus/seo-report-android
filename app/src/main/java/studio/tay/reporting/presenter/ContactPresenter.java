package studio.tay.reporting.presenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.model.Contact;
import studio.tay.reporting.view.ContactView;

public class ContactPresenter<contact extends ContactView> extends BasePresenter {


    contact contactview;

    public ContactPresenter(contact contactview) {
        this.contactview = contactview;
    }

    public void loadContact()
    {
        contactview.onShow();
        apiClass.loadContact().enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                contactview.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    contactview.onSuccessLoadContact(response.body());
                    contactview.onHide();
                }
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                contactview.onError(t.getMessage());
                contactview.onHide();
            }
        });
    }
}
