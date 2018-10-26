package base.enemy;

import base.physics.BoxCollider;
import base.renderer.AnimationRenderer;
import base.renderer.SingleImageRenderer;

public class EnemyType1 extends Enemy {
    public EnemyType1() {
        super();
        this.renderer = new SingleImageRenderer(
                "assets/tank_image/enemy5.gif"
        );
        this.collider = new BoxCollider(56, 56);
    }

    @Override
    public void takeDamage(int damage) {
        if(damage > 0) {
            this.destroy();
        }
    }
}
