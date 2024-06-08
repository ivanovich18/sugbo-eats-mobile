package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class signup_page1 extends AppCompatActivity {
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

        // Add touch listener on emailText to detect touch on the drawable
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
                // Get the text from editTextText and editTextText2
                String text1 = editTextText.getText().toString();
                String text2 = editTextText2.getText().toString();

                // Create an intent to navigate to signup_page2
                Intent intent = new Intent(signup_page1.this, signup_page2.class);

                // Pass the text as extras to the intent
                intent.putExtra("text1", text1);
                intent.putExtra("text2", text2);

                // Start the activity
                startActivity(intent);
            }
        });
    }
}
