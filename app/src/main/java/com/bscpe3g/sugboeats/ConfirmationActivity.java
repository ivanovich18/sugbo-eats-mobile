package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmationActivity extends AppCompatActivity {

    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("firstName");
        String lastName = intent.getStringExtra("lastName");
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String emailAddress = intent.getStringExtra("emailAddress");
        String customerAddress = intent.getStringExtra("customerAddress");
        String reservationDate = intent.getStringExtra("reservationDate");
        String reservationTime = intent.getStringExtra("reservationTime");
        String settingType = intent.getStringExtra("settingType");
        String numberOfGuests = intent.getStringExtra("numberOfGuests");
        String specialRequests = intent.getStringExtra("specialRequests");
        Restaurant restaurant = (Restaurant) intent.getSerializableExtra("restaurant");

        // Populate TextViews with retrieved data
        TextView firstNameTextView = findViewById(R.id.first_name_confirm2);
        TextView lastNameTextView = findViewById(R.id.last_name_confirm2);
        TextView phoneTextView = findViewById(R.id.phone_confirm2);
        TextView emailTextView = findViewById(R.id.email_confirm2);
        TextView addressTextView = findViewById(R.id.address_confirm2);
        TextView dateTextView = findViewById(R.id.date_confirm2);
        TextView timeTextView = findViewById(R.id.time_confirm2);
        TextView settingTextView = findViewById(R.id.setting_confirm);
        TextView guestsTextView = findViewById(R.id.guests_confirm);
        TextView requestsTextView = findViewById(R.id.requests_confirm);

        firstNameTextView.setText(firstName != null ? firstName : "N/A");
        lastNameTextView.setText(lastName != null ? lastName : "N/A");
        phoneTextView.setText(phoneNumber != null ? phoneNumber : "N/A");
        emailTextView.setText(emailAddress != null ? emailAddress : "N/A");
        addressTextView.setText((customerAddress != null && !customerAddress.isEmpty()) ? customerAddress : "N/A");
        dateTextView.setText(reservationDate != null ? reservationDate : "N/A");
        timeTextView.setText(reservationTime != null ? reservationTime : "N/A");
        settingTextView.setText((settingType != null && !settingType.isEmpty()) ? settingType : "N/A");
        guestsTextView.setText((numberOfGuests != null && !numberOfGuests.isEmpty()) ? numberOfGuests : "N/A");
        requestsTextView.setText((specialRequests != null && !specialRequests.isEmpty()) ? specialRequests : "N/A");

        // Populate restaurant data
        ImageView restaurantImageView = findViewById(R.id.restaurant_placeholder);
        TextView restaurantNameTextView = findViewById(R.id.reservation_date_contact);
        TextView restaurantLocationTextView = findViewById(R.id.reservation_time_contact);

        if (restaurant != null) {
            restaurantImageView.setImageResource(restaurant.getImageResourceId());
            restaurantNameTextView.setText(restaurant.getName() != null ? restaurant.getName() : "N/A");
            restaurantLocationTextView.setText(restaurant.getLocation() != null ? restaurant.getLocation() : "N/A");
        } else {
            restaurantNameTextView.setText("N/A");
            restaurantLocationTextView.setText("N/A");
        }

        // Handle insets to avoid hiding button behind navigation bar
        backButton = findViewById(R.id.back_button_contact);
        ViewCompat.setOnApplyWindowInsetsListener(backButton, (v, insets) -> {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.topMargin = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top + params.topMargin;
            return insets;
        });

        backButton.setOnClickListener(v -> {
            Intent backIntent = new Intent(ConfirmationActivity.this, ContactInformationActivity.class);
            backIntent.putExtra("firstName", firstName);
            backIntent.putExtra("lastName", lastName);
            backIntent.putExtra("phoneNumber", phoneNumber);
            backIntent.putExtra("emailAddress", emailAddress);
            backIntent.putExtra("customerAddress", customerAddress);
            backIntent.putExtra("reservationDate", reservationDate);
            backIntent.putExtra("reservationTime", reservationTime);
            backIntent.putExtra("settingType", settingType);
            backIntent.putExtra("numberOfGuests", numberOfGuests);
            backIntent.putExtra("specialRequests", specialRequests);
            backIntent.putExtra("restaurant", restaurant);
            startActivity(backIntent);
        });
    }
}
