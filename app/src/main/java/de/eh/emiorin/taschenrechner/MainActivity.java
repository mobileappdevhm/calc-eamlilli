package de.eh.emiorin.taschenrechner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private double num1;
    private double num2;
    private double sum;

    private char CURRENT_ACTION;

    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button ac, plus_minus, percent, divide, multiply, minus, plus, double_zero, dot, equals;

    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private TextView outputResult, display, operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputResult = (TextView) findViewById(R.id.display);
        outputResult.setText("");

        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        plus = (Button) findViewById(R.id.plus);
        minus = (Button) findViewById(R.id.minus);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        plus_minus = (Button) findViewById(R.id.plus_minus);
        ac = (Button) findViewById(R.id.ac);
        percent = (Button) findViewById(R.id.percent);
        dot = (Button) findViewById(R.id.dot);
        double_zero = (Button) findViewById(R.id.double_zero);
        equals = (Button) findViewById(R.id.equal);
        display = (TextView) findViewById(R.id.display);
        operation = (TextView) findViewById(R.id.operation);


        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
                operation.setText("");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"0");
            }
        });
        double_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText()+"00");
            }
        });

        plus_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double tmp = Double.parseDouble(display.getText().toString()) * -1;

                display.setText(Double.toString(tmp));
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(display.getText().toString());
                CURRENT_ACTION = DIVISION;
                operation.setText(display.getText() + " / ");
                display.setText("");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(display.getText().toString());
                CURRENT_ACTION = MULTIPLICATION;
                operation.setText(display.getText() + " * ");
                display.setText("");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(display.getText().toString());
                CURRENT_ACTION = SUBTRACTION;
                operation.setText(display.getText() + " - ");
                display.setText("");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(display.getText().toString());
                CURRENT_ACTION = ADDITION;
                operation.setText(display.getText() + " + ");
                display.setText("");
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num2 = Double.parseDouble(display.getText().toString());
                Log.i("CURRENT_ACTION", Character.toString(CURRENT_ACTION));
                switch (CURRENT_ACTION) {
                    case '+':
                        Log.i("CURRENT_ACTION", "Plus");
                        sum = num1 + num2;
                        break;
                    case '-':
                        Log.i("CURRENT_ACTION", "Minus");
                        sum = num1 - num2;
                        break;
                    case '*':
                        Log.i("CURRENT_ACTION", "Multiplikation");
                        sum = num1 * num2;
                        break;
                    case '/':
                        Log.i("CURRENT_ACTION", "Division");
                        sum = num1 / num2;
                        break;
                }
                operation.setText(operation.getText().toString() + display.getText());
                display.setText(Double.toString(sum));
                num1 = 0;
                num2 = 0;
                
            }
        });

    }
}
