package com.example.anas.xogame;

/**
 * Created by anas on 11/23/2015.
 */
public class Game {
    int player;
    char [][]board=new char[3][3];
    char [] board2=new char[9];
    Game(){
        player=0;
        clear();


    }
    void clear(){
        player=0;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j]=' ';

        for(int i=0;i<9;i++)
            board2[i]=' ';
    }
    void play(int location){
        int i=location/3;
        int j=location%3;

        if(player%2==0) {
            board[i][j] = 'x';
            board2[location]='x';
        }
        else{
            board[i][j]='o';
            board2[location]='o';
        }
        player++;
    }
    void setboard(){
        for(int i=0;i<9;i++){
            if(board2[i]!=' '){
                player++;
                board[i/3][i%3]=board2[i];
            }
            else
                board[i/3][i%3]=' ';

        }
    }
    int checkwin(){
        /*
          0 : x
          1 : o
          2 :draw
          3 :game not finished
         */
        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][0]=='x')
                return 0;
            if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]&&board[i][0]=='o')
                return 1;
        }
        for(int i=0;i<3;i++){
            if(board[0][i]==board[1][i]&&board[2][i]==board[1][i]&&board[0][i]=='x')
                return 0;
            if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]&&board[0][i]=='o')
                return 1;
        }
        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]=='x')
            return 0;
        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]=='o')
            return 1;
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[0][2]=='x')
            return 0;
        if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[0][2]=='o')
            return 1;
        if(player>=9)
            return 2;
        return 3;
    }
    String getplayer(){
        if(player%2==0)
            return "X";
        else
            return "O";
    }
}
