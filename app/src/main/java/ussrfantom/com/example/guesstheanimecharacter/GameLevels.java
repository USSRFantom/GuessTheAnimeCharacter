package ussrfantom.com.example.guesstheanimecharacter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;

public class GameLevels extends AppCompatActivity {

    private RecyclerView recyclerViewLevels;
    private ArrayList <Levels> levels = new ArrayList<>();
    public static int numberOfPositionsSolved; //колличество решенных уровней

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_levels);
        recyclerViewLevels = findViewById(R.id.recyclerViewLevels);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //заполнение массива
        for (int i = 0; i <=50; i++){
            if(i < numberOfPositionsSolved){
                levels.add(new Levels("https://a.radikal.ru/a35/2010/68/d2934cfdd690.jpg"));
            }else{
                levels.add(new Levels("https://c.radikal.ru/c29/2010/db/7aeff8e7ddfa.jpg"));
            }
        }



        LevelsAdapter adapter = new LevelsAdapter(levels);
        recyclerViewLevels.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerViewLevels.setAdapter(adapter);


    }
}