package com.example.listitemstring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     private ListView mListViewCountry;
     private List<Country> mDataCountrys;
     public static final String CONTRYNAME="COUNTRYNAME";
     public static final String FLAGNAME="FLAGNAME";
     public static final String POPULATION="POPULATION";
     public static final String BUNDLE="BUNDLE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewCountry = (ListView) findViewById(R.id.listView);

        mDataCountrys = getListData();

        mListViewCountry.setAdapter(new CustomListAdapter(this, mDataCountrys));

        // Khi người dùng click vào các ListItem
//        mListViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                Object o = mListViewCountry.getItemAtPosition(position);
//                Country country = (Country) o;
//                Toast.makeText(MainActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();
//            }
//        });
//        mListViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                Country country = (Country) mListViewCountry.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this, "Selected :" + " " + country.getCountryName(), Toast.LENGTH_LONG).show();
//            }
//        });
        mListViewCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Country country = (Country) mListViewCountry.getItemAtPosition(i);
                String countryname= country.getCountryName();
                Integer population = country.getPopulation();
                String flagname = country.getFlagName();
                Intent intent = new Intent(MainActivity.this, ChiTietCountry.class);
                Bundle bundle = new Bundle();
                bundle.putString(CONTRYNAME, countryname);
                bundle.putString(FLAGNAME, flagname);
                bundle.putInt(POPULATION, population);
                intent.putExtra(BUNDLE, bundle);
                startActivity(intent);
            }
        });


    }

    private  List<Country> getListData() {
        List<Country> list = new ArrayList<Country>();
        Country vietnam = new Country("Vietnam", "vi", 98000000);
        Country usa = new Country("United States", "us", 320000000);
        Country russia = new Country("Russia", "ru", 142000000);
        Country china = new Country("China", "cn" ,  12300000);
        Country afghanistan = new Country("Afghanistan", "af", 255000000);
        Country albania = new Country("Albania", "ag", 25600000);
        Country algeria = new Country("Algeria", "ad", 345000000);
        Country andorra = new Country("Andorra", "al", 287000000);
        Country angola = new Country("Agola", "ao", 634000000);
        Country argentina = new Country("Argentina", "dz", 34000000);
        Country armenia = new Country("Armeria", "cn", 432000000);

        list.add(vietnam);
        list.add(usa);
        list.add(russia);
        list.add(china);
        list.add(afghanistan);
        list.add(andorra);
        list.add(albania);
        list.add(algeria);
        list.add(angola);
        list.add(argentina);
        list.add(armenia);

        return list;
    }

}

