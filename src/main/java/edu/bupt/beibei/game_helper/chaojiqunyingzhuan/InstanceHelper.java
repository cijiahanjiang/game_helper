package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * Created by beibei on 2018/5/7.
 */
public class InstanceHelper {

    private static Location 主界面副本 = new Location(1297, 743);

    private static Location 副本界面经验 = new Location(712, 204);

    private static Location 副本_属性 = new Location(706, 281);

    private static Location 副本界面装备 = new Location(719, 470);

    private static Location 副本界面副将 = new Location(677, 557);

    private static Location 副本_活动 = new Location(677, 359);

    private static Location 副本界面挑战 = new Location(1572, 213);
    private static Location 副本页面刷新按钮 = new Location(607, 109);
    private static Location 副本页面关闭按钮 = new Location(1612, 113);


    private static Location 传说难度 = new Location(938, 641);

    private static Location 挑战传说难度 = new Location(1236, 482);

    private static Location 扫荡 = new Location(1255, 602);
    private static Location 扫荡成功确定按钮 = new Location(1120, 557);
    private static Location 特定副本关闭按钮 = new Location(1363, 114);

    private static Location 要选择的武将 = new Location(991, 276);

    private static Location 出击 = new Location(1554, 659);
    private static Location 开战 = new Location(1099, 368);
    private static Location 技能一 = new Location(986, 636);


    private static Location 战斗结束关闭 = new Location(1603, 173);

    private static int[] 属性副本武将数 = {2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 0, 0, 0, 0};
    private static int[] 最大武将数 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0};

    private static Location 幻境_确定 = new Location(1092, 557);
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) throws Exception {
        CommonHelper.addLoyalty();
        instanceHelper(副本_属性, 属性副本武将数);
//        while (1>0){
//            moveAndClick(幻境_确定);
//            Thread.sleep(2000);
//        }
    }

    /**
     * @param location   副本类型
     * @param heroNumber 每一个关卡需要战斗的武将数
     */
    private static void instanceHelper(Location location, int[] heroNumber) throws Exception {
        Thread.sleep(2000);
        for (int k = 0; k < heroNumber.length; k++) {
            moveAndClick(主界面副本);
            Thread.sleep(500);
            moveAndClick(location);
            Thread.sleep(500);
            //战斗10场补充忠诚
            if (k == 10)
                CommonHelper.addLoyalty();
            //第8关之后开始扫荡
            if (k >= 16) {
                for (int m = k; m < heroNumber.length; m++) {
                    moveAndClick(副本界面挑战);
                    Thread.sleep(500);
                    moveAndClick(传说难度);
                    //扫荡完成关闭界面
                    moveAndClick(扫荡);
                    Thread.sleep(1000);
                    moveAndClick(扫荡成功确定按钮);
                    Thread.sleep(800);
                    if (k % 2 == 0) {
                        moveAndClick(副本页面刷新按钮);
                        Thread.sleep(800);
                    }
                }
                moveAndClick(副本页面关闭按钮);
                break;
            }
            moveAndClick(副本界面挑战);
            Thread.sleep(500);
            moveAndClick(传说难度);
            Thread.sleep(500);
            moveAndClick(挑战传说难度);
            Thread.sleep(500);
            moveAndClick(要选择的武将);
            Thread.sleep(500);
            moveAndClick(出击);
            Thread.sleep(500);
            for (int i = 0; i < heroNumber[k]; i++) {
                moveAndClick(开战);
                Thread.sleep(1000);
                moveAndClick(技能一);
                Thread.sleep(1000);
                moveAndClick(技能一);
                Thread.sleep(1000);
                moveAndClick(技能一);
                Thread.sleep(1000);
                moveAndClick(技能一);
                //一个技能能打死
                Thread.sleep(4000);
                moveAndClick(技能一);
                Thread.sleep(6000);
            }
            Thread.sleep(3000);
            moveAndClick(战斗结束关闭);
            Thread.sleep(500);
        }
        CommonHelper.addLoyalty();
    }

    private static void moveAndClick(Location location) {
        robot.mouseMove(location.getX(), location.getY());
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}