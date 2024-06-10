package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

public class BookingScreenActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private ImageButton returnBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_screen);

        // Find the ImageButtons by ID
        backBtn = findViewById(R.id.back_btn);
        returnBtn = findViewById(R.id.return_btn);

        // Set a click listener on the back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity (e.g., go back to the previous activity)
                // Replace ExampleActivity.class with the class of the activity you want to navigate to
                Intent intent = new Intent(BookingScreenActivity.this, ConfirmationActivity.class);
                startActivity(intent);
            }
        });

        // Set a click listener on the return button
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to another activity (e.g., go to ReturnActivity)
                Intent intent = new Intent(BookingScreenActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}