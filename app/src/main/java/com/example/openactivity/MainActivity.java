package com.example.openactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String EXTRA_NUM1 = "EXTRA_NUM1";
    private static final String EXTRA_NUM2 = "EXTRA_NUM2";
    private TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newActivity = (Button) findViewById(R.id.btnNewActivity);
        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText num1 = (EditText) findViewById(R.id.txtNum1);
                EditText num2 = (EditText) findViewById(R.id.txtNum2);
                display = (TextView) findViewById(R.id.txtDisplay);

                if(num1.getText().toString().equals("") || num2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please enter two numbers",Toast.LENGTH_SHORT).show();
                }else{
                    Intent calculatorIntent = new Intent(MainActivity.this,MainActivity2.class);
                    calculatorIntent.putExtra(EXTRA_NUM1,Integer.parseInt(num1.getText().toString()));
                    calculatorIntent.putExtra(EXTRA_NUM2,Integer.parseInt(num2.getText().toString()));
                    startActivityForResult(calculatorIntent,1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1){
            if(resultCode==RESULT_OK){
                int result = data.getIntExtra("result",0);
                display.setText("ANSWER IS : "+result);
            }
            if(requestCode==RESULT_CANCELED){
                display.setText("Nothing selected");
            }

        }
    }
}