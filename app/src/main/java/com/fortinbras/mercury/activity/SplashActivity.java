package com.fortinbras.mercury.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.fortinbras.mercury.R;
import com.fortinbras.mercury.util.DialogUtils;
import com.fortinbras.mercury.util.PrefManager;
import com.fortinbras.mercury.util.Utils;

public class SplashActivity extends AppCompatActivity {
    public int handler_time = 3000;
    private static final int PERMISSION_REQUEST_RECORD_AUDIO = 443;
    private PrefManager prefManager;
    LinearLayout layPer;
    Button btnMic;
    Animation fadein;

    //TODO: INTRO SLIDER

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_RECORD_AUDIO: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    layPer.setVisibility(View.GONE);
                    launchHome();
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                }
                else{
                    layPer.setVisibility(View.VISIBLE);
                    layPer.startAnimation(fadein);
                    Toast.makeText(this, "You need to accept", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        btnMic = findViewById(R.id.btn_allow_mic);
        layPer = findViewById(R.id.lay_permissions);
        ImageView img = findViewById(R.id.img_splash);
        TextView txt = findViewById(R.id.txt_appname);
        btnMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });
        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            //check permission
            checkPermission();
            requestPermission();
        } else{
            launchIntro();
        }
        //transparent
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        //animation
        img.startAnimation(fadein);
        txt.startAnimation(fadein);
    }

    private void checkPermission() {
        //permission
        String requiredPermission = Manifest.permission.RECORD_AUDIO;
        int checkVal = getApplicationContext().checkCallingOrSelfPermission(requiredPermission);
        if (checkVal==PackageManager.PERMISSION_GRANTED){
            layPer.setVisibility(View.GONE);
            launchHome();
        }
    }

    private void requestPermission() {
        if (!Utils.checkPermission(this, Manifest.permission.RECORD_AUDIO)) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECORD_AUDIO)) {

                DialogUtils.showPermissionDialog(this, getString(R.string.permission_record_audio), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(SplashActivity.this,
                                new String[]{Manifest.permission.RECORD_AUDIO},
                                PERMISSION_REQUEST_RECORD_AUDIO);
                    }
                });

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECORD_AUDIO},
                        PERMISSION_REQUEST_RECORD_AUDIO);
                Toast.makeText(this, "negative", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void launchHome() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, NavActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, handler_time);
    }

    private void launchIntro() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent introIntent = new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(introIntent);
                finish();
            }
        }, handler_time);    }

}
