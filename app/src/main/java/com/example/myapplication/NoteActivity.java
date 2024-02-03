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

import com.example.myapplication.databinding.NoteMainBinding;

public class NoteActivity extends AppCompatActivity {

    private NoteMainBinding binding;

    private EditText edittextView;

    private Button colorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_main);

        edittextView = findViewById(R.id.plain_text_input);
//        colorButton = findViewById(R.id.colorButton);

        edittextView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        edittextView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_edittext_background));


//        colorButton.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                buttonEditText(view);
//            }
//        });
    }

    /**
     * sets new color to editText value starting from 5 to 10 indices
     * @param view
     */
//    public void buttonEditText(View view){
//        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.YELLOW);
//        edittextView.getText().setSpan(backgroundColorSpan, 5, 11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//    }

}
