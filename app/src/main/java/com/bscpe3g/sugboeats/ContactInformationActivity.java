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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class ContactInformationActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText phoneNumber;
    private EditText emailAddress;
    private EditText customerAddress;
    private Button makeReservationButton;

    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);

        TextView firstNameTextView = findViewById(R.id.first_name_text_view);
        setTextWithRedAsterisk(firstNameTextView, "First Name *");

        TextView lastNameTextView = findViewById(R.id.last_name_text_view);
        setTextWithRedAsterisk(lastNameTextView, "Last Name *");

        TextView phoneTextView = findViewById(R.id.phone_text_view);
        setTextWithRedAsterisk(phoneTextView, "Phone *");

        TextView emailTextView = findViewById(R.id.email_text_view);
        setTextWithRedAsterisk(emailTextView, "Email *");

        // Handle insets to avoid hiding button behind navigation bar
        makeReservationButton = findViewById(R.id.button_make_reservation);
        ViewCompat.setOnApplyWindowInsetsListener(makeReservationButton, (v, insets) -> {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.bottomMargin = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom + params.bottomMargin;
            return insets;
        });

        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ContactInformationActivity.this, ReservationFormActivity.class);
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
