package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Resto3Activity extends AppCompatActivity {

    private Button makeReservationButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resto3);

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Pork Barbecue", "Pork Barbecue is a dish composed of marinated pork slices that are skewered and grilled", 200.00, R.drawable.pork_bbq));
        menuItems.add(new MenuItem("Isaw", "Isaw, made from barbecued chicken intestines, is a beloved Filipino street food known for its unique flavor.", 150.00, R.drawable.isaw));
        menuItems.add(new MenuItem("Betamax", "Grilled coagulated chicken or pork blood, named after its resemblance to Betamax tapes.", 150.00, R.drawable.betamax));
        menuItems.add(new MenuItem("Adidas", "Grilled chicken feet, a popular street food known for its chewy texture and savory flavor.", 130.00, R.drawable.adidas));
        menuItems.add(new MenuItem("Kwek-Kwek", "Deep-fried quail eggs coated in bright orange batter, served with vinegar or sweet and sour sauce.", 140.00, R.drawable.kwek_kwek));
        menuItems.add(new MenuItem("Gimbap", "Korean dish made from cooked rice, vegetables, fish, and meat rolled in gim dried sheets of seaweed.", 180.00, R.drawable.gimbap));

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

        makeReservationButton = findViewById(R.id.button_make_reservation_kasikas);
        makeReservationButton.setOnClickListener(v -> {
            Intent intent = new Intent(Resto3Activity.this, ReservationFormActivity.class);

            Restaurant restaurant = new Restaurant(
                    "Kasikas",
                    "Fuente Osmeña Avenue, Cebu City",
                    R.drawable.resto3_pic // Assume R.drawable.restaurant1_image is the image resource ID
            );
            intent.putExtra("restaurant", restaurant);
            startActivity(intent);
        });
    }
}