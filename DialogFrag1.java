package com.palle.uni_project;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DialogFrag1 extends DialogFragment {

    ListView listView;
    MyDatabase myDatabase;
    Cursor cursor;
    String name,mobile;
    SimpleCursorAdapter simpleCursorAdapter;

    public DialogFrag1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog d = null;
        name = null; mobile = null;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.add_image);
        builder.setTitle("Student Details");
        MainActivity mainActivity = (MainActivity) getActivity();
        Bundle bundle = getArguments();
        if(bundle!=null) {
            name = bundle.getString("name");
            mobile = bundle.getString("mobile");
        }
        else{
            Toast.makeText(getActivity(), "+not", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getActivity(), ""+name, Toast.LENGTH_SHORT).show();
        //Toast.makeText(getActivity(), ""+mobile, Toast.LENGTH_SHORT).show();
        cursor = null;

        if(name != null) {
            cursor = myDatabase.queryName(name);
            if (cursor != null){
                View v1 = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_frag1,null);
                listView = (ListView) v1.findViewById(R.id.ListView2);

                simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                        R.layout.row,
                        cursor,
                        new String[]{"_id","no", "name", "mobile", "email", "subject", "description", "date"},
                        new int[]{R.id.id, R.id.no, R.id.name, R.id.mobile, R.id.email, R.id.subject, R.id.description, R.id.date});
                listView.setAdapter(simpleCursorAdapter);
                builder.setView(v1);
            }

        }
        else if(mobile!=null) {
            cursor = myDatabase.queryMobile(mobile);
            View v1 = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_frag1,null);
            listView = (ListView) v1.findViewById(R.id.ListView2);
            simpleCursorAdapter = new SimpleCursorAdapter(getActivity(),
                    R.layout.row,
                    cursor,
                    new String[]{"_id","no", "name", "mobile", "email", "subject", "description", "date"},
                    new int[]{R.id.id, R.id.no, R.id.name, R.id.mobile, R.id.email, R.id.subject, R.id.description, R.id.date});
            listView.setAdapter(simpleCursorAdapter);
            builder.setView(v1);
        }
        builder.setPositiveButton("sms", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.smssend();
                Toast.makeText(getActivity(), "send sms", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Email", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.emailsend();
            }
        });

        return d = builder.create();
    }
}

