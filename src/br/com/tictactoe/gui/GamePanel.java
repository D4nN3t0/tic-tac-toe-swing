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
    boolean gameOver = false;
    JButton[] btn = new JButton[9];

    GamePanel() {
        this.setLayout(new GridLayout(3, 3));
        this.setBackground(Color.darkGray);

        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton();
            btn[i].setBackground(Color.white);
            btn[i].addActionListener(this);
            this.add(btn[i]);
        }
    }

    public void checkWinner() {
        if (checkLine(0, 1, 2)) {
            System.out.println(btn[0].getText() + " venceu!");
            gameOver = true;
        } else if (checkLine(3, 4, 5)) {
            System.out.println(btn[3].getText() + " venceu!");
            gameOver = true;
        } else if (checkLine(6, 7, 8)) {
            System.out.println(btn[6].getText() + " venceu!");
            gameOver = true;
        } else if (checkLine(0, 3, 6)) {
            System.out.println(btn[0].getText() + " venceu!");
            gameOver = true;
        } else if (checkLine(1, 4, 7)) {
            System.out.println(btn[1].getText() + " venceu!");
            gameOver = true;
        } else if (checkLine(2, 5, 8)) {
            System.out.println(btn[2].getText() + " venceu!");
            gameOver = true;
        } else if (checkLine(0, 4, 8)) {
            System.out.println(btn[0].getText() + " venceu!");
            gameOver = true;
        } else if (checkLine(2, 4, 6)) {
            System.out.println(btn[2].getText() + " venceu!");
            gameOver = true;
        }
    }

    public boolean checkLine(int a, int b, int c) {
        return !btn[a].getText().isEmpty() &&
                btn[a].getText().equals(btn[b].getText()) &&
                btn[b].getText().equals(btn[c].getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        if (gameOver) {
            return;
        }
        if (clickedButton.getText().isEmpty()) {
            clickedButton.setText(currentPlayer.getSymbol());
            if (currentPlayer == playerX) {
                currentPlayer = playerO;
                checkWinner();
            } else {
                currentPlayer = playerX;
                checkWinner();
            }
        }
    }
}
