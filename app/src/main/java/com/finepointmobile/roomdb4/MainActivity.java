package com.finepointmobile.roomdb4;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        new InsertData().execute();
    }

    private class InsertData extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            AppDatabase db = Room.databaseBuilder(mContext, AppDatabase.class, "production").build();
            User user = new User("Daniel");
            db.userDao().insertAll(user);
            List<User> users = db.userDao().getAllUsers();
            return null;
        }
    }
}
