package base.scene;

import base.Background;
import base.GameObject;
import base.Settings;
import base.player.Tank;
import base.wall.Wall;

public class SceneStage1 extends Scene {// khoi tao doi tuong o day
    @Override
    public void destroy() {
        GameObject.clearAll();
    }

    @Override
    public void init() {

        GameObject.recycle(Background.class);
        this.tank = GameObject.recycle(Tank.class);
        tank.position.set(280,308);
        System.out.println("tank : "+tank.position);
       /*for(int i =0 ; i< 2 ; i++){
           Wall wall = GameObject.recycle(Wall.class);
           wall.position.set(154 + Settings.WAY_SIZE, 70 + Settings.WAY_SIZE);// 168 - 84 : meo hiu sao phai tru di 0.5.wayzize
       }*/

        Wall wall = GameObject.recycle(Wall.class);
        wall.position.set(154,70);// 168 - 84 : meo hiu sao phai tru di 0.5.wayzize

        Wall wall1 = GameObject.recycle(Wall.class);
        wall1.position.set(154+Settings.WAY_SIZE,70);

        Wall wall2 = GameObject.recycle(Wall.class);
        wall2.position.set(154,70+Settings.WAY_SIZE);

        Wall wall3 = GameObject.recycle(Wall.class);
        wall3.position.set(154+Settings.WAY_SIZE,70+Settings.WAY_SIZE);


    }
}
