package base.wall;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Stone extends GameObject implements Physics {
    BoxCollider collider;
    public Stone(){
        BufferedImage imageDa = SpriteUtils.loadImage("assets/maps/item_built_map/ConcreteOrig.png");
        this.renderer = new SingleImageRenderer(imageDa);
        this.collider = new BoxCollider(Settings.WAY_SIZE,Settings.WAY_SIZE);
        this.position = new Vector2D(0.0F, 0.0F);
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
