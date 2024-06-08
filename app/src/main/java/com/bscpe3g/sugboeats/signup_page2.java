package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class signup_page2 extends AppCompatActivity {
    private EditText emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page2);

        emailText = findViewById(R.id.emailText);

        // Add touch listener on emailText to detect touch on the drawable
        emailText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (emailText.getRight() - emailText.getCompoundDrawables()[2].getBounds().width())) {
                        // Clicked on the drawable (right)
                        emailText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
    }

    // Method to handle back navigation
    public void goBack(View view) {
        // Navigate back to signup_page1
        Intent intent = new Intent(signup_page2.this, signup_page1.class);
        startActivity(intent);
        finish(); // Optional: finish the current activity to remove it from the back stack
    }
}
