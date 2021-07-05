package it.hakl.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
//    private final String TAG = this.getClass().getSimpleName();

    // UI elements
    public static EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(SecondActivity.TAG);

        // Capture the layout's TextView and set the string as its text
        EditText textView = findViewById(R.id.txtMessage);
        textView.setText(message);

        Button btnOpen = findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondActivity();
            }
        });

        txtMessage = findViewById(R.id.txtMessage);
    }

    private void openSecondActivity() {
        // odprem secondactivity
        Intent intent = new Intent(this, SecondActivity.class);
        EditText txtMessage = (EditText) findViewById(R.id.txtMessage);
        String message = txtMessage.getText().toString();
        intent.putExtra(TAG, message);
        startActivity(intent);

        //TODO: na klik gumba btnOpen tekst, ki je vpisan v edittextu txtMessage, pošlji v secondactivity in ga tam prikaži v edittextu txtMessage
        // pomagaj si s https://developer.android.com/training/basics/firstapp/starting-activity
    }

    // TODO: poglej si activity lifecycle. https://developer.android.com/guide/components/activities/activity-lifecycle
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ");
    }
}