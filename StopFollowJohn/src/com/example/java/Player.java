package com.example.java;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import static com.googlecode.lanterna.input.Key.Kind.*;
/**
 * Created by bjorn on 1/2/2018.
 */
public class Player {
    public void playerMove() throws InterruptedException{
        int playerwidth = 50;
        int playerheight = 20;
        Screen screen = TerminalFacade.createScreen();
        screen.startScreen();
        screen.refresh();

        boolean keepRunning = true;
        while (keepRunning) {
            Key key = screen.readInput();

            while (key == null) {
                key = screen.readInput();
            }
            System.out.println("Key pressed" + key.getKind().toString());

            if (key.getKind() == ArrowDown) {
                while (playerheight < screen.getTerminalSize().getRows()-1) {
                    playerheight++;
                    screen.clear();
                    screen.putString(playerwidth, playerheight, "X", Terminal.Color.WHITE, Terminal.Color.BLACK);
                    screen.refresh();
                    Thread.sleep(30);
                    break;

                }
            } else if (key.getKind() == ArrowUp) {
                while (playerheight > 0) {
                    playerheight--;
                    screen.clear();
                    screen.putString(playerwidth, playerheight, "X", Terminal.Color.WHITE, Terminal.Color.BLACK);
                    screen.refresh();
                    Thread.sleep(30);
                    break;

                }
            } else if (key.getKind() == ArrowLeft) {
                while (playerwidth > 0) {
                    playerwidth--;
                    screen.clear();
                    screen.putString(playerwidth, playerheight, "X", Terminal.Color.WHITE, Terminal.Color.BLACK);
                    screen.refresh();
                    Thread.sleep(10);
                    break;
                }
            } else if (key.getKind() == ArrowRight) {
                while (playerwidth < screen.getTerminalSize().getColumns() - 1) {
                    playerwidth++;
                    screen.clear();
                    screen.putString(playerwidth, playerheight, "X", Terminal.Color.WHITE, Terminal.Color.BLACK);
                    ;
                    screen.refresh();
                    Thread.sleep(10);
                    break;
                }
            }
        }
    }
}
