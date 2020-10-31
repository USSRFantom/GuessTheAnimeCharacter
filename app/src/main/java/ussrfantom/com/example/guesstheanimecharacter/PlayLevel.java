package ussrfantom.com.example.guesstheanimecharacter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayLevel extends AppCompatActivity {

    Dialog dialogStart;
    private int positionLevel;
    private Button button0;
    private Button button1;
    private Button button2;
    private ImageView imageViewСharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_level);
        Button buttonBack = findViewById(R.id.button_back);
        button0 = findViewById(R.id.button_answer1);
        button1 = findViewById(R.id.button_answer2);
        button2 = findViewById(R.id.button_answer3);
        imageViewСharacter = findViewById(R.id.image_character);




        //убираем системное меню, едлаем его выдвижным
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //получаем данные о уровне из прошлой активности и пользуемся ими
        Intent intent = getIntent();
        positionLevel = intent.getIntExtra("msg", positionLevel);
        String[] textLevel = getResources().getStringArray(R.array.levels);
        TextView textViewLevels = findViewById(R.id.text_levels);
        textViewLevels.setText(textLevel[positionLevel]);


        //нажатие на кнопку назад
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(PlayLevel.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

        //Диалоговое окно стартовое
        dialogStart = new Dialog(this);
        dialogStart.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogStart.setContentView(R.layout.previewdialog);
        dialogStart.show();

        //кнопка продолжить
        Button buttoncomtinue = dialogStart.findViewById(R.id.buttonContinue);
        buttoncomtinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogStart.dismiss();
            }
        });

    }

    //системная кнопка назад.
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(PlayLevel.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}