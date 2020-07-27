package com.lw.mutao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.lw.mutao.view.fragment.FindFragment;
import com.lw.mutao.view.fragment.MainFragmnt;
import com.lw.mutao.view.fragment.MeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected LinearLayout mainMenu;
    protected LinearLayout findMenu;
    protected LinearLayout meMenu;
    protected MainFragmnt mainFragmnt= new MainFragmnt();
    protected FindFragment findFragment = new FindFragment();
    protected MeFragment meFragment = new MeFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findView
        findView();
        //init
        initData();

    }

    private void findView() {
        mainMenu = findViewById(R.id.menu_main);
        findMenu = findViewById(R.id.menu_find);
        meMenu = findViewById(R.id.menu_me);

        mainMenu.setOnClickListener(this);
        findMenu.setOnClickListener(this);
        meMenu.setOnClickListener(this);
    }

    private void initData() {
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_content, mainFragmnt)
                .add(R.id.container_content, findFragment)
                .hide(findFragment)
                .add(R.id.container_content, meFragment)
                .hide(meFragment)
                .commit();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.menu_main:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mainFragmnt)
                        .hide(findFragment)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_find:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(findFragment)
                        .hide(mainFragmnt)
                        .hide(meFragment)
                        .commit();
                break;
            case R.id.menu_me:
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(meFragment)
                        .hide(mainFragmnt)
                        .hide(findFragment)
                        .commit();
        }

    }
}
