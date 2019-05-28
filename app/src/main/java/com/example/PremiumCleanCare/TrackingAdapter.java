package com.example.PremiumCleanCare;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TrackingAdapter extends RecyclerView.Adapter<TrackingAdapter.TrackingViewHolder>{
    private ArrayList<Tracking> dataList;
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TrackingViewHolder extends RecyclerView.ViewHolder{
        private TextView txtnonota, txttanggal, txtttlbayar;

        public TrackingViewHolder(View itemView) {
            super(itemView);
            txtnonota = (TextView) itemView.findViewById(R.id.txt_no_nota);
            txttanggal = (TextView) itemView.findViewById(R.id.txt_tanggal);
            txtttlbayar = (TextView) itemView.findViewById(R.id.txt_ttlbayar);
        }
    }

    public TrackingAdapter(ArrayList<Tracking> dataList) {
        this.dataList = dataList;
    }

    @Override
    public void onBindViewHolder(TrackingViewHolder holder, int position) {
        holder.txtnonota.setText(dataList.get(position).getNonota());
        holder.txttanggal.setText(dataList.get(position).getTanggal());
        holder.txtttlbayar.setText(dataList.get(position).getTtlbayar());
    }

    @Override
    public TrackingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview_tracking, parent, false);
        return new TrackingViewHolder(view);
    }
}
