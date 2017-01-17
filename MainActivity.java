package com.palle.uni_project;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDatabase myDatabase;

    public void loginFragTwo(){
        LoginFragment2 loginFragment2 = new LoginFragment2();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, loginFragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void buttonTwoClick(){

        RegisterFragment registerFragment = new RegisterFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, registerFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void loadSecondFrag(){
        HomeFragment homeFragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1,homeFragment);
        fragmentTransaction.commit();

    }
    public void buttonClick(){
        Phd_details phd_details = new Phd_details();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1,phd_details);
        fragmentTransaction.commit();
    }
    public void searchOnClick(){
        SearchFragment searchFragment = new SearchFragment();
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, searchFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void smssend(){
        EmailFragment emailFragment = new EmailFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, emailFragment);
        fragmentTransaction.commit();
    }
    public void save(){
        ListViewFragment listViewFragment = new ListViewFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, listViewFragment);
        fragmentTransaction.commit();
    }
    public void listViewFrag(){
        ListViewFragment listViewFragment = new ListViewFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, listViewFragment);
        fragmentTransaction.commit();
    }
    public void emailsend(){
        SearchFragment searchFragment = new SearchFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container1, searchFragment);
        fragmentTransaction.commit();
    }
    public void passNameSearch(String name){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
       // DialogFragment dialogFragment = new DialogFragment();
        DialogFrag1 dialogFrag1=new DialogFrag1();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        dialogFrag1.setArguments(bundle);
        dialogFrag1.show(getFragmentManager(),null);
        fragmentTransaction.commit();
    }
    public void passMobileSearch(String mobile){
        //FragmentManager fragmentManager=getSupportFragmentManager();
        //FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        //DialogFragment dialogFragment = new DialogFragment();
        DialogFrag1 dialogFrag1=new DialogFrag1();
        Bundle bundle = new Bundle();
        bundle.putString("mobile",mobile);
        dialogFrag1.setArguments(bundle);
        dialogFrag1.show(getFragmentManager(),null);
        //fragmentTransaction.commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginFragment loginFragment=new LoginFragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1,loginFragment);
        fragmentTransaction.commit();
    }
}
