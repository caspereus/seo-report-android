package studio.tay.reporting.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.adapter.AwsAdapter;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.model.AwsDay;

/**
 * A simple {@link Fragment} subclass.
 */
public class AWSFragment extends Fragment {


    public AWSFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.aws_recycler)
    RecyclerView recyclerView;

    public static AwsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_aw, container, false);
        ButterKnife.bind(this,view);

        adapter = new AwsAdapter(getActivity());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<AwsDay> awsDays = BaseActivity.awsDay;
        adapter.replace_data(awsDays);
    }

    public static void setValue()
    {
        List<AwsDay> awsDays = BaseActivity.awsDay;
        adapter.replace_data(awsDays);
    }

}
