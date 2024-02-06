package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.databinding.NoteMainBinding;

public class NoteActivity extends AppCompatActivity {

    private NoteMainBinding binding;

    private EditText edittextView;

    //saves reference to currently focused editText
    private EditText currentEdittext;


    private String[] colorList = {
            "#FF0000", //Red
            "#00FF00", //Green
            "#0000FF", //Blue
            "#FFFF00", //Yellow
            "#FF00FF", //Magenta
            "#00FFFF", //Cyan
            "#FFA500", //Orange
            "#FFFFFF", //White
    };

    //used to rotate colors for colorList
    private int colorIndex = 0;

    //identifier for editText, gets incremented on creation
    private int editTextCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = NoteMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        edittextView = binding.plainTextInput;
        edittextView.setMaxWidth(10);


        /**
         * new line triggered key listner to edittextView
         */
        edittextView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    binding.buttonIndent.setText("Indent+");
                    makeNewEditText(edittextView.getId(), edittextView);
                    return true;
                }
                return false;
            }
        });

        //indent button will cause the currently focused editText to become a part of the editText above it
        binding.buttonIndent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                //get currentEdittext's above editText's color
                int index = binding.linearContent.indexOfChild(currentEdittext);
                String hexColor;

                int siblingEditTextColor = 0;

                if(index != 0){
                    //getting reference of currentEdittext's above editText and naming as siblingEditText
                    EditText siblingEditText = (EditText) binding.linearContent.getChildAt(index - 1);
                    //getting siblingEditText's background color
                    Drawable siblingEditTextBackgrnd = siblingEditText.getBackground();

                    ColorDrawable colorDrawable = (ColorDrawable) siblingEditTextBackgrnd;
                    siblingEditTextColor = colorDrawable.getColor();


                    // Print the color value to check, prints the correct color
                    //hexColor = String.format("#%06X", (0xFFFFFF & siblingEditTextColor));
                    //Log.d("BackgroundColor", "Background color: " + hexColor + " index: " + index);
                }

                //make a new LinearLayout with horizontal orientation
                LinearLayout indentContainer = new LinearLayout(NoteActivity.this);

                //creating custom block
                BlockShapeView blockOnLeft = new BlockShapeView(NoteActivity.this);
                //setting style for blockOnLeft
                //height,width and color
                blockOnLeft.setLayoutParams(new LinearLayout.LayoutParams(
                        20,
                        100
                ));

                hexColor = String.format("#%06X", (0xFFFFFF & siblingEditTextColor));
                //Log.d("BackgroundColor", "Background color: " + hexColor + "|" + siblingEditTextColor);

                blockOnLeft.setBackgroundColor(Color.parseColor(hexColor));

                binding.linearContent.removeView(currentEdittext);

                //place a new IndentBlockView left to currentEdittext
                indentContainer.addView(blockOnLeft);
                //insert currentEdittext into newly created LinearLayout
                indentContainer.addView(currentEdittext);

                //insert newly created LinearLayout at currentEdittext index


                //creating custom block that will be placed bottom of indentContainer
                BlockShapeView blockOnBottom = new BlockShapeView(NoteActivity.this);

                blockOnBottom.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        20
                ));

                blockOnBottom.setBackgroundColor(Color.parseColor(hexColor));

                //insert customshapeview
                binding.linearContent.addView(indentContainer, index);
                //then insert blockOnBottom right below indentContainer
                binding.linearContent.addView(blockOnBottom, index + 1);

            }

        });




    }

    /**
     * creates new editText view, this method gets triggered
     * when user gives new line character inside of editText that they
     * were writing.
     * @param editTextId editText's id
     * @param triggeredEditText editText which has received a new line character
     */
    public void makeNewEditText(int editTextId, EditText triggeredEditText){
        EditText newEditText = new EditText(this);

        //properties for editText
        newEditText.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                100
        ));
        newEditText.setHint("hello");
        newEditText.setPadding(0,0,0,40);
        newEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        //setting maxWidth for new editText same as parent;linearContentLayout
        int parentWidth = binding.linearContent.getWidth();
        Log.i("parentWidth",""+parentWidth);
        newEditText.setMaxWidth(parentWidth);

        //created editTextId for newEditText

        //int newEditTextId = View.generateViewId();
        newEditText.setId(View.generateViewId());
        newEditText.setMaxLines(1);
        newEditText.setBackgroundColor(Color.parseColor(colorList[colorIndex % 8]));
        colorIndex++;

        //adds eventListner on newEditText to create further editTexts
        newEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    binding.buttonIndent.setText("new");
                    makeNewEditText(editTextCount, newEditText);
                    return true;
                }
                return false;
            }
        });

        //adds focusListener to newly created editText
        //this focusListener will make focused editText to be currentEdittext
        newEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                //when focused make that editText to be currentEdittext
                if (hasFocus) {
                    currentEdittext = newEditText;
                }
            }
        });


        //editTextCount++;

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearContent);
        //getting index of triggeredEditText
        int index = layout.indexOfChild(triggeredEditText);
        //placing newly created editText right next to triggeredEditText
        layout.addView(newEditText,index + 1);
    }

}
