package com.woohoo.mobile.example.app;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.woohoo.mobile.sdk.WoohooSDK;

public class ExampleActivity extends ActionBarActivity {

    private WoohooSDK woohoo;
    private TextView balanceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        String secretKey = "ZhGXLnyBKkWo3c4R1MLc+d3JOSpCovYBRsoWei6STL+T0gffSHUMUS9qt7zBjA/jt1kMV9es5i10r3gFQV4qnw";
        String apiKey = "APbEY+gpkKM5gQ==";
        WoohooSDK.initialize(apiKey, secretKey, true);
        woohoo = WoohooSDK.getInstance(ExampleActivity.this);

        balanceView = (TextView) findViewById(R.id.current_balance);
        int balance = woohoo.getBalance();
        balanceView.setText(getString(R.string.your_current_balance) + ": " + balance);

        Button startButton = (Button) findViewById(R.id.button_start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                woohoo.showOffers();
            }
        });

        Button incButton = (Button) findViewById(R.id.button_inc);
        incButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userUsedAppInParticularWay();
            }
        });
    }

    private void userUsedAppInParticularWay(){
        int newBalance = woohoo.increaseBalance(100);
        balanceView.setText(getString(R.string.your_current_balance) + ": " + newBalance);
    }


}
