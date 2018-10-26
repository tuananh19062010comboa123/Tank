package base.scene;

import base.player.Tank;

public abstract class Scene {
   // public Player player;
  //  public SnackManager snackManager;

    public Tank tank;
    public abstract void destroy();

    public abstract void init();
}
