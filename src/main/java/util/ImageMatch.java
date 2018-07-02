package util;

import edu.bupt.beibei.game_helper.chaojiqunyingzhuan.ButtonLocation;
import edu.bupt.beibei.game_helper.chaojiqunyingzhuan.CommonHelper;
import edu.bupt.beibei.game_helper.chaojiqunyingzhuan.Location;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageMatch {

    public static Location 五_左上 = new Location(50, 71);
    public static Location 五_右下 = new Location(60, 88);
    public static Location 一_左上 = new Location(5, 71);
    public static Location 一_右下 = new Location(15, 88);

    public static void main(String[] args) {

        CommonHelper.sleep(2000);
        BufferedImage bufferedImage = getPartScreenShot(一_左上, 一_右下);
//        int[][] sa = getImageRGB(bufferedImage);
//        BufferedImage bufferedImage1 = getPartScreenShot(一_左上, 一_右下);
//        int[][] sb = getImageRGB(bufferedImage1);
//
//        for (int i = 0; i < sa.length; i++) {
//            for (int j = 0; j < sa[i].length; j++) {
//                System.out.println(sa[i][j] == sb[i][j]);
//            }
//        }
        try {
            ImageIO.write(bufferedImage, "jpg", new File("d:/测试.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 截图
    public static BufferedImage getPartScreenShot(Location 左上, Location 右下) {
        左上 = CommonHelper.getAbsLocation(左上);
        右下 = CommonHelper.getAbsLocation(右下);
        BufferedImage bfImage = null;
        try {
            Robot robot = new Robot();
//            Rectangle screenRect = new Rectangle(494, 640, 100,100);
            Rectangle screenRect = new Rectangle(左上.getX(), 左上.getY(), 右下.getX() - 左上.getX(), 右下.getY() - 左上.getY());
            bfImage = robot.createScreenCapture(screenRect);
            System.out.println(bfImage.getRGB(bfImage.getWidth()/2,bfImage.getHeight()/2));
            System.out.println(bfImage.getRGB(0,0));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return bfImage;
    }

    // 获取像素点值
    public static int[][] getImageRGB(BufferedImage bfImage) {
        int width = bfImage.getWidth();
        int height = bfImage.getHeight();
        int[][] result = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                result[x][y] = bfImage.getRGB(x, y) & 0xFFFFFF;
            }
        }
        return result;
    }
}