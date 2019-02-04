package com.jaemion.eHub.orderdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jaemion.eHub.R;
import com.jaemion.eHub.main.ui.MainFragment_List_Adapter;

import org.w3c.dom.Text;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {
    Context context;

    public OrderDetailAdapter(Context context) {
        super();
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_detail_cardview, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button btnAccept, btnReject;
        TextView  tvTitle, tvYear, tvLocation, tvOption;
        ImageView ivTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivTitle = itemView.findViewById(R.id.order_detail_cardview_ivTitle);
            tvTitle = itemView.findViewById(R.id.order_detail_cardview_tvTitle);
            tvYear = itemView.findViewById(R.id.order_detail_cardview_tvYear);
            tvLocation = itemView.findViewById(R.id.order_detail_cardview_tvLocation);
            tvOption = itemView.findViewById(R.id.order_detail_cardview_tvOption);
            btnAccept = itemView.findViewById(R.id.order_detail_cardview_btnAccept);
            btnReject = itemView.findViewById(R.id.order_detail_cardview_btnReject);
        }
    }
}
