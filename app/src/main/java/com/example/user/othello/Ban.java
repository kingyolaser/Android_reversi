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
        ban[4][4] = WHITE;
        ban[5][5] = WHITE;
        ban[4][5] = BLACK;
        ban[5][4] = BLACK;
    }

    public int getAite(int me){
        return BLACK+WHITE - me;
    }

    public boolean put(int x, int y){
        if( !(1<=x && x<=WIDTH)){return false;}
        if( !(1<=y && y<=WIDTH)){return false;}
        if( ban[x][y] != EMPTY){return false;}

        int aite = getAite(teban);
        boolean flipflg = false;
        for( int dx=-1; dx<=1; dx++){
            for( int dy=-1; dy<=1; dy++){
                for(int d=1;;d++){
                    if(ban[x+dx*d][y+dy*d]==aite){
                        continue;
                    }else if(ban[x+dx*d][y+dy*d]==teban && d>1){
                        //flip!
                        for(int i=1; i<d; i++){
                            ban[x+dx*i][y+dy*i] = teban;
                            flipflg = true;
                        }
                        break;
                    }else{
                        break;
                    }
                }
            }
        }
        if( flipflg ){
            ban[x][y] = teban;
        }
        return true;
    }
}
