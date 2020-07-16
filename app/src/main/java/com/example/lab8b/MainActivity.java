package com.example.lab8b;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView students, studentCount;
    private Button getAllStudents;
    private ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getAllStudents = (Button) findViewById(R.id.buttonGetAllStudents);
        students = (TextView) findViewById(R.id.textViewStudents);
        studentCount = (TextView) findViewById(R.id.textViewStudentCount);

        contentResolver = getContentResolver();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonGetAllStudents: getAllStudentRecords(); break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void getAllStudentRecords() {
        Cursor cursor = contentResolver.query(StudentProviderConstants.CONTENT_URI_1, null, null, null, null, null);
        StringBuilder stringBuilder = new StringBuilder("");
        if (cursor != null && cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                stringBuilder.append(cursor.getLong(0)+ ", " + cursor.getString(1) + ", " + cursor.getString(2) + "\n");
            }
            cursor.close();
            setCount();
        } else {
            studentCount.setText("Total Student Count: 0");
        }
        students.setText(stringBuilder.toString());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setCount() {
        Cursor cursor = contentResolver.query(StudentProviderConstants.CONTENT_URI_2, null, null, null, null, null);
        if (cursor!= null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            studentCount.setText("Total Student Count: " + cursor.getInt(0));
        }
        cursor.close();
    }
}