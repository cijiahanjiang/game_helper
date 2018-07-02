package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class CommonHelper {
    public static Location 相对_武将信息_道具 = new Location(63, 27);
    public static Location 相对_道具_珠宝 = new Location(73, 45);
    public static Location 相对_道具_使用 = new Location(32, 84);
    public static Location 相对_武将信息_确定 = new Location(56, 98);
    public static Location 相对_武将信息_关闭 = new Location(90, 8);
    public static Location 相对_武将列表_关闭 = new Location(96, 5);
    public static Location 武将1 = new Location(53, 29);
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        CommonHelper.sleep(1000);
        input("3603006");
    }

    public static void input(String id) {
        sleep(500);
        for (int i = 0; i < id.length(); i++) {
            int temp = Integer.valueOf(id.substring(i, i + 1)) + 48;
            robot.keyPress(temp);
            sleep(300);

        }
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (Exception e) {

        }
    }

    public static void moveAndClickWithTerminal(Location location) {
        Location assLocation = getAbsLocation(location);
        robot.mouseMove(assLocation.getX(), assLocation.getY());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
    }



    public static void moveAndClickWithMiddleTerminal(Location location) {
        Location assLocation = getAbsLocation(location);
        robot.mouseMove(assLocation.getX(), assLocation.getY());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
    }

    public static void moveAndClick(Location location) throws Exception {
        Location assLocation = getAbsLocation(location);
        robot.mouseMove(assLocation.getX(), assLocation.getY());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void addLoyalty() throws Exception {
        moveAndClickWithTerminal(ButtonLocation.相对_武将);
        CommonHelper.sleep(500);
        //根据智力排序
        moveAndClickWithTerminal(ButtonLocation.智力);
        CommonHelper.sleep(500);
        moveAndClickWithTerminal(武将1);
        CommonHelper.sleep(500);
        moveAndClickWithTerminal(相对_武将信息_道具);
        Thread.sleep(500);
        moveAndClickWithTerminal(相对_道具_珠宝);
        CommonHelper.sleep(500);
        moveAndClickWithTerminal(相对_道具_使用);
        CommonHelper.sleep(500);
        moveAndClickWithTerminal(相对_武将信息_确定);
        CommonHelper.sleep(500);
        moveAndClickWithTerminal(相对_武将信息_关闭);
        CommonHelper.sleep(500);
        moveAndClickWithTerminal(相对_武将列表_关闭);
        Thread.sleep(1000);
    }

    public static Location getAbsLocation(Location location) {
        int x = (ButtonLocation.绝对_右下角.getX() - ButtonLocation.绝对_左上角.getX()) * location.getX() / 100 + ButtonLocation.绝对_左上角.getX();
        int y = (ButtonLocation.绝对_右下角.getY() - ButtonLocation.绝对_左上角.getY()) * location.getY() / 100 + ButtonLocation.绝对_左上角.getY();
        Location temp = new Location(x, y);
        return temp;
    }
}
