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
        int imageId = getResourseId(this, imageName, "mipmap", getPackageName());
        ivFlagName.setImageResource(imageId);
    }

    public static int getResourseId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }

}


