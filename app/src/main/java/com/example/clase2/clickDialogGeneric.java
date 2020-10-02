package com.example.clase2;

import android.content.DialogInterface;
import android.util.Log;

public class clickDialogGeneric implements DialogInterface.OnClickListener {
    /**
     * This method will be invoked when a button in the dialog is clicked.
     *
     * @param dialog the dialog that received the click
     * @param which  the button that was clicked (ex.
     *               {@link DialogInterface#BUTTON_POSITIVE}) or the position
     */
    @Override
    public void onClick(DialogInterface dialog, int which) {
        Log.d("DialogBUtton","Se hizo click en "+which);

    }
}
