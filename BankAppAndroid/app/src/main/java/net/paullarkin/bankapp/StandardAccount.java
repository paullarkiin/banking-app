package net.paullarkin.bankapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class StandardAccount extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("#.00");
    public double balance = 30.00;
    private static final double OVERDRAFT = -100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);

    }

    public void onClickDeposit(View view)
    {
        // so get the amount from the EditText line
        EditText enteredAmount = findViewById(R.id.editText_amount);
        TextView currentBalance = findViewById(R.id.tvBalance);
        String depositStringValue = enteredAmount.getText().toString();

        if(TextUtils.isEmpty(depositStringValue)) {
            enteredAmount.setError("Amount cant be empty");
            return;
        }

        double amount = Double.parseDouble(depositStringValue);

        balance = balance + amount;
        String dBalanceFormatted= df.format(balance);

        currentBalance.setText(dBalanceFormatted);
        enteredAmount.getText().clear();

        Toast.makeText(getApplicationContext(),"Balance Updated",Toast.LENGTH_SHORT).show();
    }

    public void onClickWithdraw(View view)
    {
        EditText enteredAmountWithdraw = findViewById(R.id.editText_amount);
        TextView currentBalanceTwo = findViewById(R.id.tvBalance);
        String stringValueWithdraw = enteredAmountWithdraw.getText().toString();

        if(TextUtils.isEmpty(stringValueWithdraw)) {
            enteredAmountWithdraw.setError("Amount cant be empty");
            return;
        }

        double amount = Double.parseDouble(stringValueWithdraw);

        if( balance - amount < OVERDRAFT) {
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

            String wBalanceFormatted= df.format(balance);
            currentBalanceTwo.setText(wBalanceFormatted);
            enteredAmountWithdraw.getText().clear();


        }


    }

}