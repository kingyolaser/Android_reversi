package com.example.user.othello;

/**
 * Created by USER on 2015/09/20.
 */
public class Ban {
    private static Ban instance = new Ban();
    public static Ban getInstance(){
        return instance;
    }

    //----------------
    static final int EMPTY = 0;
    static final int BLACK = 1;
    static final int WHITE = 2;
    static final int WALL = 3;
    static final int WIDTH = 8;

    //----------------
    int ban[][] = new int[WIDTH+2][WIDTH+2];
    int teban = BLACK;
    //----------------

    private Ban(){
        init();
    }

    public void init(){
        for( int i=1; i<=WIDTH; i++) {
            for( int j=1; j<=WIDTH; j++){
                ban[i][j] = EMPTY;
            }
        }
        for( int i=0; i<10; i++){
            ban[i][0] = WALL;
            ban[i][10-1] = WALL;
            ban[0][i] = WALL;
            ban[10-1][i] = WALL;
        }
        teban = BLACK;
    }

    public boolean put(int x, int y){
        if( !(1<=x && x<=WIDTH)){return false;}
        if( !(1<=y && y<=WIDTH)){return false;}
        if( ban[x][y] != EMPTY){return false;}

        return true;
    }
}
