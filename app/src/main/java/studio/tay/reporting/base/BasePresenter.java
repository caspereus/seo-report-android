package studio.tay.reporting.base;

import android.content.Context;
import android.os.Bundle;

import studio.tay.reporting.network.ApiClass;
import studio.tay.reporting.network.ApiClient;


public class BasePresenter {

    public ApiClass apiClass = new ApiClient().getClient().create(ApiClass.class);
    public Context context;

}
