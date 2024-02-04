package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.KeyEvent;
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

        binding = NoteMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        edittextView = binding.plainTextInput;
//        colorButton = findViewById(R.id.colorButton);

        edittextView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        edittextView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_edittext_background));


        edittextView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    //do something.

                    binding.buttonIndent.setText("new");
                    return true;
                }
                return false;
            }
        });


//        edittextView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                // Not used in this example.
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                // Check if the change includes a newline character.
//                if (s.toString().indexOf("\n") != -1) {
//                    // change indent button when a newline is detected.
//
//                    binding.buttonIndent.setText("new");
//
//                    onNewLineDetected();
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                // Not used in this example.
//            }
//
//            // Define the specific function to be called when a newline is detected.
//            private void onNewLineDetected() {
//                // Your function's code here.
//                // For example, display a Toast message.
//                Log.i("ENTER","enter pressed");
//            }
//        });


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
