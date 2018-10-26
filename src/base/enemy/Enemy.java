package base.enemy;

import base.*;
import base.action.*;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
    Action action;

    public Enemy() {
        super();
        this.position = new Vector2D(200, 100);

        this.defineAction();
    }

    void defineAction(){
        ActionWait actionWait = new ActionWait(20);
        Action actionFire =  new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone = true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        Action actionMove = new Action() {
            @Override
            public void run(GameObject master) {
                move();
            }

            @Override
            public void reset() {

            }
        };

        ActionSequence actionSequence = new ActionSequence(actionWait, actionFire);
        ActionParallel actionParallel = new ActionParallel(actionMove,actionSequence);
        ActionRepeat actionRepeat = new ActionRepeat(actionParallel);
        this.action = actionRepeat;
    }

    public void move(){
        if(this.position.y == Settings.WAY_SIZE*20){
            Settings.ENEMY_MOVE = -4;
        }
        else if(this.position.y == Settings.WAY_SIZE*5){
            Settings.ENEMY_MOVE = 4;
        }
        this.position.addThis(0, Settings.ENEMY_MOVE);
        //System.out.println(Setting.ENEMY_MOVE + " " + this.position.x);
    }

    @Override
    public void run() {
        this.action.run(this);
    }

    public void fire() {
        EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
        bullet.position.set(this.position.x, this.position.y + Settings.WAY_SIZE);
    }

    public void takeDamage(int damage) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
