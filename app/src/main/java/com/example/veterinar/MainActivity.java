package com.example.veterinar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private SeekBar seekBar;
    private TextView textViewLat;
    private ListView listView;
    private String[] animals = {"Pies","Kot","Swinka morska"};
    private TextView finalStuffs;
    private Button button;
    private int age = 0;
    private EditText cel;
    private EditText time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextName = findViewById(R.id.editTextText);
        seekBar = findViewById(R.id.seekBar);
        textViewLat = findViewById(R.id.textViewLat);
        listView = findViewById(R.id.list);
        finalStuffs = findViewById(R.id.textView5);
        button = findViewById(R.id.button);
        cel = findViewById(R.id.editTextText2);
        time = findViewById(R.id.editTextTime);

        ArrayAdapter<String> arrayAdapter;

        arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,animals);

        listView.setAdapter(arrayAdapter);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String yearShow = "Ile ma lat? " + progress;
                age = progress;
                textViewLat.setText(yearShow);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Called when the user starts touching the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Called when the user stops touching the SeekBar
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String completeInfo = editTextName.getText() + ", " + "Pies (TEMP)" + ", "+ age + ", " + cel.getText() + ", " + time.getText();
                finalStuffs.setText(completeInfo);
            }
        });
    }
}