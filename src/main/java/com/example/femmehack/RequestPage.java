package com.example.femmehack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import android.content.*;

public class RequestPage extends AppCompatActivity {
    User curr;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        submitButton = (Button) findViewById(R.id.submit);
        final EditText description = (EditText) findViewById(R.id.textInputLayout);
        final EditText hours = (EditText) findViewById(R.id.textInputLayout4);



        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        curr = Channel.getUser(id);

        final TextView credit = (TextView) findViewById(R.id.credit);

        credit.setText(curr.credit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr.addRequest(description.getText().toString(), Integer.parseInt(hours.getText().toString()));
            }
        });

    }
}
