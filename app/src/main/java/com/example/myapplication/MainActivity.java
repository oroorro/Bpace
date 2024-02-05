package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.UitestSectionBinding;

public class MainActivity extends AppCompatActivity {
    //what is this exactly ? is it refering itself?
    private ActivityMainBinding binding;
    private UitestSectionBinding bindingToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Testing UI
//        bindingToolBar = UitestSectionBinding.inflate(getLayoutInflater());
//        setContentView(bindingToolBar.getRoot());

        binding.openButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);
                //make();
            }

        }
        );


    }

    public void make(){
        EditText newEditText = new EditText(this);
        // Optionally, set some properties on the EditText
        newEditText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                100
        ));
        newEditText.setHint("hello");
        newEditText.setPadding(0,0,0,40);
        newEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        newEditText.setId(View.generateViewId());
        //newEditText.setMaxLines(1);
        newEditText.setBackgroundColor(Color.parseColor("#FFC0CB"));
        //make a new editText


        ConstraintLayout layout = findViewById(R.id.root);
        layout.addView(newEditText);
        //binding.linearMain.addView(newEditText);
        //binding.linearContent.addView(newEditText);
    }
}