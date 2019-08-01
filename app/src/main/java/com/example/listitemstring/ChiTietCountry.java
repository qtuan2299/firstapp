package com.example.listitemstring;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChiTietCountry extends AppCompatActivity {
    TextView tvContryName;
    TextView tvPopulation;
    ImageView ivFlagName;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutchitietcountry);
        tvContryName = (TextView) findViewById(R.id.textView_countryName);
        tvPopulation = (TextView) findViewById(R.id.textView_population);
        ivFlagName = (ImageView) findViewById(R.id.imageView_flag);

        Intent intent = getIntent();
        tvContryName.setText("Country Name: " + intent.getStringExtra(MainActivity.CONTRYNAME));
        tvPopulation.setText("Population : " + intent.getStringExtra(MainActivity.POPULATION));

        String imageName = intent.getStringExtra(MainActivity.FLAGNAME);
        int imageId = context.getResources().getIdentifier(imageName, "mipmap", context.getPackageName());
        ivFlagName.setImageResource(imageId);



    }

}
