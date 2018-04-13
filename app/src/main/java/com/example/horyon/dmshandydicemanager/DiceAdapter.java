package com.example.horyon.dmshandydicemanager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Horyon on 25/03/2018.
 */

public class DiceAdapter extends RecyclerView.Adapter<DiceViewHolder>
{
    private Context context;
    private List<Dice> listDice = null;

    public DiceAdapter(List<Dice> listDice, Context context)
    {
        this.listDice = listDice;
        this.context = context;
    }

    @Override
    public DiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View viewDice = LayoutInflater.from(parent.getContext()).inflate(R.layout.dice,parent,false);
        return new DiceViewHolder(viewDice);
    }

    @Override
    public void onBindViewHolder(DiceViewHolder holder, int position)
    {
        holder.getTextViewIdDice().setText(Integer.toString(listDice.get(position).getIdDice()));

        int temp = listDice.get(position).getNbFace();
        Log.e("Switch will be on ",""+temp);
        switch(temp)
        {
            case 6:
                holder.getImageViewShape().setImageDrawable(context.getResources().getDrawable(R.drawable.d6));
                break;
            case 10:
                holder.getImageViewShape().setImageDrawable(context.getResources().getDrawable(R.drawable.d10));
                break;
            case 12:
                holder.getImageViewShape().setImageDrawable(context.getResources().getDrawable(R.drawable.d12));
                break;
            case 4:
                holder.getImageViewShape().setImageDrawable(context.getResources().getDrawable(R.drawable.d4d8d20));
                break;
            case 8:
                holder.getImageViewShape().setImageDrawable(context.getResources().getDrawable(R.drawable.d4d8d20));
                break;
            case 20:
                holder.getImageViewShape().setImageDrawable(context.getResources().getDrawable(R.drawable.d4d8d20));
                break;
            default:
                Log.e("error","error");
                break;
        }
        holder.getTextViewResult().setText(Integer.toString(listDice.get(position).getResult()));
    }

    @Override
    public int getItemCount()
    {
        return listDice.size();
    }
}