package game;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.event.KeyEventPress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;
  /*  public static float checkMoveUp; // tạm ht[ì để <=8 vì nếu để bằng 4 thì ít ra !! mà đúng ra để bằng 4 mới hợp lý
    public static float checkMoveDown;
    public static float checkMoveLeft;
    public static float checkMoveRight;*/
    public GameWindow() {
        //setup window
        //this.setSize(Settings.SCREEN_WIDHT, Settings.SCREEN_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupEventListtener();
        //init game
        this.canvas = new GameCanvas();
        this.canvas.setPreferredSize(new Dimension(Settings.SCREEN_WIDHT, Settings.SCREEN_HEIGHT));//size ko tinh sisegame window
        this.add(canvas);
        this.setVisible(true);
        this.pack();
    }

    private void setupEventListtener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                KeyEventPress.isAnyKeyPress = true;//
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = true;
                }
               else if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = true;
                }
               else if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = true;
                }
               else if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = true;
                }
               else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = false;//
                if(e.getKeyCode() == KeyEvent.VK_W) {
                   KeyEventPress.isUpPress = false;
                    // quan trong v l l l l lấy ra ị trí thăng tank trong gameObject
                    /*for(int  i = 0 ; i< GameObject.gameObjects.size();i++){
                        System.out.println("Object  "+ i + " :"  + GameObject.gameObjects.get(i));
                    }*/

                    Vector2D current = GameObject.gameObjects.get(1).position;
                   // Vector2D current = this.position;// vi tri hien tai sau khi di chuyen
                    // cai dong ma min mun di chuyen dung lane
                    int newRow  = (int) (current.y/28);
                    // pixel tang len de sao cho dung dong mong mun
                    float pixelNedd = current.y - newRow * 28;//
                    System.out.println("pixel : "+pixelNedd);
                    /*float x = current.y / 28;*/

                    // bien checkMoveUp
                 /*   checkMoveUp = 28 - pixelNedd;
                    System.out.println("checkMoveUp : "+checkMoveUp);
                    if(checkMoveUp <= 8.0 ){
                        return;
                    }*/

                    if(pixelNedd != 0 ){// muốn hoãn nhảy mà chưa hoãn được
                            for(int i = 0;i<pixelNedd;i++){
                                GameObject.gameObjects.get(1).position.addThis(0,-1);
                            }
                    }
                }
               else if(e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                    Vector2D current = GameObject.gameObjects.get(1).position;
                    int newCol  = (int) (current.x/28);
                    float pixelNedd =  current.x - newCol * 28 ;

                    // bien checkMoveLeft
               /*     checkMoveLeft = 28 - pixelNedd;
                  //  System.out.println("checkMoveLeft : "+checkMoveLeft);
                    if(checkMoveLeft <= 8.0 ){
                        return;
                    }*/

                    if(pixelNedd != 0 ){
                        for(int i = 0;i<pixelNedd;i++){
                            GameObject.gameObjects.get(1).position.addThis(-1,0);
                        }
                    }
                }
               else if(e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;

                    Vector2D current = GameObject.gameObjects.get(1).position;
                    int newRow  = (int) (current.y/28);
                    float pixelNedd = (newRow + 1) * 28 - current.y;// bang dong hien tai + 1 * 28 - position hien tai

                    // bien checkMoveDown
                 /*   checkMoveDown = 28 - pixelNedd;
                    System.out.println("checkMoveDown : "+checkMoveDown);
                    if(checkMoveDown <= 8.0 ){
                        return;
                    }*/
                    if(pixelNedd != 0 ){
                        for(int i = 0;i<pixelNedd;i++){
                            GameObject.gameObjects.get(1).position.addThis(0,+1);
                        }
                    }
                }
               else if(e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;

                    Vector2D current = GameObject.gameObjects.get(1).position;
                    int newCol  = (int) (current.x/28);
                    float pixelNedd = (newCol + 1) * 28 - current.x;

                    // bien checkMoveRight
                  /*  checkMoveRight = 28 - pixelNedd;
                    //  System.out.println("checkMoveRight : "+checkMoveRight);
                    if(checkMoveLeft <= 8.0 ){
                        return;
                    }*/
                    if(pixelNedd != 0 ){
                        for(int i = 0;i<pixelNedd;i++){
                            GameObject.gameObjects.get(1).position.addThis(+1,0);
                        }
                    }
                }
               else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = false;
                }
            }
        });
    }

    public void gameLoop() {
        long delay = 1000 / 60;
        long lastTime = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime > delay) {
                canvas.run(); //runAll()
                canvas.render(); // render all to backBuffer
                this.repaint(); // render backBuffer to game
                lastTime = currentTime;
            }
        }
    }
}
