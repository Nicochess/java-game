import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    //Set a random player to start the game
    Random random = new Random();

    JFrame frame = new JFrame();

    //Displays a title in the game
    JPanel title_panel = new JPanel();

    //Container to displays button to play the game
    JPanel button_panel = new JPanel();

    //Shows a message to the players
    JLabel textfield = new JLabel();

    //Displays the nine buttons to play
    JButton[] buttons = new JButton[9];

    //Boolean control to the players turn
    boolean player1_turn;

    //This is a constructor
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,25,25));
        textfield.setFont(new Font("Roboto",Font.BOLD, 55));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Jogo da Velha");

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,700,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Roboto", Font.BOLD, 100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 9; i++){
            if(e.getSource() == buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        textfield.setText("Vez do O");
                        player1_turn = !player1_turn;
                        check();
                    }
                } else {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0, 0,255));
                        buttons[i].setText("O");
                        textfield.setText("Vez do X");
                        player1_turn = !player1_turn;
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if(random.nextInt(2) == 0){
            player1_turn = true;
            textfield.setText("Vez do X");
        } else {
            player1_turn = false;
            textfield.setText("Vez do O");
        }
    }

    public void check(){
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }
        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }


        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }
        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }
        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }
        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }
        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }

    public void xWins(int a, int b,int c){
        setWinnerChoice(a,b,c);
        textfield.setText("X venceu!");
    }

    public void oWins(int a, int b,int c){
        setWinnerChoice(a,b,c);
        textfield.setText("O venceu!");
    }

    public void restartGame(){
        for(int i = 0; i < 9; i++){
            buttons[i].setBackground(new JButton().getBackground());
            buttons[i].setEnabled(true);
            buttons[i].setText("");
        }
    }

    public void setWinnerChoice(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
    }

}
