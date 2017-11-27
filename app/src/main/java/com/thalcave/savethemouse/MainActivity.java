package com.thalcave.savethemouse;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    ImageView mouse1, mouse2, mouse3;
    ImageView mouse4, mouse5, mouse6;
    ImageView mouse7, mouse8, mouse9;
    TextView tvFaults, tvCuredMouses;
    Button startCureButton;
    Random r;

    int curedMouses = 0, fps = 1000, acceptFaults = 5, tempIfNotCuredMouse = 0;
    int which = 0;
    int whichSave = 0;
    AnimationDrawable animation;
    SharedPreferences sharedPreferences;
    public final String SAVED_BEST_RESULT = "Saved best result";
    int savedBestResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = new Random();
        startCureButton = (Button) findViewById(R.id.button);
        tvFaults = (TextView) findViewById(R.id.tvLeft);
        tvCuredMouses = (TextView) findViewById(R.id.tvScore);

        mouse1 = (ImageView) findViewById(R.id.mouse1);
        mouse2 = (ImageView) findViewById(R.id.mouse2);
        mouse3 = (ImageView) findViewById(R.id.mouse3);
        mouse4 = (ImageView) findViewById(R.id.mouse4);
        mouse5 = (ImageView) findViewById(R.id.mouse5);
        mouse6 = (ImageView) findViewById(R.id.mouse6);
        mouse7 = (ImageView) findViewById(R.id.mouse7);
        mouse8 = (ImageView) findViewById(R.id.mouse8);
        mouse9 = (ImageView) findViewById(R.id.mouse9);

        mouse1.setVisibility(View.INVISIBLE);
        mouse2.setVisibility(View.INVISIBLE);
        mouse3.setVisibility(View.INVISIBLE);
        mouse4.setVisibility(View.INVISIBLE);
        mouse5.setVisibility(View.INVISIBLE);
        mouse6.setVisibility(View.INVISIBLE);
        mouse7.setVisibility(View.INVISIBLE);
        mouse8.setVisibility(View.INVISIBLE);
        mouse9.setVisibility(View.INVISIBLE);

        startCureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                acceptFaults = 5;
                tvFaults.setText("Попытки: " + acceptFaults);
                curedMouses = 0;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        theActions();
                    }
                }, 1000);
                startCureButton.setEnabled(false);
            }
        });
        mouse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempIfNotCuredMouse = 1;
                mouse1.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse1.setEnabled(false);
            }
        });
        mouse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempIfNotCuredMouse = 1;
                mouse2.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse2.setEnabled(false);
            }
        });
        mouse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempIfNotCuredMouse = 1;
                mouse3.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse3.setEnabled(false);
            }
        });
        mouse4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempIfNotCuredMouse = 1;
                mouse4.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse4.setEnabled(false);
            }
        });
        mouse5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempIfNotCuredMouse = 1;
                mouse5.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse5.setEnabled(false);
            }
        });
        mouse6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempIfNotCuredMouse = 1;
                mouse6.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse6.setEnabled(false);
            }
        });
        mouse7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempIfNotCuredMouse = 1;
                mouse7.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse7.setEnabled(false);
            }
        });
        mouse8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempIfNotCuredMouse = 1;
                mouse8.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse8.setEnabled(false);
            }
        });
        mouse9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tempIfNotCuredMouse = 1;
                mouse9.setImageResource(R.drawable.cured_mouse);
                curedMouses += 1;
                tvCuredMouses.setText("Вылечено: " + curedMouses);
                mouse9.setEnabled(false);
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.manual)
                .setMessage("Нажимайте на мышат, чтобы лечить их. Успехов;)")
                .setIcon(R.drawable.cured_mouse)
                .setCancelable(false)
                .setNegativeButton("Понятно",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();


        loadBestResult();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_best_result) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(R.string.menu_best_result)
                    .setMessage("Вылеченныx мышат: " + String.valueOf(savedBestResult))
                    .setIcon(R.drawable.cured_mouse)
                    .setCancelable(false)
                    .setNegativeButton("Надо обновить!)",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
            AlertDialog alertWatchResult = builder.create();
            alertWatchResult.show();
        }


        return super.onOptionsItemSelected(item);

    }

    private void theActions() {

        if (curedMouses < 10) {
            fps = 1000;
        } else if (curedMouses >= 10 && curedMouses < 15) {
            fps = 950;
        } else if (curedMouses >= 15 && curedMouses < 20) {
            fps = 900;
        } else if (curedMouses >= 20 && curedMouses < 25) {
            fps = 850;
        } else if (curedMouses >= 25 && curedMouses < 30) {
            fps = 800;
        } else if (curedMouses >= 30 && curedMouses < 35) {
            fps = 750;
        } else if (curedMouses >= 35 && curedMouses < 40) {
            fps = 700;
        } else if (curedMouses >= 40 && curedMouses < 45) {
            fps = 650;
        } else if (curedMouses >= 45 && curedMouses < 50) {
            fps = 600;
        } else if (curedMouses >= 50 && curedMouses < 55) {
            fps = 550;
        } else if (curedMouses >= 55 && curedMouses < 60) {
            fps = 500;
        } else if (curedMouses >= 60 && curedMouses < 65) {
            fps = 450;
        } else if (curedMouses >= 65 && curedMouses < 70) {
            fps = 400;
        } else if (curedMouses >= 70) {
            fps = 350;
        }


        animation = (AnimationDrawable) ContextCompat.getDrawable(this, R.drawable.anim);

        do {
            which = r.nextInt(9) + 1;

        } while (whichSave == which);

        whichSave = which;
        if (which == 1) {
            mouse1.setImageDrawable(animation);
            mouse1.setVisibility(View.VISIBLE);
            mouse1.setEnabled(true);
        } else if (which == 2) {

            mouse2.setImageDrawable(animation);
            mouse2.setVisibility(View.VISIBLE);
            mouse2.setEnabled(true);
        } else if (which == 3) {

            mouse3.setImageDrawable(animation);
            mouse3.setVisibility(View.VISIBLE);
            mouse3.setEnabled(true);
        } else if (which == 4) {

            mouse4.setImageDrawable(animation);
            mouse4.setVisibility(View.VISIBLE);
            mouse4.setEnabled(true);
        } else if (which == 5) {

            mouse5.setImageDrawable(animation);
            mouse5.setVisibility(View.VISIBLE);
            mouse5.setEnabled(true);
        } else if (which == 6) {

            mouse6.setImageDrawable(animation);
            mouse6.setVisibility(View.VISIBLE);
            mouse6.setEnabled(true);
        } else if (which == 7) {

            mouse7.setImageDrawable(animation);
            mouse7.setVisibility(View.VISIBLE);
            mouse7.setEnabled(true);
        } else if (which == 8) {

            mouse8.setImageDrawable(animation);
            mouse8.setVisibility(View.VISIBLE);
            mouse8.setEnabled(true);
        } else if (which == 9) {

            mouse9.setImageDrawable(animation);
            mouse9.setVisibility(View.VISIBLE);
            mouse9.setEnabled(true);
        }
        animation.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mouse1.setVisibility(View.INVISIBLE);
                mouse2.setVisibility(View.INVISIBLE);
                mouse3.setVisibility(View.INVISIBLE);
                mouse4.setVisibility(View.INVISIBLE);
                mouse5.setVisibility(View.INVISIBLE);
                mouse6.setVisibility(View.INVISIBLE);
                mouse7.setVisibility(View.INVISIBLE);
                mouse8.setVisibility(View.INVISIBLE);
                mouse9.setVisibility(View.INVISIBLE);

                mouse1.setEnabled(false);
                mouse2.setEnabled(false);
                mouse3.setEnabled(false);
                mouse4.setEnabled(false);
                mouse5.setEnabled(false);
                mouse6.setEnabled(false);
                mouse7.setEnabled(false);
                mouse8.setEnabled(false);
                mouse9.setEnabled(false);

                if (tempIfNotCuredMouse == 0) {
                    acceptFaults -= 1;
                    tvFaults.setText("Попытки: " + acceptFaults);
                } else if (tempIfNotCuredMouse == 1) {
                    tempIfNotCuredMouse = 0;
                }
                if (acceptFaults == 0) {


                    if (curedMouses > savedBestResult) {
                        AlertDialog.Builder builderSaveResult = new AlertDialog.Builder(MainActivity.this);
                        builderSaveResult.setTitle(R.string.congratulations)
                                .setMessage("Установлен новый рекорд!Вы вылечили " + curedMouses + " мышонка(ат)")
                                .setIcon(R.drawable.cured_mouse)
                                .setCancelable(false)
                                .setNegativeButton("Я очень этому рад)",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        AlertDialog alertSaveResult = builderSaveResult.create();
                        alertSaveResult.show();

                        saveBestResult();
                        loadBestResult();

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle(R.string.game_over)
                                .setMessage("Вы вылечили " + curedMouses + " мышонка(ат)")
                                .setIcon(R.drawable.cured_mouse)
                                .setCancelable(false)
                                .setNeutralButton("Понятно, буду стараться лучше",
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }


                    startCureButton.setEnabled(true);
                } else if (acceptFaults > 0) {
                    theActions();
                }
            }
        }, fps);
    }

    private void saveBestResult() {
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SAVED_BEST_RESULT, curedMouses);
        editor.commit();
    }

    private void loadBestResult() {

        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        savedBestResult = sharedPreferences.getInt(SAVED_BEST_RESULT, 0);
    }
}
