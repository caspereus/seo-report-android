package studio.tay.reporting.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.ReportAdapter;
import studio.tay.reporting.base.BaseFragment;
import studio.tay.reporting.helper.PrefManager;
import studio.tay.reporting.model.Report;
import studio.tay.reporting.presenter.HistoryPresenter;
import studio.tay.reporting.view.HistoryView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends BaseFragment implements HistoryView {


    public HistoryFragment() {

    }

    @BindView(R.id.report_recycler)
    RecyclerView recyclerView;

    HistoryPresenter historyPresenter;
    ReportAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_history, container, false);
        ButterKnife.bind(this,view);
        historyPresenter = new HistoryPresenter(this);

        PrefManager prefManager = new PrefManager(getActivity());
        historyPresenter.loadHistory(String.valueOf(prefManager.getUserId()));

        adapter = new ReportAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onSuccessLoadHistory(List<Report> reports) {
        adapter.replace_data(reports);
    }

    @Override
    public void onShow() {
        super.showLoading(getActivity());
    }

    @Override
    public void onHide() {
        super.dismissLoading();
    }

    @Override
    public void onError(String error) {
        super.showError(error);
    }

    @Override
    public void getHttp(String http) {
        super.showHttp(http);
    }
}
