package com.example.a2playergames;

public class SaveData {
    private static final SaveData ourInstance = new SaveData();
    private TicTacToeFragment.Input[][] ticTacToe = new TicTacToeFragment.Input[3][3];
    private Connect4Fragment.Input[][] connect4 = new Connect4Fragment.Input[5][5];

    public static SaveData getInstance() {
        return ourInstance;
    }

    private SaveData() {
    }

    public void resetData(){
        for (int i = 0;i < 5;i++) {
            for (int j = 0;j < 5;j++) {
                connect4[i][j] = Connect4Fragment.Input.E;
            }
        }
        for (int i = 0;i < 3;i++)
        {
            for (int j = 0;j < 3;j++)
            {
                ticTacToe[i][j] = TicTacToeFragment.Input.E;
            }
        }
        Connect4Fragment.resetMoveCount();
        TicTacToeFragment.resetMoveCount();
    }

    public void setTicTacToe(TicTacToeFragment.Input[][] ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public void setConnect4(Connect4Fragment.Input[][] connect4) {
        this.connect4 = connect4;
    }

    public TicTacToeFragment.Input[][] getTicTacToe() {
        return ticTacToe;
    }

    public Connect4Fragment.Input[][] getConnect4() {
        return connect4;
    }
}
