package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to account_page
<<<<<<< HEAD
                Intent intent = new Intent(settings.this, account_page.class);
=======
                Intent intent = new Intent(settings.this, AccountPageActivity.class);
>>>>>>> ae52ffd404177f4216aaa01bab5fd2fb0da1a3fa
                startActivity(intent);
            }
        });
    }

    public void goBack(View view) {
        // Handle the go back logic if any
        finish(); // or whatever logic you have for going back
    }
}
