package com.woohoo.mobile.example.app;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.woohoo.mobile.sdk.StatusCallback;
import com.woohoo.mobile.sdk.WoohooSDK;
import com.woohoo.mobile.sdk.exception.WoohooException;

public class ExampleActivity extends ActionBarActivity {

    private WoohooSDK mWoohoo;
    private TextView mBalanceView;
    private TextView mNotAvailableView;
    private TextView mNewOffers;

    private int mBalance;

    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        mStartButton = (Button) findViewById(R.id.button_start);
        mBalanceView = (TextView) findViewById(R.id.current_balance);
        mNotAvailableView = (TextView) findViewById(R.id.not_available_text);
        mNewOffers = (TextView) findViewById(R.id.new_offers);
        String secretKey = "ZhGXLnyBKkWo3c4R1MLc+d3JOSpCovYBRsoWei6STL+T0gffSHUMUS9qt7zBjA/jt1kMV9es5i10r3gFQV4qnw==";
        String apiKey = "APbEY+gpkKM5gQ==";


        final StatusCallback statusCallback = new StatusCallback() {

            @Override
            public void newOfferCount(int count) {
                if (count > 0) {
                    mNewOffers.setVisibility(View.VISIBLE);
                    mNewOffers.setText(Integer.toString(count));
                } else {
                    mNewOffers.setVisibility(View.GONE);
                }
            }

            @Override
            public void isAvailable(boolean available) {
                if (available) {
                    mStartButton.setVisibility(View.VISIBLE);
                    mNotAvailableView.setVisibility(View.INVISIBLE);
                } else {
                    // Woohoo offers not available for users location/country
                    // if you want you can show the button anyways
                    mNotAvailableView.setVisibility(View.VISIBLE);
                    mStartButton.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void failure(WoohooException we) {
                // request failed - your choice what you want to do here...
                mStartButton.setVisibility(View.VISIBLE);
            }
        };


        mWoohoo = new WoohooSDK.Builder()
                .setApiKey(apiKey).setSecret(secretKey)
                .setStatusCallback(statusCallback)
                .useSandboxServer()
                .setVirtualCurrencyName("Points")
                .setContext(this.getApplicationContext()).build();


        mBalance = mWoohoo.getBalance();
        mBalanceView.setText(getString(R.string.your_current_balance) + ": " + mBalance + " " + mWoohoo.getVirtualCurrencyName());


        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWoohoo.showOffers();
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

    private void userUsedAppInParticularWay() {
        int newBalance = mWoohoo.increaseBalance(100);
        mBalanceView.setText(getString(R.string.your_current_balance) + ": " + newBalance);
    }


}
