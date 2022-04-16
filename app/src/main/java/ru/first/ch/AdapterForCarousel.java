package ru.first.ch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class AdapterForCarousel extends PagerAdapter {
    private Context context;
    private ArrayList<model> ArrayModels;
    //Конструктор

    public AdapterForCarousel(Context context, ArrayList<model> arrayModels) {
        this.context = context;
        ArrayModels = arrayModels;
    }

    @Override
    public int getCount(){
        return ArrayModels.size(); //возвращает количество фоток в массиве;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position){
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, container, false);
        ImageView bannerV = view.findViewById(R.id.activity_week_com__banner);
        TextView titleV = view.findViewById(R.id.activity_week_com__title);
        TextView descriptionV = view.findViewById(R.id.activity_week_com__description);
        model model = ArrayModels.get(position);
        final String title = model.getTitle();
        final String description = model.getDescription();
        int image = model.getImage();
        bannerV.setImageResource(image);
        titleV.setText(title);
        descriptionV.setText(description);
        bannerV.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view){
               Toast.makeText(context, title + "\n" + description, Toast.LENGTH_SHORT).show();
           }
        });
        container.addView(view, position);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object obj){
        container.removeView((View)obj);
    }
}
