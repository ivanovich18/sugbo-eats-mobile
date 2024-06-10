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
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class ReservationFormActivity extends AppCompatActivity {

    private EditText reservationDate;
    private EditText reservationTime;
    private Button makeReservationButton;

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, selectedYear, selectedMonth, selectedDay) -> {
            // Update EditText with selected date
            String selectedDate = (selectedMonth + 1) + "/" + selectedDay + "/" + selectedYear;
            reservationDate.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minuteOfHour) -> {
                    // Update EditText with selected time
                    String selectedTime = String.format("%02d:%02d", hourOfDay, minuteOfHour);
                    reservationTime.setText(selectedTime);
                },
                hour, minute, true);
        timePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);

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
        Spinner spinnerSettingType = findViewById(R.id.spinner_setting_type);
        ArrayAdapter<CharSequence> settingTypeAdapter = ArrayAdapter.createFromResource(this,
                R.array.setting_types, android.R.layout.simple_spinner_item);
        settingTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSettingType.setAdapter(settingTypeAdapter);

        // Initialize the spinner for number of guests
        Spinner spinnerNumberOfGuests = findViewById(R.id.spinner_num_guests);
        ArrayAdapter<CharSequence> numberOfGuestsAdapter = ArrayAdapter.createFromResource(this,
                R.array.number_of_guests, android.R.layout.simple_spinner_item);
        numberOfGuestsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumberOfGuests.setAdapter(numberOfGuestsAdapter);

        // Set up the date picker dialog
        reservationDate = findViewById(R.id.reservation_date);
        reservationDate.setOnClickListener(v -> showDatePickerDialog());

        // Set up the time picker dialog
        reservationTime = findViewById(R.id.reservation_time);
        reservationTime.setOnClickListener(v -> showTimePickerDialog());

        // Handle insets to avoid hiding button behind navigation bar
        makeReservationButton = findViewById(R.id.button_make_reservation);
        ViewCompat.setOnApplyWindowInsetsListener(makeReservationButton, (v, insets) -> {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.bottomMargin = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom + params.bottomMargin;
            return insets;
        });

        makeReservationButton.setOnClickListener(v -> {
            Intent intent = new Intent(ReservationFormActivity.this, ContactInformationActivity.class);
            startActivity(intent);
        });
    }

    private void setTextWithRedAsterisk(TextView textView, String text) {
        SpannableString spannableString = new SpannableString(text);
        int start = text.indexOf("*");
        int end = start + 1;
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
    }
}
