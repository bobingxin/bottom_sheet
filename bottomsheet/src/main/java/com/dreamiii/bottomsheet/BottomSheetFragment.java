package com.dreamiii.bottomsheet;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


public abstract class BottomSheetFragment extends DialogFragment {

    public BottomSheetFragment() {
        // Required empty public constructor
    }

//    public static BottomSheetFragment newInstance() {
//        BottomSheetFragment fragment = new BottomSheetFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getContext(),R.style.ActionSheetDialogStyle);
        View root = getCustomView();
        setListener(root);
        dialog.setContentView(root);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.y = 20;
        dialogWindow.setAttributes(lp);
        return dialog;
    }

    public View setCustomView(int id){
        return LayoutInflater.from(getContext()).inflate(id,null);
    }

    protected abstract View getCustomView();

    protected abstract void setListener(View view);

}
