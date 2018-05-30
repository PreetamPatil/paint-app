package com.android.preetampatil.paintapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    private PaintView mPaintView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        LinearLayout mClearCanvasLayout = (LinearLayout) findViewById(R.id.clearCanvasLayout);
        mPaintView = (PaintView) findViewById(R.id.paintView);
        LinearLayout mEraseDrawing = (LinearLayout) findViewById(R.id.eraseDrawingLayout);

        mClearCanvasLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClearCanvasAlertDialog();
            }
        });

        mEraseDrawing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPaintView.eraseDrawing();
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
