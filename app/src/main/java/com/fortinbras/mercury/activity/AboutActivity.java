package com.fortinbras.mercury.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fortinbras.mercury.R;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{

    //TODO: ADD YOUTUBE CHANNEL
    Button btn_osl, btn_tnx, btn_clog,btn_reddit, btn_ig, btn_telegram, btn_github, btn_twitter,btn_facebook;
    Html htmlOsl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle(R.string.app_name);
        //btn
        btn_facebook = findViewById(R.id.btn_facebook);
        btn_reddit = findViewById(R.id.btn_reddit);
        btn_ig = findViewById(R.id.btn_instagram);
        btn_telegram = findViewById(R.id.btn_telegram);
        btn_github = findViewById(R.id.btn_github);
        btn_twitter = findViewById(R.id.btn_twitter);
        btn_osl = findViewById(R.id.btn_osl);
        btn_tnx = findViewById(R.id.btn_tnx);
        btn_clog = findViewById(R.id.btn_changelog);
        //onclicklistener
        btn_reddit.setOnClickListener(this);
        btn_ig.setOnClickListener(this);
        btn_telegram.setOnClickListener(this);
        btn_github.setOnClickListener(this);
        btn_twitter.setOnClickListener(this);
        btn_osl.setOnClickListener(this);
        btn_tnx.setOnClickListener(this);
        btn_clog.setOnClickListener(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: SET E MAIL ACTION
                Snackbar.make(view, "TODO: SET E MAIL ACTION", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_facebook:
                String fb = "https://www.facebook.com/profile.php?id=100015364983025";
                Intent f = new Intent(Intent.ACTION_VIEW);
                f.setData(Uri.parse(fb));
                startActivity(f);
            case R.id.btn_instagram:
                String ig = "https://www.instagram.com/fortinbrasgood/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ig));
                startActivity(i);
                break;
            case R.id.btn_reddit:
                String rd = "https://www.reddit.com/user/fortinbrasgod/";
                Intent r = new Intent(Intent.ACTION_VIEW);
                r.setData(Uri.parse(rd));
                startActivity(r);
                break;
            case R.id.btn_telegram:
                String tg = "https://t.me/fortinbrasgod/";
                Intent t = new Intent(Intent.ACTION_VIEW);
                t.setData(Uri.parse(tg));
                startActivity(t);
                break;
            case R.id.btn_twitter:
                String tw = "https://twitter.com/fortinbrasgood/";
                Intent w = new Intent(Intent.ACTION_VIEW);
                w.setData(Uri.parse(tw));
                startActivity(w);
                break;
            case R.id.btn_github:
                String gt = "https://github.com/ygzsimsek/";
                Intent g = new Intent(Intent.ACTION_VIEW);
                g.setData(Uri.parse(gt));
                startActivity(g);
                break;
            case R.id.btn_changelog:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("Changelog");
                alertDialogBuilder
                        .setMessage("0.1.3 Alpha Public Preview")
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_mode_edit_black)
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                Toast.makeText(this, "clog", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_osl:
                AlertDialog.Builder alertDialogOSL = new AlertDialog.Builder(this);
                alertDialogOSL.setTitle("OPEN SOURCE LICANSES");
                alertDialogOSL
                        .setMessage("https://github.com/andryr/guitar-tuner")
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_information_outline)
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialogosl = alertDialogOSL.create();
                alertDialogosl.show();
                Toast.makeText(this, "osl", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_tnx:
                AlertDialog.Builder alertDialogBuilderTNX = new AlertDialog.Builder(this);
                alertDialogBuilderTNX.setTitle("Thanks to");
                alertDialogBuilderTNX
                        .setMessage("Special thanks to myself")
                        .setCancelable(true)
                        .setIcon(R.drawable.ic_heart)
                        .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialogtnx = alertDialogBuilderTNX.create();
                alertDialogtnx.show();
                Toast.makeText(this, "thanks", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}