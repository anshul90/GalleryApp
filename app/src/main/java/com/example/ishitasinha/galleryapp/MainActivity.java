package com.example.ishitasinha.galleryapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ImageAdapter adapter;
    Button drawerButton, toolbarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerButton = (Button) findViewById(R.id.drawer_button);
        drawerButton.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/copperplate-gothic-bold-regular.ttf"));
        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
                startActivity(intent);
            }
        });

        toolbarButton = (Button) findViewById(R.id.collapsing_toolbar_button);
        toolbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScrollingActivity.class);
                startActivity(intent);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.container);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        ArrayList<String> imgUrls = new ArrayList<>(Arrays.asList(new String[]{
                "https://breathtakinglandscapes.files.wordpress.com/2013/02/breathtaking-landscapes-69-splendid-santa-maria-della-pieta-rocca-calascio-landscape-wallpapers-2.jpg",
                "http://www.ucreative.com/wp-content/uploads/2014/08/INNER-benoit-courti-INNER1.jpg",
                "http://cdn.paper4pc.com/images/road-through-the-forest-wallpaper-2.jpg",
                "http://webneel.com/daily/sites/default/files/images/daily/03-2013/8-forest-road-landscape-photography.jpg",
                "https://i.ytimg.com/vi/lKdTaSC_VV4/maxresdefault.jpg",
                "http://digital-photography-school.com/wp-content/uploads/flickr/3899477891_64e7568419_o.jpg",
                "http://digital-photography-school.com/wp-content/uploads/flickr/5661878892_15fba42846_o.jpg",
                "https://cdn.creativelive.com/fit/https%3A%2F%2Fcdn.creativelive.com%2Fagc%2Fcourses%2F5842-1.jpg/1600",
                "https://iso.500px.com/wp-content/uploads/2014/06/W4A2827-1-3000x2000.jpg",
                "http://digital-photography-school.com/wp-content/uploads/flickr/2746960560_8711acfc60_o.jpg"
        }));

        adapter = new ImageAdapter(this, imgUrls);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        indicator.setViewPager(viewPager);
    }

    public void textResize(View view) {
        Intent intent = new Intent(MainActivity.this, TextResizeActivity.class);
        startActivity(intent);
    }
}
