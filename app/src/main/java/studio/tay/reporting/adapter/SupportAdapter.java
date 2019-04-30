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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import studio.tay.reporting.R;
import studio.tay.reporting.activity.QuestionDetailActivity;
import studio.tay.reporting.model.Support;

public class SupportAdapter extends RecyclerView.Adapter<SupportAdapter.Holder> {

    List<Support> supports = new ArrayList<>();
    Context context;

    public SupportAdapter(Context context) {
        this.context = context;
    }

    class Holder extends RecyclerView.ViewHolder{
        TextView question,questionDate;
        LinearLayout cardViewClick;
        public Holder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question);
            cardViewClick = itemView.findViewById(R.id.cardViewClick);
            questionDate = itemView.findViewById(R.id.dateQuestion);
        }

    }

    @NonNull
    @Override
    public SupportAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_question,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SupportAdapter.Holder holder, final int i) {
        holder.question.setText(supports.get(i).getQuestion());
        holder.questionDate.setText(supports.get(i).getCreated_at());
        holder.cardViewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, QuestionDetailActivity.class);
                intent.putExtra("question",supports.get(i).getQuestion());
                intent.putExtra("answer",supports.get(i).getAnswer());
                intent.putExtra("image",supports.get(i).getAttachment());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return supports.size();
    }

    public void replace_data(List<Support> supports)
    {
        this.supports = supports;
        notifyDataSetChanged();
    }

}
