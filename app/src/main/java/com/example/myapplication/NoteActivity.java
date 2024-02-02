package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.NoteMainBinding;

public class NoteActivity extends AppCompatActivity {

    private NoteMainBinding binding;

    private EditText textView;

    private Button colorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_main);

        textView = findViewById(R.id.plain_text_input);
        colorButton = findViewById(R.id.colorButton);

        colorButton.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonEditText(view);
            }
        });
    }

    public void buttonEditText(View view){
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
        textView.getText().setSpan(backgroundColorSpan, 5, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

}
