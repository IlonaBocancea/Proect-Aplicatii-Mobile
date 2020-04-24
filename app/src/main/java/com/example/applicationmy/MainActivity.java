package com.example.applicationmy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)  findViewById(R.id.editText)
    }

    @Override
    protected void onResume() {
        super.onResume();
         SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
            float fsize  = Float.parseFloat(sharedPreferences.getString("Marimea", 20)) ;
         editText.setTextSize(fsize);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         switch (item.getItemId())  {
            case R.id.action_clear;
             editText.setText("");
                Toast.makeText(getApplicationContext(), "Sters!",Toast.LENGTH_SHORT) .show();
                 return true;
                 case R.id.action_settings;
                     Intent i = new Intent(MainActivity.this, SetttingActivity.class)
                    startActivity(i);
         }
        return super.onOptionsItemSelected(item);
    }
}
