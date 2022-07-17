package com.example.a2playergames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button buttonTicTacToe;
    private Button buttonConnect4;
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTicTacToe = findViewById(R.id.button_tictactoe);
        buttonTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRunning){
                    getSupportFragmentManager().popBackStack();
                }
                isRunning = true;
                SaveData.getInstance().resetData();
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = new TicTacToeFragment();
                fm.beginTransaction()
                        .replace(R.id.fragment_container,fragment)
                        .addToBackStack(fragment.getClass().getName())
                        .commit();
            }
        });
        buttonConnect4 = findViewById(R.id.button_connect_4);
        buttonConnect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRunning){
                    getSupportFragmentManager().popBackStack();
                }
                isRunning = true;
                SaveData.getInstance().resetData();
                FragmentManager fm = getSupportFragmentManager();
                Fragment fragment = new Connect4Fragment();
                fm.beginTransaction()
                        .replace(R.id.fragment_container,fragment)
                        .addToBackStack(fragment.getClass().getName())
                        .commit();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        isRunning = false;
    }
}
