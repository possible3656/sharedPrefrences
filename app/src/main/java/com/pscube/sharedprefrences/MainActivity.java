package com.pscube.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.Telephony.BaseMmsColumns.MESSAGE_ID;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE_ID = "message_pref";
    EditText editText;
    TextView textView;
    Button button_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        button_save=findViewById(R.id.buttonMain);



        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name =     editText.getText().toString().trim();

                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString("key",name);
                editor.apply();

                Toast.makeText(MainActivity.this, "Saved!! rerun this application to show result", Toast.LENGTH_LONG).show();

            }
        });


        SharedPreferences getSharedData = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
      String retrievedData=  getSharedData.getString("key","nothing yet");

        textView.setText(retrievedData);

    }
}
