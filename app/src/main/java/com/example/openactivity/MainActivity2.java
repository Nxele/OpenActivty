package com.example.openactivity;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnAdd;
    private Button btnSubtract;
    private int number1;
    private int number2;
    private int calculations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Calculate Activity");

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSubtract = (Button) findViewById(R.id.btnSubract);

        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);

        Intent fromHomepage = getIntent();
        number1 = fromHomepage.getIntExtra("EXTRA_NUM1",0);
        number2 = fromHomepage.getIntExtra("EXTRA_NUM2",0);

        TextView display1 = (TextView) findViewById(R.id.txtViewNum1);
        TextView display2 = (TextView) findViewById(R.id.txtViewNum2);

        display1.setText("Num one is :"+number1);
        display2.setText("Num two is :"+number2);
    }

    @Override
    public void onClick(View view){
        Intent resultIntent = new Intent(); //for going back to homepage
        switch (view.getId()){
            case R.id.btnAdd :
                calculations = number1+number2;
                Toast.makeText(this,"TWO NUMBERS ADDED",Toast.LENGTH_SHORT).show();
                resultIntent.putExtra("result",calculations);
                setResult(RESULT_OK,resultIntent);
                finish();
                break;
            case R.id.btnSubract:
                calculations = number1-number2;
                Toast.makeText(this,"TWO NUMBERS SUBTRACTED",Toast.LENGTH_SHORT).show();
                resultIntent.putExtra("result",calculations);
                setResult(RESULT_OK,resultIntent);
                finish();
                break;
        }
    }
}