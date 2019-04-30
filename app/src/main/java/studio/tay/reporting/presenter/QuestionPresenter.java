package studio.tay.reporting.presenter;

import android.util.Log;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import studio.tay.reporting.base.BasePresenter;
import studio.tay.reporting.response.MainResponse;
import studio.tay.reporting.response.SupportResponse;
import studio.tay.reporting.view.QuestionView;

public class QuestionPresenter<question extends QuestionView> extends BasePresenter {

    question questionview;

    public QuestionPresenter(question questionview) {
        this.questionview = questionview;
    }

    public void sendquestion(String client_id, final String question,String file)
    {
        questionview.onShow();

        if (file == null)
        {
           apiClass.sendQuestionAS(client_id,question).enqueue(new Callback<MainResponse>() {
               @Override
               public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                   questionview.getHttp(Integer.toString(response.code()));
                   if (response.isSuccessful())
                   {
                       Log.d("IS STATUS",response.body().getStatus());
                       questionview.onSuccessSendQuestion(response.body().getStatus());
                       questionview.onHide();
                   }
               }

               @Override
               public void onFailure(Call<MainResponse> call, Throwable t) {
                   questionview.onError(t.getMessage());
                   questionview.onHide();
               }
           });
        }else{
            Map<String, RequestBody> map = new HashMap<>();
            File fileObjek = new File(file);
            RequestBody requestBodyObjek = RequestBody.create(MediaType.parse("*/*"), fileObjek);
            map.put("attachment\"; filename=\"" + fileObjek.getName() + "\"", requestBodyObjek);

            RequestBody Client_id  = RequestBody.create(MediaType.parse("text/plain"),client_id);
            RequestBody Question   = RequestBody.create(MediaType.parse("text/plain"),question);
            apiClass.sendQuestion(map,Client_id,Question).enqueue(new Callback<MainResponse>() {
                @Override
                public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
                    questionview.getHttp(Integer.toString(response.code()));
                    if (response.isSuccessful())
                    {
                        Log.d("IS STATUS",response.body().getStatus());
                        questionview.onSuccessSendQuestion(response.body().getStatus());
                        questionview.onHide();
                    }
                }

                @Override
                public void onFailure(Call<MainResponse> call, Throwable t) {
                    questionview.onError(t.getMessage());
                    questionview.onHide();
                }
            });
        }
    }

    public void loadQuestion()
    {
        questionview.onShow();
        apiClass.loadQuestion().enqueue(new Callback<SupportResponse>() {
            @Override
            public void onResponse(Call<SupportResponse> call, Response<SupportResponse> response) {
                questionview.getHttp(Integer.toString(response.code()));
                if (response.isSuccessful())
                {
                    questionview.onSuccessLoadQuestions(response.body().getSupports());
                    questionview.onHide();
                }
            }

            @Override
            public void onFailure(Call<SupportResponse> call, Throwable t) {
                questionview.onError(t.getMessage());
                questionview.onHide();
            }
        });
    }
}
