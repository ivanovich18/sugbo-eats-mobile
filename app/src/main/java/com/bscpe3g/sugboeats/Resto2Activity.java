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

public class Resto2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resto2);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Satay", "Grilled marinated meat skewers served with a savory peanut sauce. Perfect for a quick bite.", 250.00, R.drawable.satay));
        menuItems.add(new MenuItem("Fried Chicken", "Crispy and juicy deep-fried chicken wings and drumsticks, served with flavorful dipping sauces.", 300.00, R.drawable.fried_chicken));
        menuItems.add(new MenuItem("Pizza", "Classic pizza with tomato sauce, cheese, and your choice of toppings, baked to perfection.", 250.00, R.drawable.pizza));
        menuItems.add(new MenuItem("Vegetable Curry", "A fragrant and flavorful vegetable curry made with a medley of fresh vegetables simmered in a creamy coconut milk-based sauce.", 250.00, R.drawable.vegetable_curry));
        menuItems.add(new MenuItem("Grilled Salmon", "A succulent salmon fillet seasoned with herbs and spices, grilled to perfection, and served with a lemon-dill sauce.", 450.00, R.drawable.grilled_salmon));
        menuItems.add(new MenuItem("Pad Thai", "A popular Thai noodle dish stir-fried with rice noodles, tofu, eggs, bean sprouts, and a tangy sauce.", 280.00, R.drawable.pad_thai));

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