package com.example.anas.xogame;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class XOActivity extends AppCompatActivity {
    Button []buttons=new Button[9];
    TextView resulttext;
    ImageButton replay;
    Game startgame;
    void refreshbuttons(){
        for(int i=0;i<9;i++){
            buttons[i].setText(" ");
            buttons[i].setEnabled(true);
            resulttext.setText("");
        }
    }
    void updatebuttons(){
        for(int i=0;i<9;i++){
            if(startgame.board2[i]!=' '){
                buttons[i].setText(startgame.board2[i]);
                buttons[i].setEnabled(false);
            }
        }
    }

    private class Buttonclick implements View.OnClickListener{
        int location;
        Buttonclick(int i){
            location=i;
        }
        void dissableAllButtons(){
            for(int i=0;i<9;i++)
                buttons[i].setEnabled(false);
        }
        void replaythegame(){
            replay.setVisibility(View.VISIBLE);
        }
        @Override
        public void onClick(View v) {
             if(buttons[location].isEnabled()){
                 buttons[location].setText(startgame.getplayer());
                 if(startgame.getplayer()=="X")
                     buttons[location].setTextColor(Color.RED);
                 else
                     buttons[location].setTextColor(Color.GREEN);
                 startgame.play(location);
                 int happens=startgame.checkwin();
                 buttons[location].setEnabled(false);
                 if(happens==3){

                     return;
                 }
                 else
                  if(happens==0){
                     resulttext.setText(R.string.Xwin);
                      dissableAllButtons();
                      replaythegame();
                  }
                  else
                     if(happens==1){
                         resulttext.setText(R.string.Ywin);
                         dissableAllButtons();
                         replaythegame();
                     }
                     else {
                         resulttext.setText(R.string.draw);
                         replaythegame();
                     }

             }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xo);
        startgame=new Game();
       // char []saved=savedInstanceState.getCharArray("boardsaved");
        /*if(saved!=null){
            //startgame.board2= saved;
            //startgame.setboard();
            //updatebuttons();
        }*/




        buttons[0]=(Button)findViewById(R.id.button);
        buttons[1]=(Button)findViewById(R.id.button2);
        buttons[2]=(Button)findViewById(R.id.button3);
        buttons[3]=(Button)findViewById(R.id.button4);
        buttons[4]=(Button)findViewById(R.id.button5);
        buttons[5]=(Button)findViewById(R.id.button6);
        buttons[6]=(Button)findViewById(R.id.button7);
        buttons[7]=(Button)findViewById(R.id.button8);
        buttons[8]=(Button)findViewById(R.id.button9);
        resulttext=(TextView)findViewById(R.id.textView2);
        for(int i=0;i<9;i++)
            buttons[i].setOnClickListener(new Buttonclick(i));

        replay=(ImageButton)findViewById(R.id.replay);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startgame.clear();
                refreshbuttons();
                replay.setVisibility(View.INVISIBLE);
            }
        });
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharArray("boardsaved",startgame.board2);

    }


}
