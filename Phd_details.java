package com.palle.uni_project;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class  Phd_details extends Fragment {
    EditText et1, et2, et3, et4, et5, et6, et7;
    Button b1, b2, b3;
    MyDatabase myDatabase;

    public Phd_details() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDatabase = new MyDatabase(getActivity());
        myDatabase.open();
    }

    @Override
    public void onDestroy() {
        myDatabase.close();
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_phd_details, container, false);
        et1 = (EditText) v.findViewById(R.id.edittext1);
        et2 = (EditText) v.findViewById(R.id.edittext2);
        et3 = (EditText) v.findViewById(R.id.edittext3);
        et4 = (EditText) v.findViewById(R.id.edittext4);
        et5 = (EditText) v.findViewById(R.id.edittext5);
        et6 = (EditText) v.findViewById(R.id.edittext6);
        et7 = (EditText) v.findViewById(R.id.edittext7);
        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.button2);
        b3 = (Button) v.findViewById(R.id.button3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onCreateDialog();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = et1.getText().toString();
                String name = et2.getText().toString();
                String mobile = et3.getText().toString();
                String email = et4.getText().toString();
                String subject = et5.getText().toString();
                String description = et6.getText().toString();
                String date = et7.getText().toString();
//                MainActivity mainActivity = (MainActivity) getActivity();
                myDatabase.insertStudent(no, name, mobile, email, subject, description, date);
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et4.setText("");
                et5.setText("");
                et6.setText("");
                et7.setText("");
                et1.requestFocus();

                Toast.makeText(getActivity(), "Data is successfully inserted into database", Toast.LENGTH_SHORT).show();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadSecondFrag();

            }
        });


        return v;
    }

    public Dialog onCreateDialog() {
        Dialog d = null;
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog =
                new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int date) {
                                Toast.makeText(getActivity(),
                                        "SELECTED DATE IS " + year + "-" + date + "-" + month + "", Toast.LENGTH_SHORT).show();
                                et7.setText(+year + "-" + date + "-" + month);

                            }
                        }, year, month, date);
        d = datePickerDialog;
        d.show();
        return d;

    }
}
