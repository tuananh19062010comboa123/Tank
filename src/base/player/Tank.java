package base.player;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.counter.FrameCounter;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;
import game.GameWindow;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Tank extends GameObject {//tuong duong SnakePart
    BoxCollider collider;
    Boolean isDead;
    //Vector2D position;
    public Tank(){
        super();
        BufferedImage image = SpriteUtils.loadImage("assets/tank_image/tank2.PNG");
        this.renderer = new SingleImageRenderer(image);
        this.position = new Vector2D(0,0);
        this.collider = new BoxCollider(56,56);

    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress){
            this.position.addThis(0,-4);
        }else if(KeyEventPress.isDownPress){
            this.position.addThis(0,+4);
        }else if(KeyEventPress.isLeftPress) {
            this.position.addThis(-4,0);
        }else if(KeyEventPress.isRightPress) {
            this.position.addThis(+4,0);
        }
        /*boolean fireCounterRun  = this.shootCount.run();
        if(KeyEventPress.isSpace && fireCounterRun){
            this.shoot();
        }*/
    }

   /* public void move(int translatex , int translatey){
        this.position.addThis(translatex,translatey);
    }*/

    public BoxCollider getCollider() {
        return this.collider;
    }
}
