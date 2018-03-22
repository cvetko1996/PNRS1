package c.nikola.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Button;
import android.text.Editable;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    EditText userName;
    EditText userPassword;
    Button login;
    int minChars = 6;


    public void register(View view){
        Intent registerIntent = new Intent(this, RegisterActivity.class);
        startActivity(registerIntent);
    }

    public void login(View view){
        Intent loginIntent = new Intent(this, ContactsActivity.class);
        startActivity(loginIntent);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (userName.getText().length() >= minChars && userPassword.getText().length() >= minChars) {
            login.setEnabled(true);
        } else {
            login.setEnabled(false);
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
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        userName.addTextChangedListener(this);
        userPassword.addTextChangedListener(this);

        login.setEnabled(false);


    }


}
