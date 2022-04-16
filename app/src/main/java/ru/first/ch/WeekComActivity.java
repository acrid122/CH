package ru.first.ch;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

public class WeekComActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private ViewPager viewPager;
    private ArrayList<model> ArrayModels;
    private AdapterForCarousel adapterForCarousel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_com);
        actionBar = getSupportActionBar();
        viewPager = findViewById(R.id.ViewPager);
        loadItems();
       /* viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //изменения заголовка actionbar
                String title = ArrayModels.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });*/
   /*Реализация кнопки "Меню". По идее не нужна, да и не рабочая эта реализация
   MenuButton = (ImageButton)findViewById(R.id.activity_week_com__menu_icon);
   MenuButton.setOnClickListener(this);
   /После onCreate
   @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.activity_week_com__menu_icon:
                Intent intent = new Intent(WeekComActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    */
    }
    private void loadItems() {
    //инициализация листа
        ArrayModels = new ArrayList<>();
        ArrayModels.add(new model(
                "Pancakes1",
                "Лучшие блины просто лучшие блины просто лучшие блины просто лучшие блины" +
                        "просто лучшие блиныпросто лучшие блиныпросто лучшие блины" +
                        "просто лучшие блиныпросто лучшие блиныпросто лучшие блиныпросто лучшие блины",
                R.drawable.preferences));
        ArrayModels.add(new model(
                "Pancakes2",
                " Вкусные блины простоВкусные блины простоВкусные блины простоВкусные блины просто" +
                        "Вкусные блины простоВкусные блины простоВкусные блины простоВкусные блины просто" +
                        "Вкусные блины простоВкусные блины просто",
                R.drawable.img_1));
        ArrayModels.add(new model(
                "Pancakes3",
                "The best dish in the world",
                R.drawable.img_2));
        ArrayModels.add(new model(
                "Pancakes4",
                "The best dish in the world",
                R.drawable.img_3));
        //настройка адаптера
        adapterForCarousel = new AdapterForCarousel(this, ArrayModels);
        //установка адаптера view pager
        viewPager.setAdapter(adapterForCarousel);
        //установка дефолтных паддингов
        viewPager.setPadding(100, 0,100,0);
    }
}