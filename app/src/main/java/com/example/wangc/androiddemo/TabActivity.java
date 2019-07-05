package com.example.wangc.androiddemo;

import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TabActivity extends AppCompatActivity implements Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener,
            Fragment3.OnFragmentInteractionListener{
    private TextView mTextMessage;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;

    private int current = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    tab(0);
                    current = 0;
                    return true;
                case R.id.navigation_dashboard:
                    tab(1);
                    current = 1;
                    return true;
                case R.id.navigation_notifications:
                    tab(2);
                    current = 2;
                    return true;
            }
            return false;
        }
    };

    private void tab(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (i){
            case 0:
                if (null == fragment1){
                    fragment1 = Fragment1.newInstance("","");
                    fragmentTransaction.add(R.id.container,fragment1);
                }else{
                    fragmentTransaction.replace(R.id.container,fragment1);
                }
                break;
            case 1:
                if (null == fragment2){
                    fragment2 = Fragment2.newInstance("","");
                    fragmentTransaction.add(R.id.container,fragment2);
                }else{
                    fragmentTransaction.replace(R.id.container,fragment2);
                }
                break;
            case 2:
                if (null == fragment3){
                    fragment3 = Fragment3.newInstance("","");
                    fragmentTransaction.add(R.id.container,fragment3);
                }else{
                    fragmentTransaction.replace(R.id.container,fragment3);
                }
                break;
        }

        fragmentTransaction.commit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


         fragment2 = Fragment2.newInstance("","");
         fragment3 = Fragment3.newInstance("","");

        navView.setSelectedItemId(R.id.navigation_home);

        FrameLayout root = (FrameLayout) this.getWindow().getDecorView();

        final View window = LayoutInflater.from(this).inflate(R.layout.window,null);
        final TextView textView = window.findViewById(R.id.tv);

        root.addView(window);

        Point outSize = new Point();
        getWindowManager().getDefaultDisplay().getRealSize(outSize);
        final int x = outSize.x;
        final int y = outSize.y;

        final FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) window.getLayoutParams();
        layoutParams.leftMargin = x-300;
        layoutParams.topMargin = y-600;

        window.setLayoutParams(layoutParams);


        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        layoutParams.leftMargin = Float.valueOf(event.getX()).intValue();
                        layoutParams.topMargin =  Float.valueOf(event.getY()).intValue();

                        Log.e("+++","x="+Float.valueOf(event.getX()).intValue()+"y="+Float.valueOf(event.getY()).intValue());

                        textView.setLayoutParams(layoutParams);
                        break;
                }
                return false;
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TabActivity.this,"click"+current,Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
