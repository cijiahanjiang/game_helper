package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

public class 副本 {
    private static int instance_available_time = 4;
    public static Location 武将1 = new Location(53, 29);
    public static Location 武将2 = new Location(26, 39);
    public static Location 武将3 = new Location(26, 49);
    public static Location 武将4 = new Location(12, 62);
    public static Location 武将5 = new Location(12, 73);

    public static Location 属性副本 = new Location(17, 31);
    private static int[] 属性副本武将数 = {2, 1, 2, 1, 2, 2, 2};

    public static Location 经验副本 = new Location(17, 19);
    private static int[] 经验副本武将数 = {1, 3, 3, 5, 4, 3, 5, 6};

    public static Location 兑换活动副本 = new Location(17, 43);
    private static int[] 兑换活动副本武将数 = {2, 3, 3, 3, 4, 2, 6, 5, 6, 6};

    public static Location 金满地副本 = new Location(17, 55);
    private static int[] 金满地活动武将数 = {1, 1, 4, 2, 1, 3, 3, 6, 6, 1};

    private static Location 副将副本 = new Location(17, 55);
    //    private static Location 副将副本 = new Location(17, 67);
    private static int[] 副将副本武将数 = {5, 3, 3, 3, 3, 3, 5, 6, 4};

    public static Location 技能4 = new Location(60, 79);
    public static Location 技能3 = new Location(52, 79);
    public static Location 技能2 = new Location(46, 81);
    public static Location 技能1 = new Location(39, 80);

    public static Location 默认武将一_左上 = new Location(5, 71);
    public static Location 默认武将一_右下 = new Location(15, 88);

    public static Location 第三位置副本_左上 = new Location(14, 40);
    public static Location 第三位置副本_右下 = new Location(21, 45);

    public static void main(String[] args) throws Exception {
        CommonHelper.sleep(2000);
        getActivityType(第三位置副本_左上, 第三位置副本_右下);
//        截图保存(第三位置副本_左上, 第三位置副本_右下, "兑换活动");
//        hasDefaultHero();
//        int i = 0;
//        i = instance(i, 副将副本, 副将副本武将数);
//        i = instance(i, 金满地副本, 金满地活动武将数, 39);
//        instance(i, 属性副本, 属性副本武将数);
    }

    public static int instance(int times, Location location, int[] ints) throws Exception {
        return instance(times, location, ints, ints.length * instance_available_time);
    }

    public static int instance(int times, Location location, int[] ints, int left) throws Exception {
        Thread.sleep(1000);
        Boolean hasDefaultHero = null;
        for (int k = ints.length * instance_available_time - left; k < ints.length * instance_available_time; k++) {
            System.out.println("第" + (k / instance_available_time + 1) + "副本第" + (k % instance_available_time + 1) + "场");
            if (times % 10 == 0)
                CommonHelper.addLoyalty();
            times++;
            //武将数大于3，用扫荡，否则战斗
            if (ints[k / instance_available_time] > 3) {
                if (k % 4 == 0) {
                    扫荡(location);
                }
            } else {
                CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本);
                CommonHelper.moveAndClickWithMiddleTerminal(location);
                CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_挑战);
                CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_传说难度);
                CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_确认挑战);
                if (hasDefaultHero == null)
                    hasDefaultHero = hasDefaultHero();
                if (!hasDefaultHero) {
                    CommonHelper.moveAndClickWithTerminal(ButtonLocation.智力);
                    CommonHelper.sleep(500);
                    CommonHelper.moveAndClickWithTerminal(武将1);
                }
                CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_武将_出击);
                Thread.sleep(2000);
                for (int i = 0; i < ints[k / instance_available_time]; i++) {
                    CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_开战);
                    CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_开战);
                    CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_开战);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    CommonHelper.moveAndClickWithMiddleTerminal(技能4);
                    Thread.sleep(4000);
                }
                Thread.sleep(4000);
                CommonHelper.moveAndClick(ButtonLocation.相对_胜利关闭);
                Thread.sleep(500);
            }
        }
        return times;
    }

    public static String 扫荡(Location location, int count) throws Exception {
        Thread.sleep(2000);
        CommonHelper.moveAndClickWithTerminal(ButtonLocation.相对_副本);
        CommonHelper.moveAndClickWithTerminal(location);
        for (int i = 0; i < 10 - count; i++) {
            CommonHelper.moveAndClickWithTerminal(ButtonLocation.相对_副本_刷新);
            CommonHelper.moveAndClickWithTerminal(ButtonLocation.相对_副本_挑战);
            CommonHelper.moveAndClickWithTerminal(ButtonLocation.相对_副本_传说难度);
            for (int k = 0; k < instance_available_time; k++) {
                CommonHelper.moveAndClickWithTerminal(ButtonLocation.相对_副本_扫荡);
                CommonHelper.moveAndClick(ButtonLocation.相对_扫荡确认奖励);
                Thread.sleep(1000);
            }
            CommonHelper.moveAndClickWithTerminal(ButtonLocation.相对_具体副本_关闭);
        }
        CommonHelper.moveAndClick(ButtonLocation.相对_副本_关闭);
        return null;
    }

    private static void 截图保存(Location 左上, Location 右下, String name) {
        左上 = CommonHelper.getAbsLocation(左上);
        右下 = CommonHelper.getAbsLocation(右下);
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(左上.getX(), 左上.getY(), 右下.getX() - 左上.getX(), 右下.getY() - 左上.getY());
            BufferedImage bfImage = robot.createScreenCapture(screenRect);
            String classPath = 副本.class.getResource("").getPath();
            String resourcePath = classPath.split("target")[0] + "src/main/resources/" + name + ".jpg";
            ImageIO.write(bfImage, "jpg", new File(resourcePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean hasDefaultHero() {
        Location 左上 = CommonHelper.getAbsLocation(默认武将一_左上);
        Location 右下 = CommonHelper.getAbsLocation(默认武将一_右下);
        try {
//            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(resourcePath));
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(左上.getX(), 左上.getY(), 右下.getX() - 左上.getX(), 右下.getY() - 左上.getY());
            BufferedImage bfImage = robot.createScreenCapture(screenRect);
//            this.getClass().getResource("").getPath();
            String classPath = 副本.class.getResource("").getPath();
            String resourcePath = classPath.split("target")[0] + "src/main/resources/兑换活动.jpg";
            ImageIO.write(bfImage, "jpg", new File(resourcePath));
            double x = Math.abs(bfImage.getRGB(bfImage.getWidth() / 2, bfImage.getHeight() / 2));
            double y = Math.abs(bfImage.getRGB(0, 0));
            if (x / y > 1.3 || x / y < 0.7) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String 扫荡(Location location) throws Exception {
        Thread.sleep(2000);
        CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本);
        CommonHelper.moveAndClickWithMiddleTerminal(location);
        CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_刷新);
        CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_挑战);
        CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_传说难度);
        for (int k = 0; k < instance_available_time; k++) {
            CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_扫荡);
            CommonHelper.moveAndClick(ButtonLocation.相对_扫荡确认奖励);
            Thread.sleep(1000);
        }
        CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_具体副本_关闭);
        CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_关闭);
        return null;
    }

    private static int getActivityType(Location 左上, Location 右下) {
        String classPath = 副本.class.getResource("").getPath();
        String resourcePath = classPath.split("target")[0] + "src/main/resources/兑换活动.jpg";
        try {
            BufferedImage 兑换活动 = ImageIO.read(new FileInputStream(resourcePath));
            左上 = CommonHelper.getAbsLocation(左上);
            右下 = CommonHelper.getAbsLocation(右下);
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(左上.getX(), 左上.getY(), 右下.getX() - 左上.getX(), 右下.getY() - 左上.getY());
            BufferedImage 当前图片 = robot.createScreenCapture(screenRect);
            String tmpPath = classPath.split("target")[0] + "src/main/resources/临时文件.jpg";
            ImageIO.write(当前图片, "jpg", new File(tmpPath));
            BufferedImage 当前保存图片 = ImageIO.read(new FileInputStream(tmpPath));
            //比较两个图片的相似度
            double totalPoint = 0;
            double same_point = 0;
            for (int i = 0; i < 兑换活动.getWidth(); i++) {
                for (int j = 0; j < 兑换活动.getHeight(); j++) {
                    totalPoint++;
                    if (兑换活动.getRGB(i, j) == 当前保存图片.getRGB(i, j)) {
                        same_point++;
                    }
                }
            }
            if (same_point / totalPoint > 0.8) {
                return 1;
            }
        } catch (Exception e) {

        }
        return 0;
    }
}
