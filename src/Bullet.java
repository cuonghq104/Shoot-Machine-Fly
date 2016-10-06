import java.awt.*;

/**
 * Created by Cuong on 10/4/2016.
 */
public class Bullet {
    private int x;

    private int y;

    public static final int SPEED = 10;

    public static final int BULLET_WIDTH = 10;
    public static final int BULLET_HEIGHT = 30;

    private Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void move() {
//        if (y > 100)
            y -= SPEED;
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, BULLET_WIDTH, BULLET_HEIGHT, null);
        move();
    }
}
