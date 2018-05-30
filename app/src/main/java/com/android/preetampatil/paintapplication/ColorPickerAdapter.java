package com.android.preetampatil.paintapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by preetampatil on 5/30/18.
 */

public class ColorPickerAdapter extends BaseAdapter {

    private Context mContext;
    private String [] mListOfColors;
    private OnClickListener mListener;


    public ColorPickerAdapter(Context mContext, String[] mListOfColors) {
        this.mContext = mContext;
        this.mListOfColors = mListOfColors;

    }

    @Override
    public int getCount() {
        return mListOfColors.length;
    }

    @Override
    public Object getItem(int i) {
        return mListOfColors[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.color_picker_model,null);
        }

        Button uniqueColor = (Button) view.findViewById(R.id.color);
        uniqueColor.setBackgroundColor(Color.parseColor(mListOfColors[position]));

        uniqueColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickListener(mListOfColors[position]);
            }
        });

        return view;
    }

    public void setListener(OnClickListener listener) {
        this.mListener = listener;
    }

    public interface OnClickListener {

        void onClickListener(String selectedColor);

    }


}
