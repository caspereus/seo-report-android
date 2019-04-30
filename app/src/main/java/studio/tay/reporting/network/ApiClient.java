package studio.tay.reporting.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import studio.tay.reporting.config.ClientConfig;

public class ApiClient {
    Retrofit retrofit;

    public Retrofit getClient()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ClientConfig.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

}
