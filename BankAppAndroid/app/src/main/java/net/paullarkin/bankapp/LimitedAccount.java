package net.paullarkin.bankapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class LimitedAccount extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#.00");
    public double balance = 20.00;
    private static final double OVERDRAFT = -100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limited);

    }

    public void onClickDeposit(View view)
    {

        EditText enteredAmount = findViewById(R.id.editText_amount);
        TextView currentBalance = findViewById(R.id.tvBalance);
        String depositStringValue = enteredAmount.getText().toString();

        if(TextUtils.isEmpty(depositStringValue)) {
            enteredAmount.setError("Amount cant be empty");
            return;
        }

        double amount = Double.parseDouble(depositStringValue);

        if(amount > 50.00)
        {
            Toast.makeText(getApplicationContext(),"You have gone over your deposit limit \nPlease enter an amount less than £50 and try again!",Toast.LENGTH_SHORT).show();

        }else {
            balance = balance + amount;
            Toast.makeText(getApplicationContext(),"Balance Updated",Toast.LENGTH_SHORT).show();
        }

        String ldBalanceFormatted= df.format(balance);
        currentBalance.setText(ldBalanceFormatted);
        enteredAmount.getText().clear();

    }

    public void onClickWithdraw(View view)
    {
        EditText enteredAmountWithDraw = findViewById(R.id.editText_amount);
        TextView currentBalanceTwo = findViewById(R.id.tvBalance);
        String stringValueWithdraw = enteredAmountWithDraw.getText().toString();

        if(TextUtils.isEmpty(stringValueWithdraw)) {
            enteredAmountWithDraw.setError("Amount cant be empty");
            return;
        }

        double amount = Double.parseDouble(stringValueWithdraw);

        if(amount > 100)
        {

            Toast.makeText(getApplicationContext(),"You have gone over your withdraw limit \n Please enter an amount less than £100 and try again!",Toast.LENGTH_SHORT).show();

        }
        else if( balance - amount < OVERDRAFT) {
            Toast.makeText(getApplicationContext(),"You have exceeded your overdraft limit",Toast.LENGTH_SHORT).show();
        }
        else
        {
            balance = balance - amount;
            Toast.makeText(getApplicationContext(),"Balance Updated",Toast.LENGTH_SHORT).show();

            if(balance < 0)
            {
                Toast.makeText(getApplicationContext(),"Your account is entering an overdraft",Toast.LENGTH_SHORT).show();
            }

            String lwBalanceFormatted= df.format(balance);
            currentBalanceTwo.setText(lwBalanceFormatted);
            enteredAmountWithDraw.getText().clear();

        }


    }

}