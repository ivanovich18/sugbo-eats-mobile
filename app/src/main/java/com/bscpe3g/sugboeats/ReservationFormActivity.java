// ReservationFormActivity.java

package com.bscpe3g.sugboeats;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class ReservationFormActivity extends AppCompatActivity {
    private static final String KEY_RESERVATION_DATE = "reservationDate";
    private static final String KEY_RESERVATION_TIME = "reservationTime";
    private static final String KEY_SETTING_TYPE_POSITION = "settingTypePosition";
    private static final String KEY_NUM_GUESTS_POSITION = "numGuestsPosition";

    private EditText reservationDate;
    private EditText reservationTime;
    private Spinner spinnerSettingType;
    private Spinner spinnerNumberOfGuests;
    private EditText specialRequests;
    private Button makeReservationButton;

    private ImageView restaurantImageView;
    private TextView restaurantNameTextView;
    private TextView restaurantLocationTextView;

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    String selectedDate = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year1;
                    reservationDate.setText(selectedDate);
                },
                year, month, day);

        // Disable past dates
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar cldr = Calendar.getInstance();
        int hour = cldr.get(Calendar.HOUR_OF_DAY);
        int minutes = cldr.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute) -> {
                    String amPm = (hourOfDay < 12) ? "AM" : "PM";
                    int hour12 = (hourOfDay == 0 || hourOfDay == 12) ? 12 : hourOfDay % 12;
                    String selectedTime = String.format("%02d:%02d %s", hour12, minute, amPm);
                    reservationTime.setText(selectedTime);
                }, hour, minutes, false);

        // Disable past times on the same day
        if (cldr.get(Calendar.HOUR_OF_DAY) == 0 && cldr.get(Calendar.MINUTE) == 0) {
            timePickerDialog.updateTime(hour, minutes);
        }

        timePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);

        // Initialize restaurant info views
        restaurantImageView = findViewById(R.id.restaurant_placeholder);
        restaurantNameTextView = findViewById(R.id.restaurant_name_placeholder);
        restaurantLocationTextView = findViewById(R.id.reservation_location_placeholder);

        // Get the restaurant data from the intent
        Intent intent = getIntent();
        Restaurant restaurant = (Restaurant) intent.getSerializableExtra("restaurant");

        ImageView backButton = findViewById(R.id.back_button_table); // Ensure correct ID
        backButton.setOnClickListener(v -> {
            // Pass the restaurant object back to the previous activity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("restaurant", restaurant);
            setResult(RESULT_OK, resultIntent);
            finish(); // Go back to the previous activity
        });


        if (restaurant != null) {
            restaurantImageView.setImageResource(restaurant.getImageResourceId());
            restaurantNameTextView.setText(restaurant.getName());
            restaurantLocationTextView.setText(restaurant.getLocation());
        }

        // Set the date text view with red asterisk
        TextView dateTextView = findViewById(R.id.date_text_view);
        setTextWithRedAsterisk(dateTextView, "Date *");

        // Set the time text view with red asterisk
        TextView timeTextView = findViewById(R.id.time_text_view);
        setTextWithRedAsterisk(timeTextView, "Time *");

        TextView settingType = findViewById(R.id.setting_type_text_view);
        setTextWithRedAsterisk(settingType, "Setting Type *");

        TextView numberOfGuests = findViewById(R.id.guests_text_view);
        setTextWithRedAsterisk(numberOfGuests, "Number of Guests *");

        // Initialize the spinner for setting type
        spinnerSettingType = findViewById(R.id.spinner_setting_type);

        // Initialize the spinner for number of guests
        spinnerNumberOfGuests = findViewById(R.id.spinner_num_guests);

        // Set up the date picker dialog
        reservationDate = findViewById(R.id.reservation_date);
        reservationDate.setOnClickListener(v -> showDatePickerDialog());

        // Set up the time picker dialog
        reservationTime = findViewById(R.id.reservation_time);
        reservationTime.setOnClickListener(v -> showTimePickerDialog());

        specialRequests = findViewById(R.id.special_requests);

        // Handle insets to avoid hiding button behind navigation bar
        makeReservationButton = findViewById(R.id.button_make_reservation_contact);
        ViewCompat.setOnApplyWindowInsetsListener(makeReservationButton, (v, insets) -> {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.bottomMargin = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom + params.bottomMargin;
            return insets;
        });

        if (savedInstanceState != null) {
            reservationDate.setText(savedInstanceState.getString(KEY_RESERVATION_DATE));
            reservationTime.setText(savedInstanceState.getString(KEY_RESERVATION_TIME));
            spinnerSettingType.setSelection(savedInstanceState.getInt(KEY_SETTING_TYPE_POSITION));
            spinnerNumberOfGuests.setSelection(savedInstanceState.getInt(KEY_NUM_GUESTS_POSITION));
        }

        // Set up adapters for spinners
        ArrayAdapter<CharSequence> settingTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.setting_types, android.R.layout.simple_spinner_item);
        settingTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSettingType.setAdapter(settingTypeAdapter);

        ArrayAdapter<CharSequence> numberOfGuestsAdapter = ArrayAdapter.createFromResource(this,
                R.array.number_of_guests, android.R.layout.simple_spinner_item);
        numberOfGuestsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumberOfGuests.setAdapter(numberOfGuestsAdapter);

        makeReservationButton.setOnClickListener(v -> {
            if (validateInputs()) {
                Intent intentContact = new Intent(ReservationFormActivity.this, ContactInformationActivity.class);
                intentContact.putExtra("reservationDate", reservationDate.getText().toString());
                intentContact.putExtra("reservationTime", reservationTime.getText().toString());
                intentContact.putExtra("settingType", spinnerSettingType.getSelectedItem().toString());
                intentContact.putExtra("numberOfGuests", spinnerNumberOfGuests.getSelectedItem().toString());
                intentContact.putExtra("specialRequests", specialRequests.getText().toString());

                // Get the restaurant data and add it to the intent
                intentContact.putExtra("restaurant", restaurant);

                startActivity(intentContact);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of EditText and Spinner views
        outState.putString(KEY_RESERVATION_DATE, reservationDate.getText().toString());
        outState.putString(KEY_RESERVATION_TIME, reservationTime.getText().toString());
        outState.putInt(KEY_SETTING_TYPE_POSITION, spinnerSettingType.getSelectedItemPosition());
        outState.putInt(KEY_NUM_GUESTS_POSITION, spinnerNumberOfGuests.getSelectedItemPosition());
    }

    private void setTextWithRedAsterisk(TextView textView, String text) {
        SpannableString spannableString = new SpannableString(text);
        int start = text.indexOf("*");
        int end = start + 1;
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }

    private boolean validateInputs() {
        if (reservationDate.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please select a date.", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (reservationTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please select a time.", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
