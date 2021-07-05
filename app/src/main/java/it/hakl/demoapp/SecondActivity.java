package it.hakl.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    public static final String TAG = SecondActivity.class.getSimpleName();
    private View txtMessage;

    //TODO: na klik gumba btnSave tekst, ki je vpisan v edittextu txtMessage, pošlji v nazaj v mainactivity in ga tam prikaži v edittextu txtMessage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
        setContentView(R.layout.activity_second);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.TAG);

        // Capture the layout's TextView and set the string as its text
        EditText textView = findViewById(R.id.txtMessage);
        textView.setText(message);

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });
        txtMessage = findViewById(R.id.txtMessage);
    }

    private void openMainActivity() {
        // odprem maindactivity
        Intent intent = new Intent(this, MainActivity.class);
        EditText txtMessage = (EditText) findViewById(R.id.txtMessage);
        String message = txtMessage.getText().toString();
        intent.putExtra(TAG, message);
        startActivity(intent);
    }

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