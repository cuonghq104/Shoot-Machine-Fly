import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

/**
 * Created by Cuong on 10/4/2016.
 */
public class Plane {

    public static final int PLANE_WIDTH = 60;
    public static final int PLANE_HEIGHT = 35;

    private int x;

    private int y;

    private Image image;

    private Bullet bullet;

    public Plane(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                x += 10;
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("KEY Left");
                x -= 10;
                break;
            case KeyEvent.VK_UP:
                System.out.println("KEY UP");
                y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("KEY DOWN");
                y += 10;
                break;
        }
    }

    public Bullet fire_SPACE(KeyEvent e) {
        Bullet bullet = null;
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
                System.out.println("FIRE SPACE");
                try {
                    bullet = new Bullet(x + PLANE_WIDTH * 5 / 12, y, ImageIO.read(new File("resources/bullet.png")));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            default:
                try {
                    return new Bullet(-30, -30, ImageIO.read(new File("resources/bullet.png")));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
        }
        return bullet;
    }
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved");
        x = e.getX() - PLANE_WIDTH / 2;
        y = e.getY() - PLANE_HEIGHT / 2;
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, PLANE_WIDTH, PLANE_HEIGHT, null);
//        bullet.drawImage(g);
    }

    public Bullet fire_LEFTCLICK(MouseEvent e) {
        Bullet bullet = null;
        System.out.println("FIRE CLICK");
        try {
            bullet = new Bullet(x + (PLANE_WIDTH * 5 / 12), y, ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bullet;
    }


}
