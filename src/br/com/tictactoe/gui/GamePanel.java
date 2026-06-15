package br.com.tictactoe.gui;

import br.com.tictactoe.model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    Player playerX = new Player("X");
    Player playerO = new Player("O");
    Player currentPlayer = playerX;
    GamePanel() {
        this.setLayout(new GridLayout(3,3));
        this.setBackground(Color.darkGray);
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton();
            btn.setBackground(Color.white);
            btn.addActionListener(this);
            this.add(btn);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (clickedButton.getText().isEmpty()) {
            clickedButton.setText(currentPlayer.getSymbol());
            if (currentPlayer == playerX) {
                currentPlayer = playerO;
            } else {
                currentPlayer = playerX;
            }
        }
    }
}
