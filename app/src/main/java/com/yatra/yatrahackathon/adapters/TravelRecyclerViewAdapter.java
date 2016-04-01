package com.yatra.yatrahackathon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.yatra.yatrahackathon.R;

/**
 * Created by XVTS8308 on 01/04/2016.
 */
public class TravelRecyclerViewAdapter {

    private int mRowLayout;
    private Context mContext;

    public TravelRecyclerViewAdapter(int rowLayout, Context context) {
        this.mRowLayout = rowLayout;
        this.mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView agentTitle;
        public TextView tourName;
        public RatingBar agentRating;

        public ViewHolder(View itemView) {
            super(itemView);

            agentTitle = (TextView)itemView.findViewById(R.id.agentTitle);
            tourName = (TextView)itemView.findViewById(R.id.tourName);
            agentRating = (RatingBar)itemView.findViewById(R.id.agent_ratingBar);
        }
    }
}
