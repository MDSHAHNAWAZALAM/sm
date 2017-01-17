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
public class LoginFragment2 extends Fragment {
EditText et1,et2,et3;
    Button b1,b2;

    public LoginFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login_fragment2, container, false);
        et1= (EditText) v.findViewById(R.id.edittext1);
        et2= (EditText) v.findViewById(R.id.edittext2);
        et3= (EditText) v.findViewById(R.id.edittext3);
        b1= (Button) v.findViewById(R.id.button1);
        b2= (Button) v.findViewById(R.id.button2);
        SharedPreferences sp=getActivity().getSharedPreferences("credentials", 0);
        final String val1=sp.getString("uname",null);
        final String val2=sp.getString("pw",null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et1.getText().toString().isEmpty() &&et2.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Enter corect id and password", Toast.LENGTH_SHORT).show();
                }
                else if ((val1.equals(et1.getText().toString())) && (val2.equals(et2.getText().toString()))){
                    MainActivity mainActivity = (MainActivity) getActivity();
                    mainActivity.loadSecondFrag();
                }
                 else{
                    Toast.makeText(getActivity(), "Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return v;
    }

}
