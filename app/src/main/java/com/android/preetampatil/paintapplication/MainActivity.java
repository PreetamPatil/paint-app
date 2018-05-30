package com.android.preetampatil.paintapplication;

import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {


    private PaintView mPaintView;
    FragmentManager mFragmentManager;
    ColorPickerFragment mColorPickerFragment;
    LinearLayout mClearCanvasLayout;
    LinearLayout mChangeColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        mClearCanvasLayout = (LinearLayout) findViewById(R.id.clearCanvasLayout);
        LinearLayout mEraseDrawing = (LinearLayout) findViewById(R.id.eraseDrawingLayout);
        mChangeColor = (LinearLayout) findViewById(R.id.changeColor);

        mFragmentManager = getFragmentManager();
        mColorPickerFragment = new ColorPickerFragment();
        mPaintView = (PaintView) findViewById(R.id.paintView);


        mClearCanvasLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClearCanvasAlertDialog();
                mClearCanvasLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
            }
        });

        mEraseDrawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPaintView.eraseDrawing();
            }
        });

        mChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mChangeColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorPrimary));
                mColorPickerFragment.show(mFragmentManager,"colorPicker");
            }
        });


    }


    //Method to clear the canvas.
    void showClearCanvasAlertDialog(){

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setMessage(getString(R.string.clear_canvas_message));

        alertDialogBuilder.setPositiveButton(getString(R.string.button_positive_message), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mPaintView.cleanCanvas();
                mClearCanvasLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGrey));
            }
        });

        alertDialogBuilder.setNegativeButton(getString(R.string.button_negative_message), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mClearCanvasLayout.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGrey));
            }
        });

        alertDialogBuilder.show();

    }

    // Method to pass the selected color to the paint class.
    public void selectedColor(String selectedColor){
        mColorPickerFragment.dismiss();
        mChangeColor.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.lightGrey));
        mPaintView.setBrushColor(Color.parseColor(selectedColor));

    }

}
