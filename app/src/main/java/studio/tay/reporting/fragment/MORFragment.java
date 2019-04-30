package studio.tay.reporting.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import studio.tay.reporting.R;
import studio.tay.reporting.base.BaseActivity;
import studio.tay.reporting.model.Mor;

/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class MORFragment extends Fragment {


    Mor mor;

    public MORFragment(Mor mor) {
        this.mor = mor;
    }



    public static TextView total_post_product,total_revenue,total_sales,
            total_post_product_own_last_month,total_post_product_bukalapak_last_month,total_post_product_shopee_last_month,total_post_product_tokopedia_last_month,
            total_post_product_own_this_month,total_post_product_bukalapak_this_month,total_post_product_shopee_this_month,total_post_product_tokopedia_this_month,
            total_order_product_own_this_month,total_order_product_bukalapak_this_month,total_order_product_shopee_this_month,total_order_product_tokopedia_this_month,
            total_order_product_own_last_month,total_order_product_bukalapak_last_month,total_order_product_shopee_last_month,total_order_product_tokopedia_last_month,
            total_revenue_product_own_this_month,total_revenue_product_bukalapak_this_month,total_revenue_product_shopee_this_month,total_revenue_product_tokopedia_this_month,
            total_revenue_product_own_last_month,total_revenue_product_bukalapak_last_month,total_revenue_product_shopee_last_month,total_revenue_product_tokopedia_last_month,
            total_product_start_at,total_product_last_month,total_product_this_month,
            total_chat_user,total_whatsapp_chat,total_phone_call,total_email_receive,
            total_destination_order,total_local_shipping,total_local_shipping_cost,
            jne,jnt,ptpost,other
            ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_mor, container, false);


        total_post_product = view.findViewById(R.id.total_post_products);
        total_revenue      = view.findViewById(R.id.total_revenues);
        total_sales        = view.findViewById(R.id.total_sales);

        total_post_product_own_last_month       = view.findViewById(R.id.total_post_product_own_last_month);
        total_post_product_bukalapak_last_month = view.findViewById(R.id.total_post_product_bukalapak_last_month);
        total_post_product_shopee_last_month    = view.findViewById(R.id.total_post_product_shopee_last_month);
        total_post_product_tokopedia_last_month = view.findViewById(R.id.total_post_product_tokopedia_last_month);

        total_post_product_own_this_month       = view.findViewById(R.id.total_post_product_own_this_month);
        total_post_product_bukalapak_this_month = view.findViewById(R.id.total_post_product_bukalapak_this_month);
        total_post_product_shopee_this_month    = view.findViewById(R.id.total_post_product_shopee_this_month);
        total_post_product_tokopedia_this_month = view.findViewById(R.id.total_post_product_tokopedia_this_month);

        total_order_product_own_this_month       = view.findViewById(R.id.total_order_product_own_this_month);
        total_order_product_bukalapak_this_month = view.findViewById(R.id.total_order_product_bukalapak_this_month);
        total_order_product_shopee_this_month    = view.findViewById(R.id.total_order_product_shopee_this_month);
        total_order_product_tokopedia_this_month = view.findViewById(R.id.total_order_product_tokopedia_this_month);

        total_order_product_own_last_month       = view.findViewById(R.id.total_order_product_own_last_month);
        total_order_product_bukalapak_last_month = view.findViewById(R.id.total_order_product_bukalapak_last_month);
        total_order_product_shopee_last_month    = view.findViewById(R.id.total_order_product_shopee_last_month);
        total_order_product_tokopedia_last_month = view.findViewById(R.id.total_order_product_tokopedia_last_month);

        total_revenue_product_own_this_month       = view.findViewById(R.id.total_revenue_product_own_this_month);
        total_revenue_product_bukalapak_this_month = view.findViewById(R.id.total_revenue_product_bukalapak_this_month);
        total_revenue_product_shopee_this_month    = view.findViewById(R.id.total_revenue_product_shopee_this_month);
        total_revenue_product_tokopedia_this_month = view.findViewById(R.id.total_revenue_product_tokopedia_this_month);

        total_revenue_product_own_last_month       = view.findViewById(R.id.total_revenue_product_own_last_month);
        total_revenue_product_bukalapak_last_month = view.findViewById(R.id.total_revenue_product_bukalapak_last_month);
        total_revenue_product_shopee_last_month    = view.findViewById(R.id.total_revenue_product_shopee_last_month);
        total_revenue_product_tokopedia_last_month = view.findViewById(R.id.total_revenue_product_tokopedia_last_month);

        total_product_start_at = view.findViewById(R.id.total_product_start_at);
        total_product_last_month = view.findViewById(R.id.total_product_last_month);
        total_product_this_month = view.findViewById(R.id.total_product_this_month);

        total_chat_user = view.findViewById(R.id.total_chat_user);
        total_whatsapp_chat = view.findViewById(R.id.total_whatsapp_chat);
        total_phone_call = view.findViewById(R.id.total_phone_call);
        total_email_receive = view.findViewById(R.id.total_email_receive);

        total_destination_order = view.findViewById(R.id.total_destination_order);
        total_local_shipping = view.findViewById(R.id.total_local_shipping);
        total_local_shipping_cost = view.findViewById(R.id.total_local_shipping_cost);

        jne = view.findViewById(R.id.jne);
        jnt = view.findViewById(R.id.jnt);
        ptpost = view.findViewById(R.id.ptpos);
        other = view.findViewById(R.id.other);




        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mor == null)
        {
            total_post_product.setText("0");
            total_revenue.setText("0");
            total_sales.setText("0");

            total_post_product_own_last_month.setText("0");
            total_post_product_bukalapak_last_month.setText("0");
            total_post_product_shopee_last_month.setText("0");
            total_post_product_tokopedia_last_month.setText("0");

            total_post_product_own_this_month.setText("0");
            total_post_product_bukalapak_this_month.setText("0");
            total_post_product_shopee_this_month.setText("0");
            total_post_product_tokopedia_this_month.setText("0");

            total_order_product_own_this_month.setText("0");
            total_order_product_bukalapak_this_month.setText("0");
            total_order_product_shopee_this_month.setText("0");
            total_order_product_tokopedia_this_month.setText("0");

            total_order_product_own_last_month.setText("0");
            total_order_product_bukalapak_last_month.setText("0");
            total_order_product_shopee_last_month.setText("0");
            total_order_product_tokopedia_last_month.setText("0");

            total_revenue_product_own_this_month.setText("0");
            total_revenue_product_bukalapak_this_month.setText("0");
            total_revenue_product_shopee_this_month.setText("0");
            total_revenue_product_tokopedia_this_month.setText("0");

            total_revenue_product_own_last_month.setText("0");
            total_revenue_product_bukalapak_last_month.setText("0");
            total_revenue_product_shopee_last_month.setText("0");
            total_revenue_product_tokopedia_last_month.setText("0");

            total_product_start_at.setText("0");
            total_product_last_month.setText("0");
            total_product_this_month.setText("0");

            total_chat_user.setText("0");
            total_whatsapp_chat.setText("0");
            total_phone_call.setText("0");
            total_email_receive.setText("0");

            total_destination_order.setText("0");
            total_local_shipping.setText("0");
            total_local_shipping_cost.setText("0");

            jne.setText("0");
            jnt.setText("0");
            ptpost.setText("0");
            other.setText("0");
        }else{
            total_post_product.setText(mor.getTotal_post_product());
            total_revenue.setText(mor.getTotal_revenue());
            total_sales.setText(mor.getTotal_sales());

            total_post_product_own_last_month.setText(mor.getTotalpost_own_last_month());
            total_post_product_bukalapak_last_month.setText(mor.getTotalpost_bukalapak_last_month());
            total_post_product_shopee_last_month.setText(mor.getTotalpost_shopee_last_month());
            total_post_product_tokopedia_last_month.setText(mor.getTotalpost_tokopedia_last_month());

            total_post_product_own_this_month.setText(mor.getTotalpost_own_this_month());
            total_post_product_bukalapak_this_month.setText(mor.getTotalpost_bukalapak_this_month());
            total_post_product_shopee_this_month.setText(mor.getTotalpost_shopee_this_month());
            total_post_product_tokopedia_this_month.setText(mor.getTotalpost_tokopedia_this_month());

            total_order_product_own_this_month.setText(mor.getTotalorder_own_this_month());
            total_order_product_bukalapak_this_month.setText(mor.getTotalorder_bukalapak_this_month());
            total_order_product_shopee_this_month.setText(mor.getTotalorder_shopee_this_month());
            total_order_product_tokopedia_this_month.setText(mor.getTotalorder_tokopedia_this_month());

            total_order_product_own_last_month.setText(mor.getTotalorder_own_last_month());
            total_order_product_bukalapak_last_month.setText(mor.getTotalorder_bukalapak_last_month());
            total_order_product_shopee_last_month.setText(mor.getTotalorder_shopee_last_month());
            total_order_product_tokopedia_last_month.setText(mor.getTotalorder_tokopedia_last_month());

            total_revenue_product_own_this_month.setText(mor.getTotalrevenue_own_this_month());
            total_revenue_product_bukalapak_this_month.setText(mor.getTotalrevenue_bukalapak_this_month());
            total_revenue_product_shopee_this_month.setText(mor.getTotalrevenue_shopee_this_month());
            total_revenue_product_tokopedia_this_month.setText(mor.getTotalrevenue_tokopedia_this_month());

            total_revenue_product_own_last_month.setText(mor.getTotalrevenue_own_last_month());
            total_revenue_product_bukalapak_last_month.setText(mor.getTotalrevenue_bukalapak_last_month());
            total_revenue_product_shopee_last_month.setText(mor.getTotalrevenue_shopee_last_month());
            total_revenue_product_tokopedia_last_month.setText(mor.getTotalrevenue_tokopedia_last_month());

            total_product_start_at.setText(mor.getTotal_product_start_at());
            total_product_last_month.setText(mor.getTotal_product_last_month());
            total_product_this_month.setText(mor.getTotal_product_this_month());

            total_chat_user.setText(mor.getTotal_chat_user());
            total_whatsapp_chat.setText(mor.getTotal_whatsapp_chat());
            total_phone_call.setText(mor.getTotal_phone_call());
            total_email_receive.setText(mor.getTotal_email_receive());

            total_destination_order.setText(mor.getTotal_destination_order());
            total_local_shipping.setText(mor.getTotal_local_shipping());
            total_local_shipping_cost.setText(mor.getTotal_shipping_cost());

            jne.setText(mor.getJne());
            jnt.setText(mor.getJnt());
            ptpost.setText(mor.getPtpost());
            other.setText(mor.getOther());

        }


    }

}
