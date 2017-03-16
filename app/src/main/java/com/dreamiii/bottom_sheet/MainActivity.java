package com.dreamiii.bottom_sheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dreamiii.bottomsheet.PhotoSelectFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PhotoSelectFragment.PhotoSelectInterface {

    PhotoSelectFragment mPhotoSelectFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_show:
                mPhotoSelectFragment = PhotoSelectFragment.newInstance().setCallbackInterface(this);
                mPhotoSelectFragment.show(getSupportFragmentManager(),"show");
                break;
        }
    }

    @Override
    public void takePhoto() {
        mPhotoSelectFragment.dismiss();
    }

    @Override
    public void choosePhoto() {
        mPhotoSelectFragment.dismiss();
    }
}
