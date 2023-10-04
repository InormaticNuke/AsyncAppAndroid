package com.example.asyncappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtLdng);
        imageView = findViewById(R.id.imageView);

        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<Void, Void, String>{

        protected String doInBackground(Void... voids){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return "Completed Process";
        }

        @Override
        protected void onPostExecute(String result) {
            textView.setText(result);
            imageView.setVisibility(imageView.VISIBLE);
        }
    }
}