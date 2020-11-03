package ussrfantom.com.example.guesstheanimecharacter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameLevels extends AppCompatActivity {

    private RecyclerView recyclerViewLevels;
    private ArrayList <Levels> levels = new ArrayList<>();
    public static int numberOfPositionsSolved; //колличество решенных уровней
    private int truAnswerLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_levels);
        recyclerViewLevels = findViewById(R.id.recyclerViewLevels);
        Button buttonBack = findViewById(R.id.buttonBack);

        //убираем системное меню, едлаем его выдвижным
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        //заполнение массива
               for (int i = 0; i <=19; i++) {

                   if (numberOfPositionsSolved - 2 >= i) {
                       levels.add(new Levels("https://c.radikal.ru/c10/2011/12/38b82a8df6fc.jpg"));
                   }

                   if(numberOfPositionsSolved - 1 == i){
                       levels.add(new Levels("https://a.radikal.ru/a35/2010/68/d2934cfdd690.jpg"));
                   }
                   if(numberOfPositionsSolved <= i){
                       levels.add(new Levels("https://c.radikal.ru/c29/2010/db/7aeff8e7ddfa.jpg"));
                   }

               }
            //создаем адаптер и кладем в него массив + разметка+ ресайклер вью для отображения адаптера в нужном колличестве указанном в разметве
        LevelsAdapter adapter = new LevelsAdapter(levels);
        recyclerViewLevels.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerViewLevels.setAdapter(adapter);
        adapter.setOnImageClickListener(new LevelsAdapter.OnImageClickListener() {
            @Override
            public void onImageClick(int position) {
                if (numberOfPositionsSolved -1 == position){
                    Intent intent = new Intent(GameLevels.this, PlayLevel.class);
                    int a = position++;
                    intent.putExtra("msg", a);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(GameLevels.this, "Уровень закрыт!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //нажатие на кнопку назад
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try {
                  Intent intent = new Intent(GameLevels.this, MainActivity.class);
                  startActivity(intent);
                  finish();
              }catch (Exception e){

              }
            }
        });

    }
    //Системная кнопка Назад (правильный переход)
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}