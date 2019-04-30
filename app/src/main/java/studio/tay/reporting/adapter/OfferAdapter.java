package studio.tay.reporting.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import studio.tay.reporting.R;
import studio.tay.reporting.activity.OfferDetailActivity;
import studio.tay.reporting.config.ClientConfig;
import studio.tay.reporting.model.Offer;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.Holder> {

    List<Offer> offers = new ArrayList<>();
    Context context;

    public OfferAdapter(Context context) {
        this.context = context;
    }

    class Holder extends RecyclerView.ViewHolder{

        LinearLayout cardOffer;
        TextView textTitle,textDate;
        ImageView imageList;

        public Holder(@NonNull View itemView) {
            super(itemView);

            cardOffer = itemView.findViewById(R.id.cardMe);
            textTitle = itemView.findViewById(R.id.titleList);
            textDate  = itemView.findViewById(R.id.dateList);
            imageList = itemView.findViewById(R.id.imageList);

        }

    }

    @NonNull
    @Override
    public OfferAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_offer,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OfferAdapter.Holder holder, final int i) {
        Picasso.get().load(ClientConfig.imageUrl+"offer/"+offers.get(i).getCover()).into(holder.imageList);
        holder.textTitle.setText(offers.get(i).getTitle());
        holder.textDate.setText(offers.get(i).getCreated_at());
        holder.cardOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, OfferDetailActivity.class);
                detail.putExtra("cover",ClientConfig.imageUrl+"offer/"+offers.get(i).getCover());
                detail.putExtra("title",offers.get(i).getTitle());
                detail.putExtra("summary",offers.get(i).getSummary());
                detail.putExtra("date",offers.get(i).getCreated_at());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public void replace_data(List<Offer> offers)
    {
        this.offers = offers;
        notifyDataSetChanged();
    }
}
