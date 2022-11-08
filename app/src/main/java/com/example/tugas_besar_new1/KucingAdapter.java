package com.example.tugas_besar_new1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class KucingAdapter extends RecyclerView.Adapter<KucingAdapter.KucingViewHolder> {
    String data1[], data2[], data3[];
    int images[];
    Context context;
    public KucingAdapter(Context ct, String s1[], String s2[], String s3[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        images = img;
    }
    @NonNull
    @Override
    public KucingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_cat,parent, false);
        return new KucingViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull KucingViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.star.setText(data3[position]);
        holder.myImage.setImageResource(images[position]);
    }
    @Override
    public int getItemCount() {
        return images.length;
    }
    public class KucingViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2, star;
        ImageView myImage;
        ConstraintLayout mainLayout;
        public KucingViewHolder(View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.judul);
            myText2 = itemView.findViewById(R.id.harga);
            star = itemView.findViewById(R.id.textrate);
            myImage = itemView.findViewById(R.id.gambar);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}