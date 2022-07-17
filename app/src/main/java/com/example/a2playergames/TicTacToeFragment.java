package com.example.a2playergames;


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
public class TicTacToeFragment extends Fragment {

    private List<Button> buttons = new ArrayList<>();
    private static Input turn = Input.X;
    private static Input[][] board = new Input[3][3];
    private static int moveCount = 0;

    public enum Input {
        E,X,O
    }
    private enum GameState {
        DRAW,O_WINS,X_WINS,NOT_FINISHED
    }

    public TicTacToeFragment() {
        // Required empty public constructor
    }

    public static void resetMoveCount(){
        moveCount = 0;
        turn = Input.X;
    }
    private static void switchTurn()
    {
        if (turn.equals(Input.X))
        {
            turn = Input.O;
        }else
        {
            turn = Input.X;
        }
    }

    public static void drawBoard()
    {
       board = SaveData.getInstance().getTicTacToe();
    }

    private static void input(int i,int j) throws Exception
    {
        if (i >= 3 || j >= 3){
            throw new Exception("Unsupported Input");
        }else {
            if (!board[i][j].equals(Input.E)) {
                throw new Exception("Place Is Occupied");
            } else {
                board[i][j] = turn;
            }
        }
    }

    private static GameState checkState(int x,int y)
    {
        for(int i = 0; i < 3; i++){
            if(!board[x][i].equals(turn))
                break;
            if(i == 2){
                return winMessage(turn);
            }
        }

        for(int i = 0; i < 3; i++){
            if(!board[i][y].equals(turn))
                break;
            if(i == 2){
                return winMessage(turn);
            }
        }

        if(x == y){
            for(int i = 0; i < 3; i++){
                if(!board[i][i].equals(turn))
                    break;
                if(i == 2){
                    return winMessage(turn);
                }
            }
        }

        if(x + y == 2){
            for(int i = 0; i < 3; i++){
                if(!board[i][2-i].equals(turn))
                    break;
                if(i == 2){
                    return winMessage(turn);
                }
            }
        }

        if(moveCount == 9){
            return GameState.DRAW;
        }

        return GameState.NOT_FINISHED;
    }

    private static GameState winMessage(Input player)
    {
        if (player.equals(Input.X)){
            return GameState.X_WINS;
        }else
        {
            return GameState.O_WINS;
        }
    }

    private static void lockDown(List<Button> buttons)
    {
        for (Button button:buttons) {
            button.setEnabled(false);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawBoard();
        if (savedInstanceState != null){
            switch (savedInstanceState.getInt("TURN")){
                case 0:
                    turn = Input.O;
                    break;
                case 1:
                    turn = Input.X;
                    break;
            }
            moveCount = savedInstanceState.getInt("MOVE_COUNT");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttons.add((Button) view.findViewById(R.id.button));
        buttons.add((Button) view.findViewById(R.id.button2));
        buttons.add((Button) view.findViewById(R.id.button3));
        buttons.add((Button) view.findViewById(R.id.button4));
        buttons.add((Button) view.findViewById(R.id.button5));
        buttons.add((Button) view.findViewById(R.id.button6));
        buttons.add((Button) view.findViewById(R.id.button7));
        buttons.add((Button) view.findViewById(R.id.button8));
        buttons.add((Button) view.findViewById(R.id.button9));
        if (savedInstanceState != null){
            for (int i = 0;i < 3;i++) {
                for (int j = 0; j < 3; j++) {
                    if (!board[i][j].equals(Input.E)) {
                        buttons.get((i * 3) + j).setText(board[i][j].toString());
                        buttons.get((i * 3) + j).setEnabled(false);
                    }
                }
            }
        }
        buttons.get(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(0).setText(turn.toString());
                    buttons.get(0).setEnabled(false);
                    input(0,0);
                    moveCount++;
                    if (!checkState(0,0).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(0, 0)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        buttons.get(1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(1).setText(turn.toString());
                    buttons.get(1).setEnabled(false);
                    input(1,0);
                    moveCount++;
                    if (!checkState(1,0).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(1, 0)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        buttons.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(2).setText(turn.toString());
                    buttons.get(2).setEnabled(false);
                    input(2,0);
                    moveCount++;
                    if (!checkState(2,0).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(2, 0)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        buttons.get(3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(3).setText(turn.toString());
                    buttons.get(3).setEnabled(false);
                    input(0,1);
                    moveCount++;
                    if (!checkState(0,1).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(0, 1)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        buttons.get(4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(4).setText(turn.toString());
                    buttons.get(4).setEnabled(false);
                    input(1,1);
                    moveCount++;
                    if (!checkState(1,1).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(1, 1)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        buttons.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(5).setText(turn.toString());
                    buttons.get(5).setEnabled(false);
                    input(2,1);
                    moveCount++;
                    if (!checkState(2,1).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(2, 1)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        buttons.get(6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(6).setText(turn.toString());
                    buttons.get(6).setEnabled(false);
                    input(0,2);
                    moveCount++;
                    if (!checkState(0,2).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(0, 2)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        buttons.get(7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(7).setText(turn.toString());
                    buttons.get(7).setEnabled(false);
                    input(1,2);
                    moveCount++;
                    if (!checkState(1,2).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(1, 2)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        buttons.get(8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    buttons.get(8).setText(turn.toString());
                    buttons.get(8).setEnabled(false);
                    input(2,2);
                    moveCount++;
                    if (!checkState(2,2).equals(GameState.NOT_FINISHED)) {
                        switch (checkState(2, 2)) {
                            case DRAW:
                                Toast.makeText(getContext(), "Draw!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case O_WINS:
                                Toast.makeText(getContext(), "Player O Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                            case X_WINS:
                                Toast.makeText(getContext(), "Player X Wins!", Toast.LENGTH_SHORT).show();
                                lockDown(buttons);
                                break;
                        }
                    }
                    switchTurn();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        SaveData.getInstance().setTicTacToe(board);
        outState.putInt("MOVE_COUNT",moveCount);
        int turnCode = 0;
        switch (turn){
            case O:
                turnCode = 0;
                break;
            case X:
                turnCode = 1;
                break;
        }
        outState.putInt("TURN",turnCode);
    }
}


