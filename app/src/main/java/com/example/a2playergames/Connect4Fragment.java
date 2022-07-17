package com.example.a2playergames;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Connect4Fragment extends Fragment {

    private static int column1Counter = 5,column2Counter = 5,column3Counter = 5,column4Counter = 5,column5Counter = 5;
    private List<Button> buttons = new ArrayList<>();
    private static Input turn = Input.R;
    private static Input[][] board = new Input[5][5];

    public enum Input {
        E,R,B
    }
    private enum GameState {
        DRAW,R_WINS,B_WINS,NOT_FINISHED
    }

    private static void switchTurn()
    {
        if (turn.equals(Input.R)) {
            turn = Input.B;
        }else {
            turn = Input.R;
        }

    }
    public static void resetMoveCount(){
        column1Counter = 5;
        column2Counter = 5;
        column3Counter = 5;
        column4Counter = 5;
        column5Counter = 5;
        turn = Input.R;
    }
    public static void drawBoard()
    {
        board = SaveData.getInstance().getConnect4();
    }
    private int colour()
    {
        if (turn.equals(Input.R)){
            return Color.parseColor("#FF0000");
        }else {
            return Color.parseColor("#3F51B5");
        }
    }
    private static GameState winMessage(Input player)
    {
        if (player.equals(Input.R)){
            return GameState.R_WINS;
        }else
        {
            return GameState.B_WINS;
        }
    }
    private static GameState checkState(int x,int y)
    {
        for(int i = 0; i < 4; i++){
            if(!board[x][i].equals(turn))
                break;
            if(i == 3){
                return winMessage(turn);
            }
        }
        for(int i = 1; i < 5; i++){
            if(!board[x][i].equals(turn))
                break;
            if(i == 4){
                return winMessage(turn);
            }
        }

        for(int i = 0; i < 4; i++){
            if(!board[i][y].equals(turn))
                break;
            if(i == 3){
                return winMessage(turn);
            }
        }
        for(int i = 1; i < 5; i++){
            if(!board[i][y].equals(turn))
                break;
            if(i == 4){
                return winMessage(turn);
            }
        }

        if(x == y){
            for(int i = 0; i < 4; i++){
                if(!board[i][i].equals(turn))
                    break;
                if(i == 3){
                    return winMessage(turn);
                }
            }
        }
        if(x == y){
            for(int i = 1; i < 5; i++){
                if(!board[i][i].equals(turn))
                    break;
                if(i == 4){
                    return winMessage(turn);
                }
            }
        }

        if(x + y == 4){
            for(int i = 0; i < 4; i++){
                if(!board[i][4-i].equals(turn))
                    break;
                if(i == 3){
                    return winMessage(turn);
                }
            }
        }
        if(x + y == 4){
            for(int i = 1; i < 5; i++){
                if(!board[i][4-i].equals(turn))
                    break;
                if(i == 4){
                    return winMessage(turn);
                }
            }
        }

        if (x == y-1){
            for(int i = 0; i < 4; i++){
                if(!board[i][i+1].equals(turn))
                    break;
                if(i == 3){
                    return winMessage(turn);
                }
            }
        }
        if (x-1 == y){
            for(int i = 0; i < 4; i++){
                if(!board[i+1][i].equals(turn))
                    break;
                if(i == 3){
                    return winMessage(turn);
                }
            }
        }

        if(x + y == 5){
            for(int i = 1; i < 5; i++){
                if(!board[i][5-i].equals(turn))
                    break;
                if(i == 4){
                    return winMessage(turn);
                }
            }
        }
        if(x + y == 3){
            for(int i = 0; i < 4; i++){
                if(!board[i][3-i].equals(turn)) {
                    break;
                }
                if(i == 3){
                    return winMessage(turn);
                }
            }
        }

        if(column1Counter == 0 && column2Counter == 0 && column3Counter == 0
        && column4Counter == 0 && column5Counter == 0){
            return GameState.DRAW;
        }

        return GameState.NOT_FINISHED;
    }
    private static void lockDown(List<Button> buttons)
    {
        for (Button button:buttons) {
            button.setEnabled(false);
        }
    }

    public Connect4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connect4, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawBoard();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttons.add((Button) view.findViewById(R.id.button10));
        buttons.add((Button) view.findViewById(R.id.button11));
        buttons.add((Button) view.findViewById(R.id.button12));
        buttons.add((Button) view.findViewById(R.id.button13));
        buttons.add((Button) view.findViewById(R.id.button14));
        buttons.add((Button) view.findViewById(R.id.button15));
        buttons.add((Button) view.findViewById(R.id.button16));
        buttons.add((Button) view.findViewById(R.id.button17));
        buttons.add((Button) view.findViewById(R.id.button18));
        buttons.add((Button) view.findViewById(R.id.button19));
        buttons.add((Button) view.findViewById(R.id.button20));
        buttons.add((Button) view.findViewById(R.id.button21));
        buttons.add((Button) view.findViewById(R.id.button22));
        buttons.add((Button) view.findViewById(R.id.button23));
        buttons.add((Button) view.findViewById(R.id.button24));
        buttons.add((Button) view.findViewById(R.id.button25));
        buttons.add((Button) view.findViewById(R.id.button26));
        buttons.add((Button) view.findViewById(R.id.button27));
        buttons.add((Button) view.findViewById(R.id.button28));
        buttons.add((Button) view.findViewById(R.id.button29));
        buttons.add((Button) view.findViewById(R.id.button30));
        buttons.add((Button) view.findViewById(R.id.button31));
        buttons.add((Button) view.findViewById(R.id.button32));
        buttons.add((Button) view.findViewById(R.id.button33));
        buttons.add((Button) view.findViewById(R.id.button34));
        if (savedInstanceState != null){
            for (int i = 0;i < 5;i++) {
                for (int j = 0; j < 5; j++) {
                    if (!board[i][j].equals(TicTacToeFragment.Input.E)) {
                        if (board[i][j].equals(Input.R)){
                            buttons.get((i * 5) + j).setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                        if (board[i][j].equals(Input.B)){
                            buttons.get((i * 5) + j).setBackgroundColor(Color.parseColor("#3F51B5"));
                        }
                    }
                }
            }
        }
        setOnClick();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        SaveData.getInstance().setConnect4(board);
    }

    private void setOnClick(){
        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (column1Counter > 0){
                    buttons.get(column1Counter-1).setBackgroundColor(colour());
                    board[0][column1Counter-1] = turn;
                    column1Counter--;
                    if (!checkState(0,column1Counter).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(0, column1Counter)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case R_WINS:
                                Toast.makeText(getContext(), "Player Red Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case B_WINS:
                                Toast.makeText(getContext(), "Player Blue Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }
            }
        };
        for (int i = 0;i < 5;i++){
            buttons.get(i).setOnClickListener(listener1);
        }
        View.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (column2Counter > 0){
                    buttons.get(4 + column2Counter).setBackgroundColor(colour());
                    board[1][column2Counter-1] = turn;
                    column2Counter--;
                    if (!checkState(1,column2Counter).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(1, column2Counter)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case R_WINS:
                                Toast.makeText(getContext(), "Player Red Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case B_WINS:
                                Toast.makeText(getContext(), "Player Blue Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }
            }
        };
        for (int i = 5;i < 10;i++){
            buttons.get(i).setOnClickListener(listener2);
        }
        View.OnClickListener listener3 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (column3Counter > 0){
                    buttons.get(9 + column3Counter).setBackgroundColor(colour());
                    board[2][column3Counter-1] = turn;
                    column3Counter--;
                    if (!checkState(2,column3Counter).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(2, column3Counter)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case R_WINS:
                                Toast.makeText(getContext(), "Player Red Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case B_WINS:
                                Toast.makeText(getContext(), "Player Blue Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }
            }
        };
        for (int i = 10;i < 15;i++){
            buttons.get(i).setOnClickListener(listener3);
        }
        View.OnClickListener listener4 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (column4Counter > 0){
                    buttons.get(14 + column4Counter).setBackgroundColor(colour());
                    board[3][column4Counter-1] = turn;
                    column4Counter--;
                    if (!checkState(3,column4Counter).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(3, column4Counter)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case R_WINS:
                                Toast.makeText(getContext(), "Player Red Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case B_WINS:
                                Toast.makeText(getContext(), "Player Blue Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }
            }
        };
        for (int i = 15;i < 20;i++){
            buttons.get(i).setOnClickListener(listener4);
        }
        View.OnClickListener listener5 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (column5Counter > 0){
                    buttons.get(19 + column5Counter).setBackgroundColor(colour());
                    board[4][column5Counter-1] = turn;
                    column5Counter--;
                    if (!checkState(4,column5Counter).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(4, column5Counter)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case R_WINS:
                                Toast.makeText(getContext(), "Player Red Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case B_WINS:
                                Toast.makeText(getContext(), "Player Blue Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }
            }
        };
        for (int i = 20;i < 25;i++){
            buttons.get(i).setOnClickListener(listener5);
        }
    }
}
