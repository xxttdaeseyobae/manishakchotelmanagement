package com.softwarica.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private TextView tvcid;
    private TextView tvcod, tvGrandTotal, tvTotal, tvvat;
    private Spinner spsrt;
    private Button btncal;
    private EditText etadult, etchild, etrooms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvcid = findViewById(R.id.tvcid);
        tvcod = findViewById(R.id.tvcod);
        tvGrandTotal = findViewById(R.id.tvGrandTotal);
        tvTotal = findViewById(R.id.tvTotal);
        tvvat = findViewById(R.id.tvVat);
        spsrt = findViewById(R.id.spsrt);
        btncal = findViewById(R.id.btncal);
        etadult = findViewById(R.id.etadult);
        etchild = findViewById(R.id.etchild);
        etrooms = findViewById(R.id.etrooms);

         String rooms[] = {"Deluxe- Rs.2000", "Presidential - Rs.5000", "Premium - Rs.4000"};
 ArrayAdapter adapter =new ArrayAdapter<>(
        this,
        android.R.layout.simple_list_item_1,
        rooms
);
spsrt.setAdapter(adapter);

        tvcod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });

        tvcid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker2();
            }
        });
        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int rooms;
                double total,price,vat,grosstotal;

            if (TextUtils.isEmpty(tvcod.getText())) {
                tvcod.setError("Please select the checkout date");
                return;
            } else if (TextUtils.isEmpty(etadult.getText())) {
                etadult.setError("Please enter no of adult");
                return;
            } else if (TextUtils.isEmpty(etchild.getText())) {
                etchild.setError("Please enter no of children");
                return;
            } else if (TextUtils.isEmpty(etrooms.getText())) {
                etrooms.setError("Enter no of rooms.");
                return;
            }


                rooms = Integer.parseInt(etrooms.getText().toString());

                if (spsrt.getSelectedItem() == "Deluxe - Rs.2000") ;
                {
                    tvTotal.setText("2000");
                }

                if (spsrt.getSelectedItem() == "Presidential - Rs.5000") ;
                {
                    tvTotal.setText("5000");
                }

                if (spsrt.getSelectedItem() == "Premium - Rs.4000") ;

                {
                    tvTotal.setText("4000");
                }

                price = Integer.parseInt(tvTotal.getText().toString());
                total = price * rooms;
                vat = 0.13 * total;
                grosstotal = total + vat;
                tvGrandTotal.append("Total: Rs. " + total + "\n VAT (13%): Rs. " + vat + "\n Grand Total: Rs. " + grosstotal + "\n");


            }
        });
    }



    private void loadDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,new DatePickerDialog.OnDateSetListener(){


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Month/Day/Year:" + month + "/" + dayOfMonth + "/" + year;
        tvcod.setText(date);

    }
        }, year, month, day);
        datePickerDialog.show();
    }

    private void loadDatePicker2() {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,new DatePickerDialog.OnDateSetListener(){



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Month/Day/Year:" + month + "/" + dayOfMonth + "/" + year;
        tvcod.setText(date);

    }
}, year, month, day);
        datePickerDialog.show();
        }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        
    }
}



