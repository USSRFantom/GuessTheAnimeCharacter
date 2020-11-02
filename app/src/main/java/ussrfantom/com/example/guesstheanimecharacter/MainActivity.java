package ussrfantom.com.example.guesstheanimecharacter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewStart;
    private long backPressedTime;
    private Toast backToast;
    SharedPreferences sPref;
    final String SAVE_INT = "save_int";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewStart = findViewById(R.id.imageViewStart);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loadInt();

        imageViewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GameLevels.numberOfPositionsSolved == 0){
                    Intent intent = new Intent(MainActivity.this, GameLevels.class);
                    GameLevels.numberOfPositionsSolved++;
                    startActivity(intent);
                }else{
                Intent intent = new Intent(MainActivity.this, GameLevels.class);
                startActivity(intent);
                finish();
            }
            }
        });



    }



    //Системная кнопка назад, выход из уровня при двойном клике


    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще раз чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }



    public void saveInt(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putInt(SAVE_INT, GameLevels.numberOfPositionsSolved);
        ed.commit();
        Toast.makeText(this, "Сохранили "  + GameLevels.numberOfPositionsSolved,  Toast.LENGTH_SHORT).show();
    }

    public void loadInt () {
        sPref = getPreferences(MODE_PRIVATE);
        GameLevels.numberOfPositionsSolved= sPref.getInt(SAVE_INT, 0);
        Toast.makeText(this, "Достали " + GameLevels.numberOfPositionsSolved, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveInt();
    }
}