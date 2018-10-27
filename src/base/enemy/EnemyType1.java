//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package base.enemy;

import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;

public class EnemyType1 extends Enemy {
    public EnemyType1() {
        this.renderer = new SingleImageRenderer("assets/tank_image/enemy5.gif");
        this.collider = new BoxCollider(52, 52);
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            this.destroy();
        }

    }
}
