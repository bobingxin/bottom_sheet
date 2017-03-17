package com.dreamiii.bottomsheet;


import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


public class PhotoSelectFragment extends BottomSheetFragment implements View.OnClickListener {

    private PhotoSelectInterface mPhotoSelectInterface;

    public PhotoSelectFragment() {
        // Required empty public constructor
    }

    @Override
    protected View getCustomView() {
        return setCustomView(R.layout.bottom_sheet);
    }

    @Override
    protected void setListener(View view) {
        view.findViewById(R.id.takePhoto).setOnClickListener(this);
        view.findViewById(R.id.choosePhoto).setOnClickListener(this);
    }

    public PhotoSelectFragment setCallbackInterface(PhotoSelectInterface callbackInterface) {
        mPhotoSelectInterface = callbackInterface;
        return this;
    }

    @Override
    protected void dialogPosition(Window dialogWindow) {
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = dialogWindow.getWindowManager().getDefaultDisplay().getWidth();
        lp.y = 0;
        dialogWindow.setAttributes(lp);
    }

    public static PhotoSelectFragment newInstance() {
        PhotoSelectFragment fragment = new PhotoSelectFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.takePhoto) {
            if(mPhotoSelectInterface != null)
                mPhotoSelectInterface.takePhoto();
        } else if (i == R.id.choosePhoto) {
            if(mPhotoSelectInterface != null)
                mPhotoSelectInterface.choosePhoto();
        }
    }

    public interface PhotoSelectInterface{
        void takePhoto();
        void choosePhoto();
    }
}
