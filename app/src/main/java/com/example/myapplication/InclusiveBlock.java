package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/**
 * This class represents inclusion enabled view where it can contain other editText by
 * 1.creating two views on the left, bottom of the selected
 * 2.getting top editText's color
 *
 *     -------------------------
 *     |   EditText(parent)    |
 *     ------LinearLayout-------
 *     |left| EditText(target) |
 *     ------------------------
 *     |       bottom         |
 *     -----------------------
 */
public class InclusiveBlock extends LinearLayout {
//    private InclusiveBlock(Context context) {
//        super(context);
//
//    }

    private int backgroundColor;

    private int parentColor;

    private int inclusionCount;


    public InclusiveBlock(int parentColor, View childEditText, Context context){
        super(context);
        init(context, parentColor, childEditText);
        inclusionCount++;
    }

    //make two new View with given parentColor then place left,bottom of childEditText
    private void init(Context context, int parentColor, View childEditText){


        //check if childEditText


        this.setOrientation(LinearLayout.VERTICAL);

        //new LinearLayout named wrappedLeftAndChildEdit for left,childEditText
        LinearLayout indentContainer = new LinearLayout(context);
        indentContainer.setTag("indentContainer"+childEditText.getId());

        //new left View
        View blockOnLeft = new View(context);
        blockOnLeft.setLayoutParams(new LinearLayout.LayoutParams(
                20,
                100
        ));
        blockOnLeft.setBackgroundColor(parentColor);

        //new bottom View
        View blockOnBottom = new View(context);
        blockOnBottom.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                20
        ));
        blockOnBottom.setBackgroundColor(parentColor);

        indentContainer.addView(blockOnLeft);
        indentContainer.addView(childEditText);

        //add wrappedLeftAndChildEdit to this
        this.addView(indentContainer);

        //add bottom View to this
        this.addView(blockOnBottom);

    }

    public int getInclusionCount() {
        return inclusionCount;
    }
}
