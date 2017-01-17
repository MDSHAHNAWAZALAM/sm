package com.palle.uni_project;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    EditText et1, et2, et3, et4, et5, et6;
    Button b1,b2;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_register, container, false);
        et1= (EditText) v.findViewById(R.id.edittext1);
        et2= (EditText) v.findViewById(R.id.edittext2);
        et3= (EditText) v.findViewById(R.id.edittext3);
        et4= (EditText) v.findViewById(R.id.edittext4);
        et5= (EditText) v.findViewById(R.id.edittext5);
        et6= (EditText) v.findViewById(R.id.edittext6);
        b1= (Button) v.findViewById(R.id.button1);
        b2= (Button) v.findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().isEmpty() || et2.getText().toString().isEmpty() || et3.getText().toString().isEmpty()||
                        et4.getText().toString().isEmpty()|| et5.getText().toString().isEmpty()||et6.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "enter details", Toast.LENGTH_SHORT).show();
                }
                else {
                    SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putString("no", et1.getText().toString());
                    ed.putString("uname", et2.getText().toString());
                    ed.putString("mail", et3.getText().toString());
                    ed.putString("pw", et4.getText().toString());
                    ed.putString("cpw", et5.getText().toString());
                    ed.putString("pwhint", et6.getText().toString());
                    ed.commit();//save into preference file
                    Toast.makeText(getActivity(), "Successfully data saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.loginFragTwo();
            }
        });


        return v;
    }

}
