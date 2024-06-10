package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class signup_page1 extends AppCompatActivity {
=======

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup_page1 extends AppCompatActivity {


>>>>>>> ae52ffd404177f4216aaa01bab5fd2fb0da1a3fa
    private EditText editTextText;
    private EditText editTextText2;
    private AppCompatButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page1);

        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        button = findViewById(R.id.button);

        // Add touch listener on editTextText to detect touch on the drawable
        editTextText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (editTextText.getRight() - editTextText.getCompoundDrawables()[2].getBounds().width())) {
                        // Clicked on the drawable (right)
                        editTextText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        // Add touch listener on editTextText2 to detect touch on the drawable
        editTextText2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (editTextText2.getRight() - editTextText2.getCompoundDrawables()[2].getBounds().width())) {
                        // Clicked on the drawable (right)
                        editTextText2.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        // Add OnClickListener to the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to signup_page2
                Intent intent = new Intent(signup_page1.this, signup_page2.class);

                // Start the activity
                startActivity(intent);
            }
        });
    }
}
<<<<<<< HEAD
=======
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
>>>>>>> ae52ffd404177f4216aaa01bab5fd2fb0da1a3fa
