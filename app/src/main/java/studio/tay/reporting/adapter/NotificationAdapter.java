package studio.tay.reporting.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import studio.tay.reporting.R;
import studio.tay.reporting.activity.BillActivity;
import studio.tay.reporting.activity.MainActivity;
import studio.tay.reporting.activity.OfferActivity;
import studio.tay.reporting.model.Notification;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.Holder> {

    List<Notification> notifications = new ArrayList<>();
    Context context;

    public NotificationAdapter(Context context) {
        this.context = context;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView notif_title,notif_message,notif_date;
        LinearLayout cardView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            notif_title = itemView.findViewById(R.id.notif_title);
            notif_message = itemView.findViewById(R.id.notif_message);
            notif_date = itemView.findViewById(R.id.notif_date);
            cardView   = itemView.findViewById(R.id.cardViewClick);
        }
    }

    @NonNull
    @Override
    public NotificationAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_list,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.Holder holder, final int position) {
        holder.notif_title.setText(notifications.get(position).getTitle());
        holder.notif_message.setText(notifications.get(position).getMessage());
        holder.notif_date.setText(notifications.get(position).getCreated_at());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (notifications.get(position).getType().equals("offer"))
                {
                    context.startActivity(new Intent(context, OfferActivity.class));
                }else if (notifications.get(position).getType().equals("bill"))
                {
                    context.startActivity(new Intent(context, BillActivity.class));
                }else if (notifications.get(position).getType().equals("main"))
                {
                    context.startActivity(new Intent(context, MainActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public void replace_data(List<Notification> notifications)
    {
        this.notifications = notifications;
        notifyDataSetChanged();
    }
}
