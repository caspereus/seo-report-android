package studio.tay.reporting.fragment;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import studio.tay.reporting.R;
import studio.tay.reporting.activity.HomeActivity;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.config.ClientConfig;
import studio.tay.reporting.model.SMOAds;
import studio.tay.reporting.model.SMOFacebook;
import studio.tay.reporting.model.SMOInstagram;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class SMOFragment extends Fragment {

    private SMOFacebook smoFacebook;
    private SMOInstagram smoInstagram;
    private SMOAds smoAds;

    public SMOFragment(SMOFacebook smoFacebook,SMOInstagram smoInstagram,SMOAds smoAds) {
        this.smoFacebook = smoFacebook;
        this.smoInstagram = smoInstagram;
        this.smoAds = smoAds;
    }


    public static TextView facebook_url,
            page_like_last_month,page_like_this_month,page_like_percentage,
            page_reviews_last_month,page_reviews_this_month,page_reviews_percentage,
            comment_last_month,comment_this_month,comment_percentage,
            likepost_last_month,likepost_this_month,likepost_percentage,
            sharepost_last_month,sharepost_this_month,sharepost_percentage
            ;

    public static TextView instagram_url,
            followers_last_month,followers_this_month,followers_percentage,
            poststart_last_month,poststart_this_month,poststart_percentage,
            commentstart_last_month,commentstart_this_month,commentstart_percentage,
            likestart_last_month,likestart_this_month,likestart_percentage,
            mention_last_month,mention_this_month,mention_percentage,
            dirrect_last_month,dirrect_this_month,dirrect_percentage,
            popular_post_1,popular_post_2,popular_post_3
            ;

    public static TextView publish_ads,
            cost_last_month,cost_this_month,
            hastag_last_month,hastag_this_month,
            reach,engagement,post_click,impression,cost_perclick,top_ads
            ;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_smo, container, false);

        //Facebook Component

        facebook_url            = view.findViewById(R.id.facebook_url);
        page_like_last_month    = view.findViewById(R.id.page_like_last_month);
        page_like_this_month    = view.findViewById(R.id.page_like_this_month);
        page_like_percentage    = view.findViewById(R.id.page_like_percentage);
        page_reviews_last_month = view.findViewById(R.id.page_reviews_last_month);
        page_reviews_this_month = view.findViewById(R.id.page_reviews_this_month);
        page_reviews_percentage = view.findViewById(R.id.page_reviews_percentage);
        comment_last_month      = view.findViewById(R.id.comment_last_month);
        comment_this_month      = view.findViewById(R.id.comment_this_month);
        comment_percentage      = view.findViewById(R.id.comment_percentage);
        likepost_last_month     = view.findViewById(R.id.likepost_last_month);
        likepost_this_month     = view.findViewById(R.id.likepost_this_month);
        likepost_percentage     = view.findViewById(R.id.likepost_percentage);
        sharepost_last_month    = view.findViewById(R.id.sharepost_last_month);
        sharepost_this_month    = view.findViewById(R.id.sharepost_this_month);
        sharepost_percentage    = view.findViewById(R.id.sharepost_percentage);


        //Instagram Component

        instagram_url           = view.findViewById(R.id.instagram_url);
        followers_last_month    = view.findViewById(R.id.followers_last_month);
        followers_this_month    = view.findViewById(R.id.followers_this_month);
        followers_percentage    = view.findViewById(R.id.followers_percentage);
        poststart_last_month    = view.findViewById(R.id.poststart_last_month);
        poststart_this_month    = view.findViewById(R.id.poststart_this_month);
        poststart_percentage    = view.findViewById(R.id.poststart_percentage);
        commentstart_last_month = view.findViewById(R.id.commentstart_last_month);
        commentstart_this_month = view.findViewById(R.id.commentstart_this_month);
        commentstart_percentage = view.findViewById(R.id.commentstart_percentage);
        likestart_last_month    = view.findViewById(R.id.likestart_last_month);
        likestart_this_month    = view.findViewById(R.id.likestart_this_month);
        likestart_percentage    = view.findViewById(R.id.likestart_percentage);
        mention_last_month      = view.findViewById(R.id.mention_last_month);
        mention_this_month      = view.findViewById(R.id.mention_this_month);
        mention_percentage      = view.findViewById(R.id.mention_percentage);
        dirrect_last_month      = view.findViewById(R.id.dirrect_last_month);
        dirrect_this_month      = view.findViewById(R.id.dirrect_this_month);
        dirrect_percentage      = view.findViewById(R.id.dirrect_percentage);
        popular_post_1          = view.findViewById(R.id.popular_post_1);
        popular_post_2          = view.findViewById(R.id.popular_post_2);
        popular_post_3          = view.findViewById(R.id.popular_post_3);

        //Ads Component

        publish_ads             = view.findViewById(R.id.publish_ads);
        cost_last_month         = view.findViewById(R.id.cost_last_month);
        cost_this_month         = view.findViewById(R.id.cost_this_month);
        hastag_last_month       = view.findViewById(R.id.hastag_last_month);
        hastag_this_month       = view.findViewById(R.id.hastag_this_month);

        reach                   = view.findViewById(R.id.reach);
        engagement              = view.findViewById(R.id.engagement);
        post_click              = view.findViewById(R.id.post_click);
        impression              = view.findViewById(R.id.impression);
        cost_perclick           = view.findViewById(R.id.cost_perclick);
        top_ads                 = view.findViewById(R.id.top_ads);


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

    public  void setValue()
    {
        final SMOFacebook fb = this.smoFacebook;
        facebook_url.setText(fb.getFacebook_id());

        page_like_last_month.setText(fb.getPage_likes_last_month());
        page_like_this_month.setText(fb.getPage_likes_this_month());
        if (fb.getPage_likes_percentage().substring(0,1).equals("-"))
        {
            page_like_percentage.setTextColor(Color.parseColor("#d34343"));
            page_like_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(fb.getPage_likes_last_month(),fb.getPage_likes_this_month(),fb.getPage_likes_note());
                }
            });
        }else{
            page_like_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }

        page_like_percentage.setText(fb.getPage_likes_percentage()+"%");

        page_reviews_last_month.setText(fb.getReviews_last_month());
        page_reviews_this_month.setText(fb.getReviews_this_month());
        if (fb.getReviews_percentage().substring(0,1).equals("-"))
        {
            page_reviews_percentage.setTextColor(Color.parseColor("#d34343"));
            page_reviews_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(fb.getReviews_last_month(),fb.getReviews_this_month(),fb.getReviews_note());
                }
            });
        }else{
            page_reviews_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        page_reviews_percentage.setText(fb.getReviews_percentage()+"%");

        comment_last_month.setText(fb.getComment_last_month());
        comment_this_month.setText(fb.getComment_this_month());
        if (fb.getComment_percentage().substring(0,1).equals("-"))
        {
            comment_percentage.setTextColor(Color.parseColor("#d34343"));
            comment_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(fb.getComment_last_month(),fb.getComment_this_month(),fb.getComment_note());
                }
            });
        }else{
            comment_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        comment_percentage.setText(fb.getComment_percentage()+"%");

        likepost_last_month.setText(fb.getLikes_post_last_month());
        likepost_this_month.setText(fb.getLikes_post_this_month());
        if (fb.getLikes_post_percentage().substring(0,1).equals("-"))
        {
            likepost_percentage.setTextColor(Color.parseColor("#d34343"));
            likepost_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(fb.getLikes_post_last_month(),fb.getLikes_post_this_month(),fb.getLike_post_note());
                }
            });
        }else{
            likepost_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        likepost_percentage.setText(fb.getLikes_post_percentage()+"%");

        sharepost_last_month.setText(fb.getShare_last_month());
        sharepost_this_month.setText(fb.getShare_this_month());
        if (fb.getShare_percentage().substring(0,1).equals("-"))
        {
            sharepost_percentage.setTextColor(Color.parseColor("#d34343"));
            sharepost_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(fb.getShare_last_month(),fb.getShare_this_month(),fb.getShare_note());
                }
            });
        }else{
            sharepost_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        sharepost_percentage.setText(fb.getShare_percentage()+"%");


        final SMOInstagram ig = smoInstagram;
        instagram_url.setText(ig.getInstagram_id());
        followers_last_month.setText(ig.getFollowers_last_month());
        followers_this_month.setText(ig.getFollowers_this_month());
        if (ig.getFollowers_percentage().substring(0,1).equals("-"))
        {
            followers_percentage.setTextColor(Color.parseColor("#d34343"));
            followers_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(ig.getFollowers_last_month(),ig.getFollowers_this_month(),ig.getFollower_note());
                }
            });
        }else{
            followers_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        followers_percentage.setText(ig.getFollowers_percentage()+"%");

        poststart_last_month.setText(ig.getPost_last_month());
        poststart_this_month.setText(ig.getPost_this_month());
        if (ig.getPost_percentage().substring(0,1).equals("-"))
        {
            poststart_percentage.setTextColor(Color.parseColor("#d34343"));
            poststart_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(ig.getPost_last_month(),ig.getPost_this_month(),ig.getPost_note());
                }
            });
        }else{
            poststart_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        poststart_percentage.setText(ig.getPost_percentage()+"%");

        commentstart_last_month.setText(ig.getComment_last_month());
        commentstart_this_month.setText(ig.getComment_this_month());
        if (ig.getComment_percentage().substring(0,1).equals("-"))
        {
            commentstart_percentage.setTextColor(Color.parseColor("#d34343"));
            commentstart_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(ig.getPost_last_month(),ig.getPost_this_month(),ig.getPost_note());
                }
            });
        }else{
            commentstart_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        commentstart_percentage.setText(ig.getComment_percentage()+"%");

        likestart_last_month.setText(ig.getLike_last_month());
        likestart_this_month.setText(ig.getLike_this_month());
        if (ig.getLike_percentage().substring(0,1).equals("-"))
        {
            likestart_percentage.setTextColor(Color.parseColor("#d34343"));
            likestart_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(ig.getLike_last_month(),ig.getLike_this_month(),ig.getLike_note());
                }
            });
        }else{
            likestart_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        likestart_percentage.setText(ig.getLike_percentage()+"%");

        mention_last_month.setText(ig.getMention_last_month());
        mention_this_month.setText(ig.getMention_this_month());
        if (ig.getMention_percentage().substring(0,1).equals("-"))
        {
            mention_percentage.setTextColor(Color.parseColor("#d34343"));
            mention_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(ig.getMention_last_month(),ig.getMention_this_month(),ig.getMention_note());
                }
            });
        }else{
            mention_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        mention_percentage.setText(ig.getMention_percentage()+"%");

        dirrect_last_month.setText(ig.getDm_last_month());
        dirrect_this_month.setText(ig.getDm_this_month());
        if (ig.getDm_percentage().substring(0,1).equals("-"))
        {
            dirrect_percentage.setTextColor(Color.parseColor("#d34343"));
            dirrect_percentage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intentDetail(ig.getDm_last_month(),ig.getDm_this_month(),ig.getDm_note());
                }
            });
        }else{
            dirrect_percentage.setTextColor(Color.parseColor("#3ccc64"));
        }
        dirrect_percentage.setText(ig.getDm_percentage()+"%");

        popular_post_1.setText(ig.getPopular_1());
        popular_post_2.setText(ig.getPopular_2());
        popular_post_3.setText(ig.getPopular_3());

        SMOAds ads = smoAds;
        if(ads == null)
        {
            publish_ads.setText("0");
            cost_last_month.setText("0");
            cost_this_month.setText("0");
            hastag_last_month.setText("0");
            hastag_this_month.setText("0");
            reach.setText("0");
            engagement.setText("0");
            post_click.setText("0");
            impression.setText("0");
            cost_perclick.setText("0");
            top_ads.setText("0");
        }else{
            publish_ads.setText(ads.getPublish_ads());
            cost_last_month.setText(ads.getCost_last_month());
            cost_this_month.setText(ads.getCost_this_month());
            hastag_last_month.setText(ads.getHastag_last_month());
            hastag_this_month.setText(ads.getHastag_this_month());
            reach.setText(ads.getReach());
            engagement.setText(ads.getEngagement());
            post_click.setText(ads.getPost_click());
            impression.setText(ads.getImpression());
            cost_perclick.setText(ads.getCost_perclick());
            top_ads.setText(ads.getTop_ads());
        }


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setValue();
    }
}
