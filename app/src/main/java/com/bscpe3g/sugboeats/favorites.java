package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class favorites extends AppCompatActivity {

    private EditText searchBar;
    private ImageButton searchButton;
    private TextView resultText;
    private ImageButton imagehome;
    private ImageButton imagesched;
    private ImageButton imagefave;
    private ImageButton imageprof;
    private ImageButton fav1;
    private ImageButton fav2;
    private ImageButton favorite1;
    private ImageButton favorite2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        // Find views by their ID
        searchBar = findViewById(R.id.search_bar);
        searchButton = findViewById(R.id.search_button);
        resultText = findViewById(R.id.result_text);
        imagehome = findViewById(R.id.imagehome);
        imagesched = findViewById(R.id.imagesched);
        imagefave = findViewById(R.id.imagefave);
        imageprof = findViewById(R.id.imageprof);
        fav1 = findViewById(R.id.fav1);
        fav2 = findViewById(R.id.fav2);
        favorite1 = findViewById(R.id.favorite1);
        favorite2 = findViewById(R.id.favorite2);

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

        imagehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the home activity (if applicable)
                Intent intent = new Intent(favorites.this, homescreen.class);
                startActivity(intent);
            }
        });

        imagesched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the schedule activity (if applicable)
                Intent intent = new Intent(favorites.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        imagefave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the favorites activity (if applicable)
                Intent intent = new Intent(favorites.this, favorites.class);
                startActivity(intent);
            }
        });

        imageprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the profile activity (if applicable)
                Intent intent = new Intent(favorites.this, ProfileActivity.class);
                startActivity(intent);
            }
        });


        favorite1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove favorite1 from the layout
                ViewGroup parent = (ViewGroup) favorite1.getParent();
                parent.removeView(favorite1);
            }
        });

        // Set a click listener on favorite2
        favorite2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove favorite2 from the layout
                ViewGroup parent = (ViewGroup) favorite2.getParent();
                parent.removeView(favorite2);
            }
        });

    }
}