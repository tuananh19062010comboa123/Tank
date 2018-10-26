package base.player;

import base.GameObject;
import base.Settings;
import base.counter.FrameCounter;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.BoxColliderRenderer;

import java.awt.*;

public class SnakePart extends GameObject implements Physics {
    BoxCollider collider;
    Boolean isDead;
    FrameCounter blinkCount;

    public SnakePart() {
        super();
        this.collider = new BoxCollider(Settings.WAY_SIZE - 6
                , Settings.WAY_SIZE - 6);
        this.renderer = new BoxColliderRenderer(Color.WHITE);
        this.isDead =false;
        this.blinkCount = new FrameCounter(4);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return collider;
    }

    @Override
    public void render(Graphics g) {
        if(this.isDead){
            if(this.blinkCount.run()){
                super.render(g);
                this.blinkCount.reset();
            }

        }else {
            super.render(g);
        }

    }
}
