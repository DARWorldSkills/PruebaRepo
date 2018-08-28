package com.caucaragp.worldskills.primerensayo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class AdapterT extends RecyclerView.Adapter<AdapterT.Holder> {
    int repetir;
    Context context;

    public AdapterT(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_prueba,parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.connectData();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imgI = itemView.findViewById(R.id.imageView2);

        public Holder(View itemView) {
            super(itemView);
        }
        public void connectData(){
            int random = (int) (Math.random() * 3)+1;
            if (random == 1){
                imgI.setColorFilter(context.getColor(R.color.color1));
            }

            if (random == 2){
                imgI.setColorFilter(context.getColor(R.color.color2));
            }

            if (random == 3){
                imgI.setColorFilter(context.getColor(R.color.color3));
            }




        }
    }
}
