package ussrfantom.com.example.guesstheanimecharacter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class PlayLevel extends AppCompatActivity {

    Dialog dialogStart;
    Dialog dialogT;
    Dialog dialogF;
    private int positionLevel;
    private String positionLevelString;
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
    public int count = 0; //счетчик для выхода из уровня
    public int countTrueAnswer = 0;
    int pointsColor;

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
        positionLevelString = intent.getStringExtra("msg");
        String[] textLevel = getResources().getStringArray(R.array.levels);
        TextView textViewLevels = findViewById(R.id.text_levels);
        textViewLevels.setText(textLevel[GameLevels.numberOfPositionsSolved - 1]);
        level = GameLevels.numberOfPositionsSolved - 1;
        System.out.println("На момент старта переменная имеет значение level " + level);
        System.out.println("На момент старта переменная имеет значение positionLevel " + positionLevel);

        //проверяем, с какими элементами массива мы работаем исходя из уровня
        startAnswerArray = 0;
        startAnswerArray = level * 20;
        pointsColor = 0;

        //массив для прогресса игры
        final int[] progress = {R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,R.id.point6,R.id.point7,R.id.point8,R.id.point9,R.id.point10,R.id.point11,R.id.point12,R.id.point13,
                R.id.point14,R.id.point15,R.id.point16,R.id.point17,R.id.point18,R.id.point19,R.id.point20};


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


        //нажатие на кнопку 1
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button0.getText().toString().equals(stringAnswerTrue[startAnswerArray - 1])){
                    Toast.makeText(PlayLevel.this, "ВЕРНО!", Toast.LENGTH_SHORT).show();
                        TextView tv = findViewById(progress[pointsColor - 1]);
                        tv.setBackgroundResource(R.drawable.style_points_green);
                    countTrueAnswer++;
                    PlayGame();
                }else{
                    TextView tv = findViewById(progress[pointsColor - 1]);
                    tv.setBackgroundResource(R.drawable.style_points_red);
                    Toast.makeText(PlayLevel.this, "Ошибка! " + "Правльный ответ " + stringAnswerTrue[startAnswerArray -1], Toast.LENGTH_SHORT).show();
                    PlayGame();
                }
            }
        });

        //нажатие на кнопку 2
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button1.getText().toString().equals(stringAnswerTrue[startAnswerArray - 1])){
                    Toast.makeText(PlayLevel.this, "ВЕРНО!", Toast.LENGTH_SHORT).show();
                    TextView tv = findViewById(progress[pointsColor - 1]);
                    tv.setBackgroundResource(R.drawable.style_points_green);
                    countTrueAnswer++;
                    PlayGame();
                }else{
                    TextView tv = findViewById(progress[pointsColor - 1]);
                    tv.setBackgroundResource(R.drawable.style_points_red);
                    Toast.makeText(PlayLevel.this, "Ошибка! " + "Правльный ответ " + stringAnswerTrue[startAnswerArray -1], Toast.LENGTH_SHORT).show();
                    PlayGame();
                }
            }
        });

        //нажатие на кнопку 1
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (button2.getText().toString().equals(stringAnswerTrue[startAnswerArray - 1])){
                    Toast.makeText(PlayLevel.this, "ВЕРНО!", Toast.LENGTH_SHORT).show();
                    TextView tv = findViewById(progress[pointsColor - 1]);
                    tv.setBackgroundResource(R.drawable.style_points_green);
                    countTrueAnswer++;
                    PlayGame();
                }else{
                    TextView tv = findViewById(progress[pointsColor - 1]);
                    tv.setBackgroundResource(R.drawable.style_points_red);
                    Toast.makeText(PlayLevel.this, "Ошибка! " + "Правльный ответ " + stringAnswerTrue[startAnswerArray -1], Toast.LENGTH_SHORT).show();
                    PlayGame();
                }
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


    //Метод простановки вопросов и ответов
    public void PlayGame(){
        if (count <20) {
            int random_number1 = 1 + (int) (Math.random() * 3);
            switch (random_number1) {
                case (1):
                    Picasso.get().load(stringImg[startAnswerArray]).into(imageViewСharacter);
                    button0.setText(stringAnswerTrue[startAnswerArray]);
                    button1.setText(stringWrongAnswerOne[startAnswerArray]);
                    button2.setText(stringWrongAnswerTwo[startAnswerArray]);
                    startAnswerArray++;
                    count++;
                    pointsColor++;
                    break;
                case (2):
                    Picasso.get().load(stringImg[startAnswerArray]).into(imageViewСharacter);
                    button1.setText(stringAnswerTrue[startAnswerArray]);
                    button2.setText(stringWrongAnswerOne[startAnswerArray]);
                    button0.setText(stringWrongAnswerTwo[startAnswerArray]);
                    startAnswerArray++;
                    count++;
                    pointsColor++;
                    break;

                case (3):
                    Picasso.get().load(stringImg[startAnswerArray]).into(imageViewСharacter);
                    button2.setText(stringAnswerTrue[startAnswerArray]);
                    button0.setText(stringWrongAnswerOne[startAnswerArray]);
                    button1.setText(stringWrongAnswerTwo[startAnswerArray]);
                    startAnswerArray++;
                    count++;
                    pointsColor++;
                    break;
            }
        }else{
            if (countTrueAnswer >=16){
                Toast.makeText(this, "ПОБЕДА!", Toast.LENGTH_LONG).show();
                //Диалоговое окно стартовое
                dialogT = new Dialog(this);
                dialogT.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogT.setContentView(R.layout.dialogendt);
                dialogT.show();

                //кнопка продолжить
                Button buttoncomtinue1 = dialogT.findViewById(R.id.buttonContinue);
                buttoncomtinue1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogT.dismiss();
                        Intent intent = new Intent(PlayLevel.this, GameLevels.class);
                        GameLevels.numberOfPositionsSolved++;
                        startActivity(intent);
                        finish();
                    }
                });

            }else{
                Toast.makeText(this, "Слишком мало правильных ответов! Нужно не менее 17! Правильных ответов " + countTrueAnswer , Toast.LENGTH_LONG).show();
                //Диалоговое окно стартовое
                dialogF = new Dialog(this);
                dialogF.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogF.setContentView(R.layout.dialogendf);
                dialogF.show();

                //кнопка продолжить
                Button buttoncomtinue2 = dialogF.findViewById(R.id.buttonContinue);
                buttoncomtinue2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogF.dismiss();
                        Intent intent = new Intent(PlayLevel.this, GameLevels.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        }
    }
}