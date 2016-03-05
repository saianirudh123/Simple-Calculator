package com.example.sai.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.*;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {


    EditText etNum1;
    EditText etNum2;

    Button add;
    Button sub;
    Button mul;
    Button div;

    TextView tvResult;
    String oper = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find the elements
        etNum1 = (EditText) findViewById(R.id.editText);
        etNum2 = (EditText) findViewById(R.id.editText2);

        add = (Button) findViewById(R.id.button);
        sub = (Button) findViewById(R.id.button4);
        mul = (Button) findViewById(R.id.button2);
        div = (Button) findViewById(R.id.button3);

        tvResult = (TextView) findViewById(R.id.textView);

        // set a listener
        add.setOnClickListener((OnClickListener) this);
        sub.setOnClickListener((OnClickListener) this);
        mul.setOnClickListener((OnClickListener) this);
        div.setOnClickListener((OnClickListener) this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (v.getId()) {
            case R.id.button:
                oper = "+";
                result = num1 + num2;
                break;
            case R.id.button4:
                oper = "-";
                result = num1 - num2;
                break;
            case R.id.button2:
                oper = "*";
                result = num1 * num2;
                break;
            case R.id.button3:
                oper = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

/*
    public void onClick(View v) {
        // TODO Auto-generated method stub

    }*/
}


