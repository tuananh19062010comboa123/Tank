package base;

import base.renderer.SingleImageRenderer;
import base.wall.Brick;
import base.wall.Forest;
import base.wall.Stone;
import base.wall.Water;
import tklibs.SpriteUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Background extends GameObject {

    private int tileSize;
    private int[][] map;
    private int mapWidth;
    private int mapHeight;
    private ArrayList<Image> imagesSub;

    public Background(){
        tileSize = 28;
        //String s = "assets\\maps\\testmap.txt";
        String s = "assets\\maps\\map_2.txt";
        this.tileSize = tileSize;
        try {
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

        }
        //getSubImage(String imageName, int width, int height, int numberImage)
        imagesSub = getSubImage("spawn",32,32,4);
            System.out.println(imagesSub);
       /* for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {
                int rc = map[row][col];
                if (rc == 0) {
                    Brick edee = (Brick) GameObject.recycle(Brick.class);
                    edee.position = new Vector2D(col * tileSize,row * tileSize);
                    edee.destroy();
                }

                if (rc == 1) {
                    Brick brick = (Brick) GameObject.recycle(Brick.class);

                    brick.position = new Vector2D(col * tileSize,row * tileSize);

                    GameObject.newGameObjects.add(brick);
                }
                if (rc == 2) {
                    Stone stone = (Stone)GameObject.recycle(Stone.class);
                    stone.position = new Vector2D(col * tileSize,row * tileSize);
                    GameObject.newGameObjects.add(stone);
                }
                if (rc == 3) {
                    Forest forest = (Forest)GameObject.recycle(Forest.class);
                    forest.position = new Vector2D(col * tileSize,row * tileSize);
                    GameObject.newGameObjects.add(forest);
                }
                if (rc == 5) {
                    Water water = (Water)GameObject.recycle(Water.class);
                    water.position = new Vector2D(col * tileSize,row * tileSize);
                    GameObject.newGameObjects.add(water);
                }

                // g.fillRect( col * tileSize,  row * tileSize, tileSize, tileSize);
            }*/
        }

   /* @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        for(int i = 0; i < Settings.COL_COUNT; i++) {
            g.drawLine(i * Settings.WAY_SIZE, 0
                    , i * Settings.WAY_SIZE, Settings.SCREEN_HEIGHT);
        }
        for(int i = 0; i < Settings.ROW_COUNT; i++) {
            g.drawLine(0, i * Settings.WAY_SIZE
                    , Settings.SCREEN_WIDHT, i * Settings.WAY_SIZE);
        }
    }*/

    @Override
    public void render(Graphics g) {
        BufferedImage imageBackgroungBaclk = SpriteUtils.loadImage("assets/maps/item_built_map/BlackSquare.png");
        BufferedImage imageBrick = SpriteUtils.loadImage("assets/maps/item_built_map/BricksOrig.png");
        BufferedImage imageForest = SpriteUtils.loadImage("assets/maps/item_built_map/ForestOrig.png");
        BufferedImage imageDa = SpriteUtils.loadImage("assets/maps/item_built_map/ConcreteOrig.png");
        BufferedImage imageWater = SpriteUtils.loadImage("assets/maps/item_built_map/WaterOrig.png");

        BufferedImage imageWeagleLeft1 = SpriteUtils.loadImage("assets/maps/item_built_map/eagle/left1.PNG");
        BufferedImage imageWeagleLeft2 = SpriteUtils.loadImage("assets/maps/item_built_map/eagle/left2.PNG");
        BufferedImage imageWeagleRight1 = SpriteUtils.loadImage("assets/maps/item_built_map/eagle/right1.PNG");
        BufferedImage imageWeagleRight2 = SpriteUtils.loadImage("assets/maps/item_built_map/eagle/right2.PNG");

        super.render(g);
        for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {
                int rc = map[row][col];
               if (rc == 0) {
                   g.drawImage(imageBackgroungBaclk, col * tileSize,row * tileSize,null);
                 //  g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                   // g.setColor(Color.BLACK);
               }
                if (rc == 1) {
                   // g.setColor(Color.blue);
                    g.drawImage(imageBrick, col * tileSize,row * tileSize,null);
                }
                if (rc == 2) {
                    // g.setColor(Color.blue);
                    g.drawImage(imageDa, col * tileSize,row * tileSize,null);
                }
                if (rc == 3) {
                    // g.setColor(Color.blue);
                    g.drawImage(imageForest, col * tileSize,row * tileSize,null);
                }
                if (rc == 5) {
                    // g.setColor(Color.blue);
                    g.drawImage(imageWater, col * tileSize,row * tileSize,null);
                }
                if (rc == 6) {
                    // g.setColor(Color.blue);
                    g.drawImage(imageWeagleLeft1, col * tileSize,row * tileSize,null);
                }
                if (rc == 7) {
                    // g.setColor(Color.blue);
                    g.drawImage(imageWeagleRight1, col * tileSize,row * tileSize,null);
                }if (rc == 8) {
                    // g.setColor(Color.blue);
                    g.drawImage(imageWeagleLeft2, col * tileSize,row * tileSize,null);
                }if (rc == 9) {
                    // g.setColor(Color.blue);
                    g.drawImage(imageWeagleRight2, col * tileSize,row * tileSize,null);
                }




               // g.fillRect( col * tileSize,  row * tileSize, tileSize, tileSize);
            }
        }

    }
    //function cut image
    public ArrayList<Image> getSubImage(String imageName, int width, int height, int numberImage){
        ArrayList<Image> arrResults = new ArrayList<>();
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getResourceAsStream("/IMAGES/"+imageName+".png"));
            BufferedImage subImage;
            for (int i =0 ; i< numberImage;i++){
                subImage = bufferedImage.getSubimage(0,i*height,width,height);
                arrResults.add(subImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrResults;
    }

}
