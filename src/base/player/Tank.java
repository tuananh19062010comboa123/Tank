

package base.player;

import base.GameObject;
import base.Settings;
import base.Vector2D;
import base.counter.FrameCounter;
import base.enemy.Enemy;
import base.event.KeyEventPress;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;
import base.wall.Wall;
import java.awt.image.BufferedImage;
import tklibs.SpriteUtils;

public class Tank extends GameObject implements Physics {
    FrameCounter fireCounter;
    BoxCollider collider;
    Boolean isDead;
    Vector2D velocity;
    float currentX = 0.0F;
    float currentY = 0.0F;

    public Tank() {
        BufferedImage image = SpriteUtils.loadImage("assets/tank_image/tank2.PNG");
        this.position = new Vector2D((float)Settings.START_PLAYER_POSITION_X, (float)Settings.START_PLAYER_POSITION_Y);
        this.renderer = new SingleImageRenderer(image);
        this.velocity = new Vector2D(0.0F, 0.0F);
        this.fireCounter = new FrameCounter(10);
        this.collider = new BoxCollider(52, 52);
    }

    public void run() {
        if (!this.checkIntersects()) {
            this.currentX = this.position.x;
            this.currentY = this.position.y;
        }

        if (KeyEventPress.isUpPress) {
            this.position.addThis(0.0F, -4.0F);
        } else if (KeyEventPress.isDownPress) {
            this.position.addThis(0.0F, 4.0F);
        } else if (KeyEventPress.isLeftPress) {
            this.position.addThis(-4.0F, 0.0F);
        } else if (KeyEventPress.isRightPress) {
            this.position.addThis(4.0F, 0.0F);
        }

        boolean fireCounterRun = this.fireCounter.run();
        if (KeyEventPress.isFirePress && fireCounterRun) {
            this.fire();
        }

        this.position.addThis(this.velocity);
        if (this.checkIntersects()) {
            this.position.x = this.currentX;
            this.position.y = this.currentY;
        }

    }

    private boolean checkIntersects() {
        Wall wall = (Wall)GameObject.intersect(Wall.class, this);
        Enemy enemy = (Enemy)GameObject.intersect(Enemy.class, this);
        return wall != null || enemy != null;
    }

    private void fire() {
        PlayBulletType1 bullet = (PlayBulletType1)GameObject.recycle(PlayBulletType1.class);
        bullet.velocity.set(0.0F, -10.0F);
        bullet.position.set(this.position.x, this.position.y - (float)Settings.WAY_SIZE);
        this.fireCounter.reset();
    }

    public void move(int velocityX, int velocityY) {
        this.velocity.addThis((float)velocityX, (float)velocityY);
        this.velocity.set(this.clamp(this.velocity.x, -3.0F, 3.0F), this.clamp(this.velocity.y, -3.0F, 3.0F));
    }

    public float clamp(float number, float min, float max) {
        return number < min ? min : (number > max ? max : number);
    }

    public void takeDamage(int damage) {
        this.destroy();
    }

    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
