package c.nikola.chatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContactsActivity extends AppCompatActivity {

    public void logout(View view){
        Intent exit = new Intent(this, MainActivity.class);
        startActivity(exit);
    }

    public void message(View view){
        Intent new_message = new Intent(this, MessageActivity.class);
        startActivity(new_message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }
}
