package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.abdelmun3m.jokediaplay.*;
import com.udacity.gradle.builditbigger.backend.MyEndpoint;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
// Toast.makeText(this, j.getJoke(), Toast.LENGTH_SHORT).show();
       /* Intent i = new Intent(this,DisplayActivity.class);
        i.putExtra("joke",j.getJoke());
        startActivity(i);*/

       new AsyncTask<Void,Void,String>(){
           @Override
           protected String doInBackground(Void... voids) {


               MyEndpoint ep = new MyEndpoint();
               ep.sayHi("ali");
               //MyBean resp =  ep.getJoke();
               return "";
           }

           @Override
           protected void onPostExecute(String s) {
               super.onPostExecute(s);
                Intent i = new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("joke",s);
                startActivity(i);
           }
       };
    }


}
