package net.paullarkin.bankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void openStandardAccount(View view)
    {
        Intent standardAccIntent = new Intent(this, StandardAccount.class);
        startActivity(standardAccIntent);
    }

    public void openLimitedAccount(View view)
    {
        Intent limitedAccIntent = new Intent(this, LimitedAccount.class);
        startActivity(limitedAccIntent);
    }
}