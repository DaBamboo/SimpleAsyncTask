package com.bamboo.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class simpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;
    simpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Enfin réveillé après " + s + " millisecondes !";
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }
}
