package ussrfantom.com.example.guesstheanimecharacter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class GameLevels extends AppCompatActivity {

    private RecyclerView recyclerViewLevels;
    private ArrayList <Levels> levels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_levels);
        recyclerViewLevels = findViewById(R.id.recyclerViewLevels);

        levels.add(new Levels("https://you-anime.ru/anime-images/characters/132959.jpg"));
        levels.add(new Levels("https://you-anime.ru/anime-images/characters/132959.jpg"));
        levels.add(new Levels("https://you-anime.ru/anime-images/characters/132959.jpg"));
        levels.add(new Levels("https://you-anime.ru/anime-images/characters/132959.jpg"));
        levels.add(new Levels("https://you-anime.ru/anime-images/characters/132959.jpg"));
        levels.add(new Levels("https://you-anime.ru/anime-images/characters/132959.jpg"));
        LevelsAdapter adapter = new LevelsAdapter(levels);
        recyclerViewLevels.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerViewLevels.setAdapter(adapter);


    }
}