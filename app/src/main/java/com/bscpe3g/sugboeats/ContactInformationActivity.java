package com.bscpe3g.sugboeats;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactInformationActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText phoneNumber;
    private EditText emailAddress;
    private EditText customerAddress;
    private Button makeReservationButton;
    private TextView reservationDateTextView, reservationTimeTextView;

    private ImageView backButton;

    private ImageView restaurantImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        phoneNumber = findViewById(R.id.phone);
        emailAddress = findViewById(R.id.email_address);
        customerAddress = findViewById(R.id.customer_address);
        makeReservationButton = findViewById(R.id.button_make_reservation_contact);

        backButton = findViewById(R.id.back_button_contact);

        reservationDateTextView = findViewById(R.id.reservation_date_contact);
        reservationTimeTextView = findViewById(R.id.reservation_time_contact);

        restaurantImageView = findViewById(R.id.restaurant_placeholder);

        Intent intent = getIntent();
        String reservationDate = intent.getStringExtra("reservationDate");
        String reservationTime = intent.getStringExtra("reservationTime");
        String settingType = intent.getStringExtra("settingType");
        String numberOfGuests = intent.getStringExtra("numberOfGuests");
        String specialRequests = intent.getStringExtra("specialRequests");
        Restaurant restaurant = (Restaurant) intent.getSerializableExtra("restaurant");

        if (restaurant != null) {
            restaurantImageView.setImageResource(restaurant.getImageResourceId());
        }

        reservationDateTextView.setText("Reservation Date: " + reservationDate);
        reservationTimeTextView.setText("Reservation Time: " + reservationTime);

        makeReservationButton.setOnClickListener(v -> {
            if (validateInputs()) {
                Intent confirmationIntent = new Intent(ContactInformationActivity.this, ConfirmationActivity.class);
                confirmationIntent.putExtra("reservationDate", reservationDate);
                confirmationIntent.putExtra("reservationTime", reservationTime);
                confirmationIntent.putExtra("settingType", settingType);
                confirmationIntent.putExtra("numberOfGuests", numberOfGuests);
                confirmationIntent.putExtra("specialRequests", specialRequests);
                confirmationIntent.putExtra("firstName", firstName.getText().toString());
                confirmationIntent.putExtra("lastName", lastName.getText().toString());
                confirmationIntent.putExtra("phoneNumber", phoneNumber.getText().toString());
                confirmationIntent.putExtra("emailAddress", emailAddress.getText().toString());
                confirmationIntent.putExtra("customerAddress", customerAddress.getText().toString());
                confirmationIntent.putExtra("restaurant", restaurant);
                startActivity(confirmationIntent);
            }
        });

        backButton.setOnClickListener(v -> {
            Intent backIntent = new Intent(ContactInformationActivity.this, ReservationFormActivity.class);
            backIntent.putExtra("reservationDate", reservationDate);
            backIntent.putExtra("reservationTime", reservationTime);
            backIntent.putExtra("settingType", settingType);
            backIntent.putExtra("numberOfGuests", numberOfGuests);
            backIntent.putExtra("specialRequests", specialRequests);
            startActivity(backIntent);
        });
    }

    private boolean validateInputs() {
        if (firstName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your first name.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (lastName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your last name.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (phoneNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your phone number.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (emailAddress.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please enter your email address.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}