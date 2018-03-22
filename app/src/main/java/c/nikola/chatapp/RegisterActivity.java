package c.nikola.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Button;
import android.text.Editable;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import android.widget.CheckBox;
import android.widget.ArrayAdapter;

public class RegisterActivity extends AppCompatActivity implements TextWatcher {

    Button register;
    EditText username;
    EditText password;
    EditText name;
    EditText surname;
    EditText email;
    DatePicker birth;
    CheckBox notify;
    int minChars = 6;

    public void enter (View view){
        Intent next = new Intent(this, ContactsActivity.class);
        startActivity(next);

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (username.getText().length() >= minChars && password.getText().length() >= minChars
                && email.getText().length()>= minChars) {
            register.setEnabled(true);
        } else {
            register.setEnabled(false);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int before, int count) {

    }
    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Male");
        categories.add("Female");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        Date date = Calendar.getInstance().getTime();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        birth = findViewById(R.id.datePicker);
        notify = findViewById(R.id.checkBox);
        register = findViewById(R.id.register);

        username.addTextChangedListener(this);
        password.addTextChangedListener(this);
        name.addTextChangedListener(this);
        surname.addTextChangedListener(this);
        email.addTextChangedListener(this);

        register.setEnabled(false);
        birth.setMaxDate(date.getTime());

    }
}
