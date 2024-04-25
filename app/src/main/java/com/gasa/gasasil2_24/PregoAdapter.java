package com.gasa.gasasil2_24;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PregoAdapter extends RecyclerView.Adapter<PregoAdapter.PregoVH> {
    String[] nomList;
    int[] imageList;

    public PregoAdapter(String[] nomList, int[] imageList) {
        this.nomList = nomList;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public PregoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.vue_prego, parent, false);
        return new PregoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PregoVH holder, int position) {
        holder.tvNomPrego.setText(nomList[position]);
        holder.imgvPrego.setImageResource(imageList[position]);

    }

    @Override
    public int getItemCount() {
        return nomList.length;
    }

    class PregoVH extends RecyclerView.ViewHolder {
        TextView tvNomPrego;
        ImageView imgvPrego;
        public PregoVH(@NonNull View itemView) {
            super(itemView);
            tvNomPrego =itemView.findViewById(R.id.tv_nom_prego);
            imgvPrego =itemView.findViewById(R.id.imgv_photo_prego);
        }
    }
}
