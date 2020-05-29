package com.example.learnfromcodinginflow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>  {

    private ArrayList <ItemExample> itemExamples;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{//interface
        void OnItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){//new
        mListener=listener;
    }

   public static class ExampleViewHolder extends RecyclerView.ViewHolder {

         public ImageView mImageView;
         public TextView mTextView1;
         public TextView mTextView2;

          public ExampleViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
           super(itemView);
           mImageView =itemView.findViewById(R.id.ImageView);
           mTextView1 =itemView.findViewById(R.id.line1);
           mTextView2=itemView.findViewById(R.id.line2);
           itemView.setOnClickListener(new View.OnClickListener() {//new
               @Override
               public void onClick(View v) {
                   if(listener!=null){
                       int position =getAdapterPosition();
                       if(position!=RecyclerView.NO_POSITION){

                       }
                   }
               }
           });
       }
   }

    public ExampleAdapter(ArrayList<ItemExample> itemExamples) {
        this.itemExamples = itemExamples;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
       ExampleViewHolder evh =new ExampleViewHolder(v,mListener);
       return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
       ItemExample currentItem =itemExamples.get(position);

       holder.mImageView.setImageResource(currentItem.getImageId());
       holder.mTextView1.setText(currentItem.getTextone());
       holder.mTextView2.setText(currentItem.getTextidtwo());


    }

    @Override
    public int getItemCount() {
        return itemExamples.size();
    }
}
