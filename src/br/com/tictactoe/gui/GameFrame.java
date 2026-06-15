package br.com.tictactoe.gui;

import javax.swing.*;

public class GameFrame extends JFrame {
    GamePanel panel = new GamePanel();
    public GameFrame() {
        this.setTitle("Tic-Tac-Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);
    }

}
