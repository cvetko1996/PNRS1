package c.nikola.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.content.Intent;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity implements TextWatcher{

    EditText message;
    Button send;

    public void logout(View view){

        Intent logOut = new Intent(this, MainActivity.class);
        startActivity(logOut);
    }

    public void send(View view){

        Toast.makeText(getApplicationContext(), "Message sent!", Toast.LENGTH_LONG).show();
        message.setText("");
        send.setEnabled(false);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (message.getText().length() != 0) {
            send.setEnabled(true);
        } else {
            send.setEnabled(false);
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
        setContentView(R.layout.activity_message);

        send = findViewById(R.id.send);
        message = findViewById(R.id.message);

        send.setEnabled(false);
        message.addTextChangedListener(this);
    }
}
