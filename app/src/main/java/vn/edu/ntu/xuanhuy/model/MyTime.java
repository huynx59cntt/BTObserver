package vn.edu.ntu.xuanhuy.model;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTime {
    Calendar calendar;
    LangNgheTimeThayDoi langNgheTimeThayDoi;
    Context context;

    public MyTime(Calendar calendar, LangNgheTimeThayDoi langNgheTimeThayDoi, Context context) {
        this.calendar = calendar;
        this.langNgheTimeThayDoi = langNgheTimeThayDoi;
        this.context = context;
    }

    public void hienThiTime(){
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(0,0,0,hourOfDay,minute);
                if(langNgheTimeThayDoi !=null)
                    langNgheTimeThayDoi.capNhapTime(calendar);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, listener,  calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),true);
        timePickerDialog.show();
    }
    public static interface LangNgheTimeThayDoi{
        public void capNhapTime(Calendar time);
    }
}
