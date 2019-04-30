package studio.tay.reporting.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import studio.tay.reporting.R;
import studio.tay.reporting.activity.DetailActivity;
import studio.tay.reporting.model.Report;

public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.Holder> {

    List<Report> reports = new ArrayList<>();
    Context context;

    public ReportAdapter(Context context) {
        this.context = context;
    }

    class Holder extends RecyclerView.ViewHolder{

        TextView textTitle,textDescription,textDate;
        CardView cardClick;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            textDate = itemView.findViewById(R.id.textDate);

            cardClick = itemView.findViewById(R.id.card_click);
        }

    }

    @NonNull
    @Override
    public ReportAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.report_items,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReportAdapter.Holder holder, final int position) {
        holder.textTitle.setText(reports.get(position).getTitle());
        holder.textDescription.setText(reports.get(position).getMessage());
        holder.textDate.setText(reports.get(position).getCreated_at());
        holder.cardClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detail = new Intent(context, DetailActivity.class);
                detail.putExtra("title",reports.get(position).getTitle());
                detail.putExtra("id",reports.get(position).getId());
                context.startActivity(detail);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.reports.size();
    }

    public void replace_data(List<Report> reports)
    {
        this.reports = reports;
        notifyDataSetChanged();
    }

}
