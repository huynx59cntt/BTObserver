package vn.edu.ntu.xuanhuy.model;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDate {
    Calendar calendar;
    LangNgheNgayThayDoi langNgheNgayThayDoi;
    Context context;

    public MyDate(Calendar calendar, LangNgheNgayThayDoi langNgheNgayThayDoi, Context context) {
        this.calendar = calendar;
        this.langNgheNgayThayDoi = langNgheNgayThayDoi;
        this.context = context;
    }

    public void hienThi(){
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                if(langNgheNgayThayDoi!=null)
                    langNgheNgayThayDoi.capNhapDate(calendar);

            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public static interface LangNgheNgayThayDoi{
        public void capNhapDate(Calendar date);
    }
}
