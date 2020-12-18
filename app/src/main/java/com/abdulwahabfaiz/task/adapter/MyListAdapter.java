package com.abdulwahabfaiz.task.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abdulwahabfaiz.task.R;
import com.abdulwahabfaiz.task.Timer;
import com.abdulwahabfaiz.task.dataclass.MyListData;
import com.airbnb.lottie.LottieAnimationView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private ArrayList<MyListData> listdata;
    Context mContext;
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    public MyListAdapter(ArrayList<MyListData> listdata, Context mContext) {
        this.listdata = listdata;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.card_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData arraylist = listdata.get(position);
        holder.textView.setText(arraylist.getDescription());
        holder.mainLayout.setVisibility(View.VISIBLE);
//        holder.imageView.setImageResource(arraylist.getImgId());

        long bidTime = arraylist.getTime();

        //long
        new CountDownTimer(bidTime, 1000) {
            public void onTick(long millisUntilFinished) {
                // Used for formatting digit to be in 2 digits only
                NumberFormat f = new DecimalFormat("00");
                long hour = (millisUntilFinished / 3600000) % 24;
                long min = (millisUntilFinished / 60000) % 60;
                long sec = (millisUntilFinished / 1000) % 60;
                holder.txtTimer.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }
            // When the task is over it will print 00:00:00 
            // there and
            public void onFinish() {
                holder.lottieAnimationView.setVisibility(View.VISIBLE);
                holder.mainLayout.setVisibility(View.INVISIBLE);
                holder.txtTimer.setText("00:00:00");
                Toast.makeText(mContext, "Bid Finish "+arraylist.getDescription()+" Removed", Toast.LENGTH_SHORT).show();
                try {
                    listdata.remove(position);

                    /* New Handler to start the Menu-Activity
                     * and close this Splash-Screen after some seconds.*/
                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            /* Create an Intent that will start the Menu-Activity. */
                            notifyDataSetChanged();
                            holder.lottieAnimationView.setVisibility(View.INVISIBLE);
                        }
                    }, SPLASH_DISPLAY_LENGTH);


                }catch (Exception e){}
            }
        }.start();

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "click on item: " + arraylist.getDescription(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView, txtTimer;
        public CardView card;
        public LottieAnimationView lottieAnimationView;
        public LinearLayout mainLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView  =   itemView.findViewById(R.id.imageView);
            this.textView   =   itemView.findViewById(R.id.textView);
            this.txtTimer   =   itemView.findViewById(R.id.txt_timer);
            card            =   itemView.findViewById(R.id.cardView);
            lottieAnimationView = itemView.findViewById(R.id.animationView);
            mainLayout = itemView.findViewById(R.id.main);
        }
    }


}
