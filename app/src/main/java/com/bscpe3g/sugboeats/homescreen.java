package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class homescreen extends AppCompatActivity {

    private EditText searchBar;
    private ImageButton searchButton;
    private TextView resultText;
    private ImageButton homescreenSale1;
    private ImageButton homescreenSale2;
    private ImageButton resto1;
    private ImageButton resto2;
    private ImageButton resto3;
    private ImageButton resto4;
    private ImageButton resto5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        // Find views by their ID
        searchBar = findViewById(R.id.search_bar);
        searchButton = findViewById(R.id.search_button);
        resultText = findViewById(R.id.result_text);
        homescreenSale1 = findViewById(R.id.homescreen_sale1);
        homescreenSale2 = findViewById(R.id.homescreen_sale2);
        resto1 = findViewById(R.id.resto1);
        resto2 = findViewById(R.id.resto2);
        resto3 = findViewById(R.id.resto3);
        resto4 = findViewById(R.id.resto4);
        resto5 = findViewById(R.id.resto5);

        // Set a click listener on the search button
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the search bar
                String query = searchBar.getText().toString().trim();

                // Perform a search (for simplicity, just set the result text)
                // In a real app, you might query a database or perform a web search
                if (query.isEmpty()) {
                    resultText.setText("Please enter a search term.");
                } else {
                    resultText.setText("Searching for: " + query);
                }
            }
        });


        homescreenSale1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the SecondActivity
                Intent intent = new Intent(homescreen.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // Set a click listener on homescreen_sale2 ImageButton to start a new activity
        homescreenSale2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the ThirdActivity (for example)
                Intent intent = new Intent(homescreen.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

        resto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the desired activity, e.g., Resto1Activity
                Intent intent = new Intent(homescreen.this, Resto1Activity.class);
                startActivity(intent);
            }
        });

        resto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the desired activity, e.g., Resto2Activity
                Intent intent = new Intent(homescreen.this, Resto2Activity.class);
                startActivity(intent);
            }
        });

        resto3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the desired activity, e.g., Resto2Activity
                Intent intent = new Intent(homescreen.this, Resto3Activity.class);
                startActivity(intent);
            }
        });

        resto4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the desired activity, e.g., Resto2Activity
                Intent intent = new Intent(homescreen.this, Resto4Activity.class);
                startActivity(intent);
            }
        });

        resto5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the desired activity, e.g., Resto2Activity
                Intent intent = new Intent(homescreen.this, Resto5Activity.class);
                startActivity(intent);
            }
        });


    }
}