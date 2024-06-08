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

public class Resto4Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resto4);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Sinugbang Panga ng Tuna", "A generous portion of tuna jaw marinated in a special mix of herbs and spices, grilled to perfection.", 400.00, R.drawable.tuna_panga));
        menuItems.add(new MenuItem("Sinugbang Pusit", "Fresh squid stuffed with tomatoes and onions, marinated in a citrusy blend, and grilled to a tender perfection.", 350.00, R.drawable.sinugbang_pusit));
        menuItems.add(new MenuItem("Kinilaw na Isda", "Fresh fish marinated in vinegar, calamansi juice, ginger, onions, and chili peppers.", 220.00, R.drawable.kinilaw_na_isda));
        menuItems.add(new MenuItem("Inihaw na Liempo", "Grilled pork belly marinated in a sweet and savory soy-calamansi sauce, served with a side of atchara (pickled papaya).", 280.00, R.drawable.inihaw_na_liempo));
        menuItems.add(new MenuItem("Baked Scallops", "Fresh scallops baked with butter, garlic, and herbs, served with a squeeze of lemon.", 350.00, R.drawable.baked_scallops));
        menuItems.add(new MenuItem("Shrimp Gambas", "Sizzling garlic shrimp cooked in olive oil, chili flakes, and paprika.", 320.00, R.drawable.shrimp_gambas));

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