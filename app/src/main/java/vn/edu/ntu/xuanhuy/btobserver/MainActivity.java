package vn.edu.ntu.xuanhuy.btobserver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.DoubleBuffer;
import java.util.Calendar;

import vn.edu.ntu.xuanhuy.model.MyDate;
import vn.edu.ntu.xuanhuy.model.MyTime;

public class MainActivity extends AppCompatActivity implements MyDate.LangNgheNgayThayDoi, MyTime.LangNgheTimeThayDoi {
    TextView edtDate, edtHours;
    ImageView imgDate , imgHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        addEvent();
    }
    private void addView(){
        edtDate = findViewById(R.id.edtDate);
        imgDate = findViewById(R.id.imgDate);
        edtHours = findViewById(R.id.edtHours);
        imgHours = findViewById(R.id.imgHours);
    }
    private  void addEvent(){
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDate myDate = new MyDate(Calendar.getInstance(), MainActivity.this,MainActivity.this);
                myDate.hienThi();
            }
        });

        imgHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTime myTime = new MyTime(Calendar.getInstance(), MainActivity.this, MainActivity.this);
                myTime.hienThiTime();
            }
        });
    }

    @Override
    public void capNhapDate(Calendar date) {
        StringBuilder builder = new StringBuilder();
        builder.append(date.get(Calendar.DAY_OF_MONTH)).append("/")
                .append(date.get(date.MONTH) + 1)
                .append("/")
                .append(date.get(date.YEAR));
        edtDate.setText(builder.toString());
    }

    @Override
    public void capNhapTime(Calendar time) {
        StringBuilder builder = new StringBuilder();
        builder.append(time.get(Calendar.HOUR_OF_DAY)).append("h")
                .append(time.get(Calendar.MINUTE)).append("m");
        edtHours.setText(builder.toString());
    }
}
