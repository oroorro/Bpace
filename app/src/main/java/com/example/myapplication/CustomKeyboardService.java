package com.example.myapplication;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.view.View;

public class CustomKeyboardService extends InputMethodService {

    @Override
    public View onCreateInputView() {
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        // Configure your keyboard view and set listeners for key press events
        return keyboardView;
    }
}
