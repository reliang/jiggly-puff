package com.example.femmehack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.*;

public class MainActivity extends AppCompatActivity {
    private Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton = (Button) findViewById(R.id.GO);
        final EditText name = (EditText) findViewById(R.id.textInputLayout2);
        final EditText email = (EditText) findViewById(R.id.textInputLayout3);

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RequestPage.class);

                User curr = Channel.signIn(name.getText().toString(), email.getText().toString());

                if (curr != null) {
                    startActivity(intent);
                }
                intent.putExtra("id", curr.id);
                //intent.putExtra("email", email.getText().toString());
            }
        });
    }

    public void signInButton(View view) {

    }
}
