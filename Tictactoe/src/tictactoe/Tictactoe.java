package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tictactoe {
//    1 2 3 
//    4 5 6 
//    7 8 9
    ArrayList<Integer> player_x = new ArrayList<Integer>();
    ArrayList<Integer> player_o = new ArrayList<Integer>();
    ArrayList<Integer> a = new ArrayList<>();
    int[][] win = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    JButton[] list;
    ArrayList<JButton> btnList = new ArrayList<JButton>();
    JFrame f;
    String s = "X";
    JLabel l;
    boolean game = true;
    Font font = new Font(Font.DIALOG_INPUT, Font.BOLD, 50);
    void btn(int x, int y, int width, int height, JButton button, int num){
        button.setBounds(x, y, width, height);
        button.setBackground(Color.white);
        button.setBorderPainted(false);
        button.setFont(font);
        btnList.add(button);
        
        f.add(button);
         if(num==0){
           button.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
           button.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent ae){
                   for(int i=0; i<btnList.size();i++){
                       btnList.get(i).setLabel("");
                       s = "X";
                       game = true;
                       player_x.clear();
                       player_o.clear();
                       button.setLabel("Reset");
                       l.setText("X's Turn");
                   }
               }
           });
        }
         else{
                button.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent ae){
            if(game){
                      
                    if(s=="X"){
                      if("".equals(button.getLabel())){
                        button.setLabel(s);
                        player_x.add(num);
                        s="O";
                        l.setText(s+ "'s Turn");
                      }

                    }else{
                      if("".equals(button.getLabel())){
                        button.setLabel(s);
                        player_o.add(num);
                        s="X";
                        l.setText(s+ "'s Turn");
                      }

                    }

                    for(int i=0;i<8;i++){
                        int j = 0;
                            if(player_x.contains(win[i][j])&&player_x.contains(win[i][j+1])&&player_x.contains(win[i][j+2])){
                                l.setText("X Wins");
                                game = false;
                            }
                            if(player_o.contains(win[i][j])&&player_o.contains(win[i][j+1])&&player_o.contains(win[i][j+2])){
                                l.setText("O Wins");
                                game = false;
                            }

                    }

                  }
             }
                });
         }
      
    }



    Tictactoe(){
        f = new JFrame();
        f.setSize(500, 500);
        f.getContentPane().setBackground(Color.DARK_GRAY);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l = new JLabel("X's Turn");
        l.setBounds(150, 330, 200, 100);
        l.setFont(new Font(Font.DIALOG,Font.BOLD,25));
        l.setForeground(Color.white);
        f.add(l);
        
        btn(50, 70, 70, 70, new JButton() , 1);
        btn(150, 70, 70, 70, new JButton(), 2);
        btn(250, 70, 70, 70, new JButton(), 3);
        btn(50, 160, 70, 70, new JButton(), 4);
        btn(150, 160, 70, 70, new JButton(), 5);
        btn(250, 160, 70, 70, new JButton(), 6);
        btn(50, 250, 70, 70, new JButton(), 7);
        btn(150, 250, 70, 70, new JButton(), 8);
        btn(250, 250, 70, 70, new JButton(), 9);
        btn(10, 10, 100, 50, new JButton("Reset"), 0);
        
    }
    public static void main(String[] args) {
        new Tictactoe();
    }
    
}
