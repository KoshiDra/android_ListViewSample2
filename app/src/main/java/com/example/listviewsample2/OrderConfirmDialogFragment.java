package com.example.listviewsample2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
//import androidx.appcompat.app.AlertDialog;

public class OrderConfirmDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        // ダイアログビルダー生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // ダイアログのタイトル設定
        builder.setTitle(R.string.dialog_title);

        // ダイアログのメッセージ設定
        builder.setMessage(R.string.dialog_msg);

        // Positive Button設定
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());

        // Negative Button設定
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());

        // Neutral Button設定
        builder.setNeutralButton(R.string.dialog_btn_nu, new DialogButtonClickListener());

        // ダイアログオブジェクト生成
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {

            // トーストメッセージ用文字列
            String msg = "";

            // タップされたボタンで分岐
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    msg = getString(R.string.dialog_ok_toast);
                    break;
                case  DialogInterface.BUTTON_NEGATIVE:
                    msg = getString(R.string.dialog_ng_toast);
                    break;
                case  DialogInterface.BUTTON_NEUTRAL:
                    msg = getString(R.string.dialog_nu_toast);
                    break;
            }

            // トースト表示
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
