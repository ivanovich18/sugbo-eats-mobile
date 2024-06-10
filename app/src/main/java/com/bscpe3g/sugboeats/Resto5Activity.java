package com.bscpe3g.sugboeats;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Resto5Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resto5);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Sizzling Sisig", "Sizzling medley of chopped pork face, ears, and liver, seasoned with calamansi, onions, and chili peppers.", 220.00, R.drawable.sizzling_sisig));
            menuItems.add(new MenuItem("Kare-Kare", "Oxtail and tripe stew in a rich peanut sauce, served with our very own bagoong on the side.", 250.00, R.drawable.kare_kare));
        menuItems.add(new MenuItem("Bulalo", "Hearty beef shank and bone marrow soup with vegetables and spices served piping hot.", 280.00, R.drawable.bulalo));
        menuItems.add(new MenuItem("Pork Binagoongan", "Pork belly cooked in bagoong (shrimp paste), a salty and umami-rich condiment that complements the richness of the pork.", 300.00, R.drawable.pork_binagoongan));
        menuItems.add(new MenuItem("Chicken Afritada", "Chicken braised in a tomato sauce with potatoes, carrots, and peas, offering a comforting and flavorful option.", 250.00, R.drawable.chicken_afritada));
        menuItems.add(new MenuItem("Pochero", "A hearty beef stew with saba bananas, vegetables, and chorizo, simmered in a tomato-based broth.", 380.00, R.drawable.pochero));

        RecyclerView recyclerView = findViewById(R.id.menu_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MenuAdapter adapter = new MenuAdapter(menuItems);
        recyclerView.setAdapter(adapter);

        // Add divider item decoration
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
        Drawable dividerDrawable = ContextCompat.getDrawable(this, R.drawable.custom_divider);
        if (dividerDrawable != null) {
            dividerItemDecoration.setDrawable(dividerDrawable);
        }
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}