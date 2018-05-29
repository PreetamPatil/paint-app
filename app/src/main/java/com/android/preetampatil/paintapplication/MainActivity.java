package com.android.preetampatil.paintapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {



    private LinearLayout mCanvasMenuOption;
    private PaintView mPaintView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        mCanvasMenuOption = (LinearLayout) findViewById(R.id.optionsLayout);
        mPaintView = (PaintView) findViewById(R.id.paintView);


        mCanvasMenuOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClearCanvasAlertDialog();
            }
        });


    }


    void showClearCanvasAlertDialog(){

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setMessage(getString(R.string.clear_canvas_message));


        alertDialogBuilder.setPositiveButton(getString(R.string.button_positive_message), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mPaintView.cleanCanvas();
            }
        });

        alertDialogBuilder.setNegativeButton(getString(R.string.button_negative_message), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });


        alertDialogBuilder.show();


    }

}
