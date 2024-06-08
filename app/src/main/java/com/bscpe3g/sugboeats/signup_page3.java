package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class signup_page3 extends AppCompatActivity {
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private AppCompatButton button;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup_page3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page3);

        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        button = findViewById(R.id.button);

        // Add touch listener on emailText to detect touch on the drawable
        passwordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (passwordEditText.getRight() - passwordEditText.getCompoundDrawables()[2].getBounds().width())) {
                        // Clicked on the drawable (right)
                        passwordEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        // Add touch listener on editTextText2 to detect touch on the drawable
        confirmPasswordEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (confirmPasswordEditText.getRight() - confirmPasswordEditText.getCompoundDrawables()[2].getBounds().width())) {
                        // Clicked on the drawable (right)
                        confirmPasswordEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        // Add OnClickListener to the button
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from passwordEditText and confirmPasswordEditText
                String text1 = passwordEditText.getText().toString();
                String text2 = confirmPasswordEditText.getText().toString();
            }
        });
    }
    public void goBack(View view) {
        // Navigate back to signup_page2
        Intent intent = new Intent(signup_page3.this, signup_page2.class);
        startActivity(intent);
        finish(); // Optional: finish the current activity to remove it from the back stack
    }
}
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
