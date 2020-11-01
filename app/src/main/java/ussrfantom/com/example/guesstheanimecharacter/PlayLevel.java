package ussrfantom.com.example.guesstheanimecharacter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayLevel extends AppCompatActivity {

    Dialog dialogStart;
    private int positionLevel;
    private Button button0;
    private Button button1;
    private Button button2;
    private ImageView imageViewСharacter;
    private String [] stringImg;
    private String [] stringAnswerTrue;
    private String [] stringWrongAnswerOne;
    private String [] stringWrongAnswerTwo;
    int level;
    int startAnswerArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_level);
        Button buttonBack = findViewById(R.id.button_back);
        button0 = findViewById(R.id.button_answer1);
        button1 = findViewById(R.id.button_answer2);
        button2 = findViewById(R.id.button_answer3);
        imageViewСharacter = findViewById(R.id.image_character);
        stringImg = getResources().getStringArray(R.array.image_the_character);
        stringAnswerTrue = getResources().getStringArray(R.array.true_answer);
        stringWrongAnswerOne  = getResources().getStringArray(R.array.wrong_answer_one);
        stringWrongAnswerTwo  = getResources().getStringArray(R.array.wrong_answer_two);

        //убираем системное меню, едлаем его выдвижным
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //получаем данные о уровне из прошлой активности и пользуемся ими
        Intent intent = getIntent();
        positionLevel = intent.getIntExtra("msg", positionLevel);
        String[] textLevel = getResources().getStringArray(R.array.levels);
        TextView textViewLevels = findViewById(R.id.text_levels);
        textViewLevels.setText(textLevel[positionLevel]);
        level = positionLevel;

        //проверяем, с какими элементами массива мы работаем исходя из уровня
        startAnswerArray = 0;
        startAnswerArray = level * 20;


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

        PlayGame();
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

    public void PlayGame(){
        Picasso.get().load(stringImg[startAnswerArray]).into(imageViewСharacter);
        int random_number1 = 1 + (int) (Math.random() * 3);

        switch (random_number1){
            case (1) :
                Picasso.get().load(stringImg[startAnswerArray]).into(imageViewСharacter);
                button0.setText(stringAnswerTrue[startAnswerArray]);
                button1.setText(stringWrongAnswerOne[startAnswerArray]);
                button2.setText(stringWrongAnswerTwo[startAnswerArray]);
                startAnswerArray++;
                break;
            case (2) :
                Picasso.get().load(stringImg[startAnswerArray]).into(imageViewСharacter);
                button1.setText(stringAnswerTrue[startAnswerArray]);
                button2.setText(stringWrongAnswerOne[startAnswerArray]);
                button0.setText(stringWrongAnswerTwo[startAnswerArray]);
                startAnswerArray++;
                break;

            case (3) :
                Picasso.get().load(stringImg[startAnswerArray]).into(imageViewСharacter);
                button2.setText(stringAnswerTrue[startAnswerArray]);
                button0.setText(stringWrongAnswerOne[startAnswerArray]);
                button1.setText(stringWrongAnswerTwo[startAnswerArray]);
                startAnswerArray++;
                break;
        }





    }
}