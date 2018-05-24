package com.example.humaira.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {

    //for checking in switch case
    private static final String ADDITION = "+" ;
    private static final String SUBTRACTION = "-" ;
    private static final String MULTIPLICATION = "*" ;
    private static final String DIVISION = "/" ;
    private static final String EQ = "=";
    private static final String MOD = "%" ;
    private static final String POWER = "^";

    private String ACTION;
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button add;
    Button sub;
    Button mul;
    Button div;
    Button eq;
    Button mod;
    Button pow;
    Button dot;
    Button clear;
    TextView cal;
    TextView res;
    Double val1;
    Double val2;
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //loading the UI components
        setUI(); //initialize widgets
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"0"); //simply keep concatenating
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"5");

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"6");

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+"9");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.setText(cal.getText()+".");
            }
        });

        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(); //previous operator will get applied
                ACTION = EQ;
                res.setText("= "+new Double(val1).toString()); //
                cal.setText("");
                val2 = 0.0;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                if(!flag) {
                    val1 = parseDouble(cal.getText().toString());
                    result+=val1;
                }
                else{
                    val2 = parseDouble(cal.getText().toString());
                    result+=val2;
                }*/
              //  cal.setText(cal.getText()+"+");
                compute(); //a[[ly previous operation
                ACTION = ADDITION; //once next operator is pressed or equal to is pressed this will run
                res.setText(String.valueOf(val1)+ADDITION); //serves a lot of purpose
                cal.setText(""); //clear text area

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                res.setText(String.valueOf(val1)+SUBTRACTION);
                cal.setText("");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                res.setText(String.valueOf(val1)+MULTIPLICATION);
                cal.setText("");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                res.setText(String.valueOf(val1)+DIVISION);
                cal.setText("");
            }
        });

      /*  mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MOD;
                res.setText(String.valueOf(val1)+MOD);
                cal.setText("");
            }
        });*/

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = POWER;
                res.setText(String.valueOf(val1)+POWER);
                cal.setText("");
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clear everything to initial state
                res.setText("");
                cal.setText("");
                val1 = null;
                val2 = null;
            }
        });
    }

    private void compute() {
        if(val1!=null && !cal.getText().toString().equals("")){
            Log.d("HUMAIRA:", "IF"); //if val1 exists and operator has been entered and val2 exists
            val2 = Double.parseDouble(cal.getText().toString());
            switch(ACTION){
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACTION:
                    val1 = val1 - val2;
                    break;
                case MULTIPLICATION:
                    val1 = val1 * val2;
                    break;
                case DIVISION:
                    if(val2!=0)
                        val1 = val1 / val2;
                    break;
                /*case MOD:
                    if(val2!=0)

                        Log.d("HUMAIRA: ",new Double(val1).toString());
                        Log.d("HUMAIRA: ",new Double(val2).toString());
                        val1 = (val1 / val2) * 100;
                    Log.d("HUMAIRA: ","="+String.valueOf(val1));*/
                case POWER:
                    val1 = Math.pow(val1,val2);
                    break;
                case EQ:
                    break;

            }
        }
        else if (!cal.getText().toString().equals("")){
                Log.d("HUMAIRA:", "ELSE");
                val1 = Double.parseDouble(cal.getText().toString());} //if some no is entered and no op has been entered
        else if(val1 == null){
                val1 = 0.0;//initially val1 is null and an operator is applied
        }

    }

    public void setUI(){
        zero = (Button)findViewById(R.id.B0);
        one = (Button)findViewById(R.id.B1);
        two = (Button)findViewById(R.id.B2);
        three = (Button)findViewById(R.id.B3);
        four = (Button)findViewById(R.id.B4);
        five = (Button)findViewById(R.id.B5);
        six = (Button)findViewById(R.id.B6);
        seven = (Button)findViewById(R.id.B7);
        eight = (Button)findViewById(R.id.B8);
        nine = (Button)findViewById(R.id.B9);
        add = (Button)findViewById(R.id.plus);
        sub = (Button)findViewById(R.id.minus);
        mul = (Button)findViewById(R.id.mul);
        div = (Button)findViewById(R.id.div);
        eq = (Button)findViewById(R.id.eq);
        clear = (Button)findViewById(R.id.clr);
        cal = (TextView)findViewById(R.id.screen);
        res = (TextView)findViewById(R.id.result);
        //mod = (Button)findViewById(R.id.mod);
        pow = (Button)findViewById(R.id.power);
        dot = (Button)findViewById(R.id.dot);

    }
    /*

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void startService(View view){
        startService(new Intent(getBaseContext(),MyService.class));

    }

    public void stopService(View view){
        stopService(new Intent(getBaseContext(),MyService.class));
    }

    public void sendMessage(View view){
        EditText pass = findViewById(R.id.pass);
        String msg = pass.getText().toString();
        Intent intent = new Intent(this, Message.class);
        intent.putExtra("EXTRA_MESSAGE", msg);
        startActivity(intent);
    }*/
}
