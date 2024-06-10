package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SuccessfulBookingActivity extends AppCompatActivity {
    private Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_booking);

        homeBtn = findViewById(R.id.return_home_button);

        // Set a click listener on the return button
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity (e.g., go to ReturnActivity)
                Intent intent = new Intent(SuccessfulBookingActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
