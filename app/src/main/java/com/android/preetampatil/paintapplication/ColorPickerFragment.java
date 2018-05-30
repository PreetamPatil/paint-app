package com.android.preetampatil.paintapplication;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

/**
 * Created by preetampatil on 5/30/18.
 */

public class ColorPickerFragment extends DialogFragment implements ColorPickerAdapter.OnClickListener {


    GridView mColorPickerView;
    ColorPickerAdapter mAdapter;
    private String [] mListOfColors = {"#9d8ba3","#4290ae","#0e1c36","#cda8d2","#c5fbef","#b9e6ea","#573976","#42b0e5","#7ccdf4","#eadcee",
            "#494a4e","#ffc200","#ff7f00","#dd2c2c","#868686","#19a5bf","#4a1a13","#9b9c9d","#19a5bf","#64a70d"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.color_picker_fragment,null);

        mColorPickerView = (GridView) rootView.findViewById(R.id.colorGridView);

        //Set the adapter
        mAdapter = new ColorPickerAdapter(getActivity(),mListOfColors);
        //Setting the listener
        mAdapter.setListener(this);
        mColorPickerView.setAdapter(mAdapter);

        return rootView;

    }

    //This listener will pass the selected color to main activity
    @Override
    public void onClickListener(String selectedColor) {

        ((MainActivity)getActivity()).selectedColor(selectedColor);
    }


}
