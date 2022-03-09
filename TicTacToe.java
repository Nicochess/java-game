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
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Roboto",Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Jogo da Velha");

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        title_panel.add(textfield);
        frame.add(title_panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void firstTurn(){

    }

    public void check(){

    }

    public void xWins(int a, int b,int c){

    }

    public void oWins(int a, int b,int c){

    }

}
