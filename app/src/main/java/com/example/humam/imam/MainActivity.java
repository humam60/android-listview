package com.example.humam.imam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    String [] rank;
    String[] about_imam;
    int [] img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        rank = new String[] { "الا مام علي(ع)","الامام الحسن (ع)","الامام الحسين(ع)" ,"الامام السجاد(ع)" ,"الامام الباقر (ع)","الامام الصادق (ع)","الامام الكاظم (ع)","الامام الرضا (ع)","الامام الجواد (ع)","الامام الهادي (ع)","الامام العسكري (ع)","الامام المهدي (ع)"
        };

        //img= new int[]{R.drawable.ali, R.drawable.hasn};




        final ListView list=(ListView)findViewById(R.id.listView);
        list.setAdapter(new listimams(this));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("position", position);
                i.putExtra("rank", rank);
                // i.putExtra("img",img);

                startActivity(i);


            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent x=new Intent(this,about_eng.class);
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {
            startActivity(x);



        }


        return super.onOptionsItemSelected(item);
    }




    class  listimams extends BaseAdapter{
Context context;
        ArrayList<imams> mydata;
        listimams(MainActivity mainActivity){
            this.context=context;
            mydata=new ArrayList<imams>();
            mydata.add(new imams("الامام علي عليه السلام", R.drawable.ali));
           mydata.add(new imams("الامام الحسن عليه السلام ",R.drawable.hasn));
            mydata.add(new imams("الامام الحسين عليه السلام",R.drawable.hus));
            mydata.add(new imams("الامام السجاد عليه السلام",R.drawable.sa));
            mydata.add(new imams("الامام الباقر عليه السلام",R.drawable.baq));
            mydata.add(new imams("الامام الصادق عليه السلام",R.drawable.sadeq));
            mydata.add(new imams("الامام الكاظم عليه السلام",R.drawable.ka));
            mydata.add(new imams("الامام الرضا عليه السلام",R.drawable.reza));
            mydata.add(new imams("الامام الجواد عليه السلام",R.drawable.jawad));
            mydata.add(new imams("الامام الهادي عليه السلام",R.drawable.hadi));
            mydata.add(new imams("الامام العسكري عليه السلام",R.drawable.ask));
            mydata.add(new imams("الامام المهدي عليه السلام",R.drawable.mahdi));





        }


        @Override
        public int getCount() {
            return mydata.size();

        }

        @Override
        public Object getItem(int position) {
            return mydata.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public  View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.listrow, parent, false);
            TextView imam=(TextView)row.findViewById(R.id.textView);
            ImageView im=(ImageView)row.findViewById(R.id.imageView);

            imams temp=mydata.get(position);





            imam.setText(temp.name);
            im.setImageResource(temp.img);

            return row;
        }
    }


  /* public void about(MenuItem item) {
        startActivity(new Intent(this ,about_eng.class));



    }*/

}
