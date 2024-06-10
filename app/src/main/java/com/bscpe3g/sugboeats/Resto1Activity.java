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

public class Resto1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resto1);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Humba", "A Cebuano classic dish features tender pork belly slow-cooked in various rich sauce.", 320.00, R.drawable.humba));
        menuItems.add(new MenuItem("Bam-i", "A harmonious blend of pancit canton and bihon noodles, stir-fried with a medley of different kinds of meat.", 180.00, R.drawable.bam_i));
        menuItems.add(new MenuItem("Tinola with Papaya", "A comforting chicken soup simmered with green papaya and malunggay leaves.", 160.00, R.drawable.tinola_with_papaya));
        menuItems.add(new MenuItem("Lechon (1 kg)", "A whole roasted pig with crispy skin and juicy meat, a staple in Filipino celebrations.", 950.00, R.drawable.lechon));
        menuItems.add(new MenuItem("Pancit Palabok", "A festive noodle dish topped with a flavorful shrimp sauce, smoked fish flakes, boiled eggs, and chicharon.", 220.00, R.drawable.palabok));
        menuItems.add(new MenuItem("Bicol Express", "A fiery dish from the Bicol region, known for its spicy coconut milk-based sauce with chili peppers and pork.", 280.00, R.drawable.bicol_xpress));

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