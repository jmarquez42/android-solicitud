package cl.jdjcode.register;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class form extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnClick;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextInputEditText  mDisplayDate, name, phone, email, description, dateBorn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);


        this.sendForm();


        mDisplayDate = (TextInputEditText) findViewById(R.id.inputBorn);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        form.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setTitle("Fecha Nacimiento");
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.i(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };


    }


    public void sendForm(){
        btnClick = (Button) findViewById(R.id.Button01);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = (TextInputEditText) findViewById(R.id.inputName);
                description = (TextInputEditText) findViewById(R.id.inputdescription);
                email = (TextInputEditText) findViewById(R.id.inputEmail);
                phone = (TextInputEditText) findViewById(R.id.inputPhone);
                dateBorn = (TextInputEditText) findViewById(R.id.inputBorn);
                Intent intent = new Intent(getApplicationContext(), confirmData.class);
                intent.putExtra("Name",   name.getText().toString());
                intent.putExtra("Phone",   phone.getText().toString());
                intent.putExtra("Email",   email.getText().toString());
                intent.putExtra("Descrip", description.getText().toString());
                intent.putExtra("Born",    dateBorn.getText().toString());
                startActivity(intent);

            }
        });



    }


}
