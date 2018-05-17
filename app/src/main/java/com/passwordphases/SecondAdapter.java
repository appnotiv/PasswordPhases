package com.passwordphases;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


@SuppressWarnings("ALL")
public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<TitleModel> listCabs;
    clickSecondView listner;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCabsName;

        public MyViewHolder(View view) {
            super(view);

            tvCabsName = (TextView) view.findViewById(R.id.tv_ItemSecond_Title);
        }
    }


    public SecondAdapter(Context mContext, ArrayList<TitleModel> listCabs, clickSecondView listner) {
        this.mContext = mContext;
        this.listCabs = listCabs;
        this.listner = listner;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_text, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tvCabsName.setText(listCabs.get(position).getTitle());

        if (listCabs.get(position).getTitle().trim().equalsIgnoreCase(""))
        {

        }
        else
        {

        }

        holder.tvCabsName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listner != null)
                {
                    listner.clickSecond(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCabs.size();
    }

    public interface clickSecondView
    {
        public void clickSecond(int position);
    }
}