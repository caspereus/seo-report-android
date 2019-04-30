package studio.tay.reporting.view;

import java.util.List;

import studio.tay.reporting.base.BaseView;
import studio.tay.reporting.model.Support;

public interface QuestionView extends BaseView {

    void onSuccessSendQuestion(String status);
    void onSuccessLoadQuestions(List<Support> supports);

}
