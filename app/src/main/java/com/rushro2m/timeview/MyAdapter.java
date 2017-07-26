package com.rushro2m.timeview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<HashMap<String, Object>> listItem;
    private Context mContext;

    public MyAdapter(List<HashMap<String, Object>> listItem, Context mContext) {
        this.listItem = listItem;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText((String) listItem.get(position).get("ItemTitle"));
        holder.text.setText((String) listItem.get(position).get("ItemText"));
    }

    @Override
    public int getItemCount() {
        return listItem != null ? listItem.size() : 0;
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, text;

        ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.ItemTitle);
            text = (TextView) itemView.findViewById(R.id.ItemText);
        }
        public TextView getTitle(){
            return title;
        }

        public TextView getText(){
            return text;
        }

    }
}
