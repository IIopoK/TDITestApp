package com.example.kirill.tditestapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends Activity {

    final String SAVED_IMAGE = "saved_image";

    ImageView ivTest;
    Button btn1, btn2, btn3;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivTest = (ImageView) findViewById(R.id.ivTest);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        loadImage();
    }

    public void changeImage(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                setFirstImage();
                break;
            case R.id.btn2:
                setSecondImage();
                break;
            case R.id.btn3:
                setThirdImage();
                break;
            default:
                break;
        }
    }

    private void saveImage() {
        sPref = getPreferences(MODE_PRIVATE);
        Editor editor = sPref.edit();
        editor.putInt(SAVED_IMAGE, (Integer) ivTest.getTag());
        editor.commit();
    }

    private void loadImage() {
        sPref = getPreferences(MODE_PRIVATE);
        int i = sPref.getInt(SAVED_IMAGE, 0);
        switch (i) {
            case 0:
                setFirstImage();
                break;
            case 1:
                setFirstImage();
                break;
            case 2:
                setSecondImage();
                break;
            case 3:
                setThirdImage();
                break;
            default:
                break;
        }
    }

    private void setFirstImage() {
        ivTest.setImageResource(R.drawable.first);
        ivTest.setTag(1);
    }

    private void setSecondImage() {
        ivTest.setImageResource(R.drawable.second);
        ivTest.setTag(2);
    }

    private void setThirdImage() {
        ivTest.setImageResource(R.drawable.third);
        ivTest.setTag(3);
    }

    @Override
    protected void onDestroy() {
        saveImage();
        super.onDestroy();
    }
}
