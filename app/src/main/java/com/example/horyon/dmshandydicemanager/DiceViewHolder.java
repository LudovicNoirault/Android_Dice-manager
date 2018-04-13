package com.example.horyon.dmshandydicemanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Horyon on 25/03/2018.
 */

public class DiceViewHolder extends RecyclerView.ViewHolder
{

        private TextView textViewIdDice = null;
        private ImageView imageViewShape;
        private TextView textViewResult = null;

        public DiceViewHolder(View itemView)
        {
            super(itemView);
            textViewIdDice = itemView.findViewById(R.id.diceNumber);
            imageViewShape = itemView.findViewById(R.id.displayedDice);
            textViewResult = itemView.findViewById(R.id.diceResult);
        }

        public  TextView getTextViewIdDice()
        {
            return textViewIdDice;
        }
        public ImageView getImageViewShape()
        {
            return imageViewShape;
        }
        public  TextView getTextViewResult()
        {
            return textViewResult;
        }
}
