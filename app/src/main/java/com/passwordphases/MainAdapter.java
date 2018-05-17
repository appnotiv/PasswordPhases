package com.passwordphases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


@SuppressWarnings("ALL")
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<TitleModel> listCabs;
    clickMainView listner;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCabsName;

        public MyViewHolder(View view) {
            super(view);
            tvCabsName = (TextView) view.findViewById(R.id.tv_ItemSecond_Title);
        }
    }

    public MainAdapter(Context mContext, ArrayList<TitleModel> listCabs, clickMainView listner) {
        this.mContext = mContext;
        this.listCabs = listCabs;
        this.listner = listner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvCabsName.setText(listCabs.get(position).getTitle());
        holder.tvCabsName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listner != null)
                {
                    listner.clickMain(listCabs.get(position).getPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCabs.size();
    }

    public interface clickMainView
    {
        public void clickMain(int position);
    }
}