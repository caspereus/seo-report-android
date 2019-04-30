package studio.tay.reporting.adapter;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import studio.tay.reporting.R;
import studio.tay.reporting.activity.MainActivity;
import studio.tay.reporting.config.ClientConfig;
import studio.tay.reporting.model.Bill;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.Holder> {

    List<Bill> bills = new ArrayList<>();
    Context context;

    View dialogView;
    DownloadManager downloadManager;

    public BillAdapter(Context context) {
        this.context = context;
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView bill_title,bill_status,bill_date;
        LinearLayout cardViewClick;
        public Holder(@NonNull View itemView) {
            super(itemView);
            bill_title  = itemView.findViewById(R.id.bill_title);
            bill_status = itemView.findViewById(R.id.bill_status);
            bill_date   = itemView.findViewById(R.id.bill_date);
            cardViewClick = itemView.findViewById(R.id.cardViewClick);
        }
    }

    @NonNull
    @Override
    public BillAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_bill,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillAdapter.Holder holder, final int i) {
        holder.bill_date.setText(bills.get(i).getCreated_at());
        holder.bill_title.setText(bills.get(i).getTitle());
        if(bills.get(i).getStatus().equals("paid"))
        {
            holder.bill_status.setText("PAID");
            holder.bill_status.setTextColor(Color.parseColor("#3ccc64"));
        }else{
            holder.bill_status.setText("UNPAID");
            holder.bill_status.setTextColor(Color.parseColor("#d34343"));
        }

        holder.cardViewClick.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle("Download File Invoice");
                dialogView = LayoutInflater.from(context).inflate(R.layout.bill_download,null);
                alert.setView(dialogView);

                Button btnDownload = dialogView.findViewById(R.id.downloadBill);
                btnDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        downloadManager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
                        Uri uri = Uri.parse(ClientConfig.downloadUrl+bills.get(i).getAttachment());
                        DownloadManager.Request request = new DownloadManager.Request(uri);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        downloadManager.enqueue(request);

                    }
                });

                alert.setCancelable(true);
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    public void replace_data(List<Bill> bills)
    {
        this.bills = bills;
        notifyDataSetChanged();
    }
}
