package com.palle.uni_project;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {

    ListView listView;
    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
    MyDatabase myDatabase;



    public ListViewFragment() {
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

        View v = inflater.inflate(R.layout.fragment_list_view, container, false);
        listView = (ListView) v.findViewById(R.id.listView1);
        cursor = myDatabase.queryStudent();
        simpleCursorAdapter  = new SimpleCursorAdapter(getActivity(),
                R.layout.row,
                cursor,
                new String[]{"_id","no", "name", "mobile", "email", "subject", "description","date"},
                new int[]{R.id.id, R.id.no, R.id.name, R.id.mobile, R.id.email, R.id.subject, R.id.description, R.id.date});
        listView.setAdapter(simpleCursorAdapter);

        return v;
    }

}
