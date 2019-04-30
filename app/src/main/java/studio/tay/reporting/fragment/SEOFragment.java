package studio.tay.reporting.fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import studio.tay.reporting.R;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.model.Seo;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class SEOFragment extends Fragment {


    private Seo seo;

    public SEOFragment(Seo seo) {
        this.seo = seo;
    }

    public static TextView website_url,main_keyword,
            traffic_last_month,traffic_this_month,traffic_percentage,
            visitor_last_month,visitor_this_month,visitor_percentage,
            pageviews_last_month,pageviews_this_month,pageviews_percentage,
            search_engine,social,dirrect,refferal,
            keyword_1,keyword_2,keyword_3,keyword_4,keyword_5
            ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_seo, container, false);


        website_url           = view.findViewById(R.id.website_url);
        main_keyword          = view.findViewById(R.id.main_keyword);

        traffic_last_month    = view.findViewById(R.id.traffic_last_month);
        traffic_this_month    = view.findViewById(R.id.traffic_this_month);
        traffic_percentage    = view.findViewById(R.id.traffic_percentage);

        visitor_last_month    = view.findViewById(R.id.visitor_last_month);
        visitor_this_month    = view.findViewById(R.id.visitor_this_month);
        visitor_percentage    = view.findViewById(R.id.visitor_percentage);

        pageviews_last_month  = view.findViewById(R.id.pageviews_last_month);
        pageviews_this_month  = view.findViewById(R.id.pageviews_this_month);
        pageviews_percentage  = view.findViewById(R.id.pageviews_percentage);

        search_engine         = view.findViewById(R.id.search_engine);
        social                = view.findViewById(R.id.social);
        dirrect               = view.findViewById(R.id.dirrect);
        refferal              = view.findViewById(R.id.refferal);

        keyword_1             = view.findViewById(R.id.keyword_1);
        keyword_2             = view.findViewById(R.id.keyword_2);
        keyword_3             = view.findViewById(R.id.keyword_3);
        keyword_4             = view.findViewById(R.id.keyword_4);
        keyword_5             = view.findViewById(R.id.keyword_5);

        return view;
    }

    public void intentDetail(String lastmonth,String thismonth,String notes)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setTitle("Note");
        View dialogView = LayoutInflater.from(getActivity()).inflate(R.layout.popup_detail,null);
        alert.setView(dialogView);

        TextView textlast,textthis,textnotes;
        textlast = dialogView.findViewById(R.id.lastmonth);
        textthis = dialogView.findViewById(R.id.thismonth);
        textnotes= dialogView.findViewById(R.id.notes_popup);

        textlast.setText(lastmonth);
        textthis.setText(thismonth);
        textnotes.setText(notes);


        alert.setCancelable(true);
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void setValue()
    {
        final Seo seo = this.seo;
        if (seo == null)
        {
            website_url.setText("0");
            main_keyword.setText("0");

            traffic_last_month.setText("0");
            traffic_this_month.setText("0");
            traffic_percentage.setText("0.00%");
            traffic_percentage.setTextColor(Color.parseColor("#3ccc64"));

            visitor_last_month.setText("0");
            visitor_this_month.setText("0");
            visitor_percentage.setText("0.00%");
            visitor_percentage.setTextColor(Color.parseColor("#3ccc64"));

            pageviews_last_month.setText("0");
            pageviews_this_month.setText("0");
            pageviews_percentage.setText("0.00%");
            pageviews_percentage.setTextColor(Color.parseColor("#3ccc64"));

            search_engine.setText("0");
            social.setText("0");
            dirrect.setText("0");
            refferal.setText("0");

            keyword_1.setText("0");
            keyword_2.setText("0");
            keyword_3.setText("0");
            keyword_4.setText("0");
            keyword_5.setText("0");
        }else{
            website_url.setText(seo.getWebsite_url());
            main_keyword.setText(seo.getMain_keyword());

            traffic_last_month.setText(seo.getTrafic_last_month());
            traffic_this_month.setText(seo.getTrafic_this_month());
            if (seo.getTrafic_percentage().substring(0,1).equals("-"))
            {
                traffic_percentage.setTextColor(Color.parseColor("#d34343"));
                traffic_percentage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intentDetail(seo.getTrafic_last_month(),seo.getTrafic_this_month(),seo.getTrafic_note());
                    }
                });
            }else{
                traffic_percentage.setTextColor(Color.parseColor("#3ccc64"));
            }
            traffic_percentage.setText(seo.getTrafic_percentage()+"%");

            visitor_last_month.setText(seo.getVisitor_last_month());
            visitor_this_month.setText(seo.getVisitor_this_month());
            if (seo.getVisitor_percentage().substring(0,1).equals("-"))
            {
                visitor_percentage.setTextColor(Color.parseColor("#d34343"));
                visitor_percentage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intentDetail(seo.getVisitor_last_month(),seo.getVisitor_this_month(),seo.getVisitor_note());
                    }
                });
            }else{
                visitor_percentage.setTextColor(Color.parseColor("#3ccc64"));
            }
            visitor_percentage.setText(seo.getVisitor_percentage()+"%");

            pageviews_last_month.setText(seo.getPageviews_last_month());
            pageviews_this_month.setText(seo.getPageviews_this_month());
            if (seo.getPageviews_percentage().substring(0,1).equals("-"))
            {
                pageviews_percentage.setTextColor(Color.parseColor("#d34343"));
                pageviews_percentage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intentDetail(seo.getPageviews_last_month(),seo.getPageviews_this_month(),seo.getPageviews_note());
                    }
                });
            }else{
                pageviews_percentage.setTextColor(Color.parseColor("#3ccc64"));
            }
            pageviews_percentage.setText(seo.getPageviews_percentage()+"%");

            search_engine.setText(seo.getSearch_engine());
            social.setText(seo.getSocial());
            dirrect.setText(seo.getDirrect());
            refferal.setText(seo.getRefferal());

            keyword_1.setText(seo.getKeyword_1());
            keyword_2.setText(seo.getKeyword_2());
            keyword_3.setText(seo.getKeyword_3());
            keyword_4.setText(seo.getKeyword_4());
            keyword_5.setText(seo.getKeyword_5());
        }



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setValue();
    }
}
