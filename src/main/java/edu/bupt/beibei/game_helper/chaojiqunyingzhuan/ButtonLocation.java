package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

import java.awt.*;
import java.util.Scanner;

public class ButtonLocation {
    public static Location 绝对_左上角 = new Location(81, 106);
    public static Location 绝对_右下角 = new Location(1354, 818);


    public static Location 主城_获得奖励_确定 = new Location(1408, 411);
    public static Location 相对_主城_获得奖励_确定 = new Location(48, 69);
    public static Location 主界面_主城 = new Location(1276, 257);
    public static Location 相对_主界面_主城 = new Location(30, 33);

    public static Location 主城__一键收获 = new Location(1334, 214);
    public static Location 相对_主城__一键收获 = new Location(38, 23);

    public static Location 主城_关闭 = new Location(1744, 166);
    public static Location 相对_主城_关闭 = new Location(92, 12);


    public static Location 副本 = new Location(1524, 509);
    public static Location 相对_副本 = new Location(63, 92);

    public static Location 武将 = new Location(1703, 511);
    public static Location 相对_武将 = new Location(86, 93);

    public static Location 世界 = new Location(94, 75);

    public static Location 征战 = new Location(1767, 502);
    public static Location 相对_征战 = new Location(95, 91);


    public static Location 武将1 = new Location(1282, 231);
    public static Location 相对_武将1 = new Location(31, 27);

    public static Location 武将2 = new Location(1253, 277);
    public static Location 相对_武将2 = new Location(27, 38);

    public static Location 武将3 = new Location(1250, 325);
    public static Location 相对_武将3 = new Location(27, 49);

    public static Location 武将4 = new Location(1236, 372);
    public static Location 相对_武将4 = new Location(25, 60);

    public static Location 副本装备 = new Location(1173, 302);
    public static Location 相对_副本装备 = new Location(17, 44);

    public static Location 副本_传说难度 = new Location(1306, 450);
    public static Location 相对_副本_传说难度 = new Location(34, 79);

    public static Location 副本_确认挑战 = new Location(1508, 363);
    public static Location 相对_副本_确认挑战 = new Location(61, 58);

    public static Location 副本_扫荡 = new Location(1508, 433);
    public static Location 相对_副本_扫荡 = new Location(61, 75);

    public static Location 武将_出击 = new Location(1674, 461);
    public static Location 相对_武将_出击 = new Location(83, 81);

    public static Location 开战 = new Location(1421, 293);
    public static Location 相对_开战 = new Location(49, 41);

    public static Location 技能1 = new Location(1351, 459);
    public static Location 相对_技能1 = new Location(40, 81);

    public static Location 胜利关闭 = new Location(1712, 175);
    public static Location 相对_胜利关闭 = new Location(88, 14);

    public static Location 相对_扫荡确认奖励 = new Location(51, 69);
    public static Location 相对_具体副本_关闭 = new Location(68, 4);

    public static Location 相对_副本_刷新 = new Location(10, 6);
    public static Location 相对_副本_关闭 = new Location(89, 6);
    public static Location 相对_副本_经验 = new Location(20, 20);
    public static Location 相对_副本_属性 = new Location(20, 31);
    public static Location 相对_副本_装备 = new Location(17, 45);
    public static Location 相对_副本_挑战 = new Location(84, 20);


    public static Location 相对_日常 = new Location(88, 20);


//    public static int[] 属性副本武将数 = {2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 5, 5, 0, 0, 0, 0};
//    public static int[] 最大武将数 = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0};

    public static void main(String[] args) throws Exception {
        int i = 1;
        Scanner sb = new Scanner(System.in);
        while (i > 0) {
            String s = sb.nextLine();
            try {
                getPercentByString(s);
            } catch (Exception e) {

            }
        }
    }

    public static void getPercent(Location location) {
        int x = (location.getX() - 绝对_左上角.getX()) * 100 / (绝对_右下角.getX() - 绝对_左上角.getX());
        int y = (location.getY() - 绝对_左上角.getY()) * 100 / (绝对_右下角.getY() - 绝对_左上角.getY());
        System.out.println(x + ":" + y);
    }

    public static void getPercentByString(String s) {
        String[] strs = s.split(" ");
        String button_name = strs[3];
        int abs_x = Integer.valueOf(strs[6].split("\\(")[1].split(",")[0]);
        int abs_y = Integer.valueOf(strs[7].split("\\)")[0]);
        int x = (abs_x - 绝对_左上角.getX()) * 100 / (绝对_右下角.getX() - 绝对_左上角.getX());
        int y = (abs_y - 绝对_左上角.getY()) * 100 / (绝对_右下角.getY() - 绝对_左上角.getY());
        System.out.println("sa" + button_name + " = new Location(" + x + "," + y + ");");
    }

    public static Location getAbsoluteLocation(Location location) throws Exception {
        int x = (绝对_右下角.getX() - 绝对_左上角.getX()) * location.getX() / 100 + 绝对_左上角.getX();
        int y = (绝对_右下角.getY() - 绝对_左上角.getY()) * location.getY() / 100 + 绝对_左上角.getY();
        Location temp = new Location(x, y);
        Robot robot = new Robot();
        robot.mouseMove(temp.getX(), temp.getY());
        return temp;
    }


}
