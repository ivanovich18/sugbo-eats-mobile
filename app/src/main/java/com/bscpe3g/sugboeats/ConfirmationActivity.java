package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ConfirmationActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private ImageView backButton;
    private static final String TAG = "ConfirmationActivity";  // Tag for logging

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

        Button makeReservationButton = findViewById(R.id.button_make_reservation2);
        makeReservationButton.setOnClickListener(v -> {

            // Prepare Reservation Data (Map)
            Map<String, Object> reservationData = new HashMap<>();
            reservationData.put("firstName", firstName);
            reservationData.put("lastName", lastName);
            reservationData.put("phoneNumber", phoneNumber);
            reservationData.put("emailAddress", emailAddress);
            reservationData.put("customerAddress", customerAddress);
            reservationData.put("reservationDate", reservationDate);
            reservationData.put("reservationTime", reservationTime);
            reservationData.put("settingType", settingType);
            reservationData.put("numberOfGuests", numberOfGuests);
            reservationData.put("specialRequests", specialRequests);

            // Store restaurant data (if available)
            if (restaurant != null) {
                reservationData.put("restaurantName", restaurant.getName());
                reservationData.put("restaurantLocation", restaurant.getLocation());
                // If restaurant has ID in your data model, you can add it as well
                // reservationData.put("restaurantId", restaurant.getId()); // Uncomment if applicable
            }

            // Add Reservation to Firestore
            db.collection("reservations")
                    .add(reservationData)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG, "Reservation added with ID: " + documentReference.getId());

                            // Start SuccessfulBookingActivity after successful addition
                            Intent successfulBookingIntent = new Intent(ConfirmationActivity.this, SuccessfulBookingActivity.class);
                            successfulBookingIntent.putExtra("reservationId", documentReference.getId());
                            startActivity(successfulBookingIntent);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error adding reservation", e);
                            Toast.makeText(ConfirmationActivity.this, "Failed to make reservation. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }
}
