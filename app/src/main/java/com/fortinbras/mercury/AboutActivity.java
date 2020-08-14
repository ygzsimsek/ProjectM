package com.fortinbras.mercury;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btn_reddit, btn_ig, btn_telegram, btn_github, btn_twitter;
    Button btn_osl, btn_tnx, btn_clog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        //btn
        btn_reddit = (ImageButton) findViewById(R.id.btn_reddit);
        btn_ig = (ImageButton) findViewById(R.id.btn_instagram);
        btn_telegram = (ImageButton) findViewById(R.id.btn_telegram);
        btn_github = (ImageButton) findViewById(R.id.btn_github);
        btn_twitter = (ImageButton) findViewById(R.id.btn_twitter);
        btn_osl = (Button) findViewById(R.id.btn_osl);
        btn_tnx = (Button) findViewById(R.id.btn_tnx);
        btn_clog = (Button) findViewById(R.id.btn_changelog);
        //onclicklistener
        btn_reddit.setOnClickListener(this);
        btn_ig.setOnClickListener(this);
        btn_telegram.setOnClickListener(this);
        btn_github.setOnClickListener(this);
        btn_twitter.setOnClickListener(this);
        btn_osl.setOnClickListener(this);
        btn_tnx.setOnClickListener(this);
        btn_clog.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_instagram:
                String ig = "https://www.instagram.com/fortinbrasgood/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(ig));
                startActivity(i);
                Toast.makeText(this, "ig", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_reddit:
                String rd = "https://www.reddit.com/user/fortinbrasgod/";
                Intent r = new Intent(Intent.ACTION_VIEW);
                r.setData(Uri.parse(rd));
                startActivity(r);
                Toast.makeText(this, "reddit", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_telegram:
                String tg = "https://t.me/fortinbrasgod/";
                Intent t = new Intent(Intent.ACTION_VIEW);
                t.setData(Uri.parse(tg));
                startActivity(t);
                Toast.makeText(this, "telegram", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_twitter:
                String tw = "https://t.me/fortinbrasgod/";
                Intent w = new Intent(Intent.ACTION_VIEW);
                w.setData(Uri.parse(tw));
                startActivity(w);
                Toast.makeText(this, "tw", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_github:
                String gt = "https://github.com/ygzsimsek/";
                Intent g = new Intent(Intent.ACTION_VIEW);
                g.setData(Uri.parse(gt));
                startActivity(g);
                Toast.makeText(this, "github", Toast.LENGTH_SHORT).show();
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
                        .setMessage("OPEN SOURCE LICANSES")
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