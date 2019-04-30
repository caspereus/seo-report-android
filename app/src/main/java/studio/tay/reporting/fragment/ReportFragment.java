package studio.tay.reporting.fragment;


import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import studio.tay.reporting.R;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.config.ApplicationConfig;
import studio.tay.reporting.config.ClientConfig;
import studio.tay.reporting.model.Report;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class ReportFragment extends Fragment {

    private static Report report;

    public ReportFragment(Report report) {
        this.report = report;
    }

    private static TextView report_title,report_message,report_publish;
    Button btnDownload;
    DownloadManager downloadManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_report, container, false);

        report_title = view.findViewById(R.id.report_title);
        report_message = view.findViewById(R.id.report_message);
        report_publish = view.findViewById(R.id.report_publish);
        final Context c = getActivity();
        btnDownload = view.findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ClientConfig.baseUrl+"report/pdf_download/"+report.getId()));
                startActivity(browserIntent);

            }
        });

        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setValue();
    }

    public static void setValue()
    {
        report_title.setText(report.getTitle());
        report_message.setText(report.getMessage());
        report_publish.setText(report.getCreated_at());
    }




}
