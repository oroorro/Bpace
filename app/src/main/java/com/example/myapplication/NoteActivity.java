package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.myapplication.databinding.ActivityNoteBinding;

public class NoteActivity extends AppCompatActivity {

    private ActivityNoteBinding binding;

    private EditText textView;

    private Button colorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        textView = findViewById(R.id.plain_text_input);
        colorButton = findViewById(R.id.colorButton);

        textView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        textView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_edittext_background));


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
