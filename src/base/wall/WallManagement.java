package base.wall;

import base.GameObject;
import base.Vector2D;
import base.player.Tank;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class WallManagement extends GameObject {
    public WallManagement(){
        int mapWidth=0;
        int mapHeight=0;
        int [][] map=null;
        int tileSize = 28;
        try {
            String s = "assets\\maps\\map_2.txt";
            BufferedReader br = new BufferedReader(new FileReader(s));
            String x,y;
            x = br.readLine();
            y = br.readLine();
            mapWidth = Integer.parseInt(x);
            mapHeight = Integer.parseInt(y);
            map = new int[mapHeight][mapWidth];
            String delimeter = " ";
            for(int row =0; row < mapHeight ;row++){
                String line = br.readLine();
                String[] tokens = line.split(delimeter);
                for(int col = 0;col<mapWidth;col++){
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

            for (int row = 0; row < mapHeight; row++) {
                for (int col = 0; col < mapWidth; col++) {
                    int rc = map[row][col];
                if (rc == 0) {
                    Brick edee = (Brick) GameObject.recycle(Brick.class);
                    edee.destroy();
                }

                    if (rc == 1) {
                        Brick brick = (Brick) GameObject.recycle(Brick.class);

                        brick.position = new Vector2D(col * tileSize,row * tileSize);

                       GameObject.gameObjects.add(brick);
                    }
                    if (rc == 2) {
                        Stone stone = (Stone)GameObject.recycle(Stone.class);
                        stone.position = new Vector2D(col * tileSize,row * tileSize);
                        GameObject.gameObjects.add(stone);
                    }
                    if (rc == 3) {
                        Forest forest = (Forest)GameObject.recycle(Forest.class);
                        forest.position = new Vector2D(col * tileSize,row * tileSize);
                        GameObject.gameObjects.add(forest);
                    }
                    if (rc == 5) {
                        Water water = (Water)GameObject.recycle(Water.class);
                        water.position = new Vector2D(col * tileSize,row * tileSize);
                        GameObject.gameObjects.add(water);
                    }

                    // g.fillRect( col * tileSize,  row * tileSize, tileSize, tileSize);
                }
            }




    }
}
