package com.example.rxbro.fragmenthw;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1CommsCallback, Fragment2.Fragment2CommsCallback {

    Fragment1 fragment1;
    Fragment2 fragment2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction  = manager.beginTransaction();
        transaction.add(R.id.Fragment1Container, fragment1);
        transaction.add(R.id.Fragment2Container, fragment2);
        transaction.commit();

    }

    @Override
    public void frag1Hi(String greeting) {
        fragment2.setGreetingMessage(greeting);
    }
    @Override
    public void frag1Bye(String message) {
        fragment2.setLeavingMessage(message);
    }
    @Override
    public void frag2Hi(String greeting) {
        fragment1.setResult(greeting);
    }
    @Override
    public void frag2Bye(String message) {
        fragment1.setResult(message);
    }
    @Override
    public void onMessageReceived(String message) {

    }


}
