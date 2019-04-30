package studio.tay.reporting.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import studio.tay.reporting.R;
import studio.tay.reporting.model.AwsDay;

public class AwsAdapter extends RecyclerView.Adapter<AwsAdapter.Holder> {


    List<AwsDay> awsDays = new ArrayList<>();
    Context context;

    public AwsAdapter(Context context) {
        this.context = context;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView number_of_visit,pages,hits,bandwith,date;
        public Holder(@NonNull View itemView) {
            super(itemView);
            number_of_visit = itemView.findViewById(R.id.number_of_visits);
            pages           = itemView.findViewById(R.id.pages);
            hits            = itemView.findViewById(R.id.hits);
            bandwith        = itemView.findViewById(R.id.bandwith);
            date            = itemView.findViewById(R.id.date);
        }
    }

    @NonNull
    @Override
    public AwsAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.aws_item,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AwsAdapter.Holder holder, int position) {
        holder.number_of_visit.setText(awsDays.get(position).getNumber_of_visit());
        holder.pages.setText(awsDays.get(position).getPages());
        holder.hits.setText(awsDays.get(position).getHits());
        holder.bandwith.setText(awsDays.get(position).getBandwith());
        holder.date.setText(awsDays.get(position).getDay());
    }

    @Override
    public int getItemCount() {
        return awsDays.size();
    }

    public void replace_data(List<AwsDay> awsDays)
    {
        this.awsDays = awsDays;
        notifyDataSetChanged();
    }

}
