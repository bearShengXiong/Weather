package com.example.shengxiong.weather;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by Shengxiong on 2016/6/20.
 */
public class AlerDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context).
        setTitle(R.string.error_title).setMessage(R.string.error_message).setPositiveButton(R.string.error_ok_button_text,null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
