package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText textIn1,textIn2;
    Button buttonAdd,done;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textIn1 = (EditText)findViewById(R.id.textin1);
        textIn2 = (EditText)findViewById(R.id.textin2);
        buttonAdd = (Button)findViewById(R.id.add);
        done= (Button)findViewById(R.id.done);
        container = (LinearLayout)findViewById(R.id.container);



        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);
                TextView textOut1 = (TextView)addView.findViewById(R.id.textout1);
                TextView textOut2 = (TextView)addView.findViewById(R.id.textout2);
                textOut1.setText(textIn1.getText().toString());
                textOut2.setText(textIn2.getText().toString());
                textIn1.setText("");
                textIn2.setText("");

                textIn1.clearFocus();
                textIn2.clearFocus();


                container.addView(addView);
            }});





        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 0; i < container.getChildCount(); i++) {
                    View view = container.getChildAt(i);

                    TextView ed_item1 = (TextView) view
                            .findViewById(R.id.textout1);

                    TextView ed_item2 = (TextView) view
                            .findViewById(R.id.textout2);


                    Log.d("tesster"," " + ed_item1.getText().toString().trim() +"...." +ed_item2.getText().toString().trim());

                }

            }
        });


    }

}