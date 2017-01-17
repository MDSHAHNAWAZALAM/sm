package com.palle.uni_project;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Datepicker extends DialogFragment {


    public Datepicker() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d=null;
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DATE);
        DatePickerDialog datePickerDialog=
                new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                                Toast.makeText(getActivity(), "SELECTED DATE IS"+i+"-"+i1+"-"+i2+"", Toast.LENGTH_SHORT).show();

                            }

                        },year,month,date);

                d=datePickerDialog;
        return d;

    }


    }


