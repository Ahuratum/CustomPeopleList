package com.example.custompeoplelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Human> humanList;
    Context context;

    public RecycleViewAdapter(List<Human> humanList, Context context) {
        this.humanList = humanList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_box, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_listName.setText(humanList.get(position).getName());
        Glide.with(this.context).load(humanList.get(position).getImage()).into(holder.iv_humanPicture);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditPerson.class);
                intent.putExtra("id", humanList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return humanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_humanPicture;
        TextView tv_listName, tv_listAge, tv_listPhoneNumber;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_humanPicture = itemView.findViewById(R.id.iv_humanPicture);
            tv_listName = itemView.findViewById(R.id.tv_listName);
            parentLayout = itemView.findViewById(R.id.contactBox);
        }
    }
}
