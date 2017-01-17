package com.palle.uni_project;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    EditText et1, et2;
    Button b1, b2;
    TextView tv1,tv2;

    MyDatabase myDatabase;


    public SearchFragment() {
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
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        et1 = (EditText) v.findViewById(R.id.edittext1);
        et2 = (EditText) v.findViewById(R.id.edittext2);
        tv1= (TextView) v.findViewById(R.id.textView1);
        tv2= (TextView) v.findViewById(R.id.textview2);

        b1 = (Button) v.findViewById(R.id.button1);
        b2 = (Button) v.findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = et1.getText().toString();
               // Toast.makeText(getActivity(), ""+name, Toast.LENGTH_SHORT).show();
                MainActivity mainActivity = (MainActivity) getActivity();
                if(name.isEmpty()){
                    Toast.makeText(getActivity(), "enter your name", Toast.LENGTH_SHORT).show();
                }
                else{

                    mainActivity.passNameSearch(name);
                    et1.setText("");
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobile = et2.getText().toString();
               // Toast.makeText(getActivity(), ""+mobile, Toast.LENGTH_SHORT).show();
                MainActivity mainActivity = (MainActivity) getActivity();
                if(mobile.isEmpty()){
                    Toast.makeText(getActivity(), "enter your mobile no", Toast.LENGTH_SHORT).show();
                }
                else {

                    mainActivity.passMobileSearch(mobile);
                    et2.setText("");
                }
            }
        });
        return v;
    }

}
