package cl.jdjcode.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmData extends AppCompatActivity {


    private TextView tvName, tvPhone, tvEmail, tvDescrip, tvDate;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_data);

        Bundle parameters = getIntent().getExtras();
        String name = parameters.getString("Name");
        String phone = parameters.getString("Phone");
        String email = parameters.getString("Email");
        String descrip = parameters.getString("Descrip");
        String date = parameters.getString("Born");

        tvName = (TextView) findViewById(R.id.nameComplete);
        tvPhone = (TextView) findViewById(R.id.txPhone);
        tvEmail = (TextView) findViewById(R.id.txEmail);
        tvDescrip = (TextView) findViewById(R.id.txDescription);
        tvDate = (TextView) findViewById(R.id.txDateBorn);

        tvName.setText(name);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvDate.setText(date);
        tvDescrip.setText(descrip);
        btn = (Button) findViewById(R.id.Button01);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmData.super.onBackPressed();
                finish();
            }
        });

    }
}
