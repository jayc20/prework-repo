package com.example.to_do_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    public interface OnLongClickListener{
        void onItemLongClick(int position);
    }
    List<String> items;
    OnLongClickListener longClickListener;

    public ItemsAdapter(List<String> items,OnLongClickListener longClickListener){
        this.items = items;
        this.longClickListener = longClickListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Use Layout inflator
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        //wrap in a view hold
        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(android.R.id.text1);
        }
        public void bind(String item){
            tvItem.setText(item);

            tvItem.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    longClickListener.onItemLongClick(getAdapterPosition());
                    return false;
                }
            });
        }
    }
}