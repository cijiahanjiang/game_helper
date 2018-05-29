package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

import java.awt.*;
import java.util.Calendar;

public class BossHelper {

    public static Location 进攻 = new Location(79, 76);
    public static Location 开战 = new Location(49, 41);
    public static Location 技能1 = new Location(40, 81);
    private static long 晚上8点半 = 1;


    private static Robot robot;

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 20);
        晚上8点半 = calendar.getTimeInMillis();
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 00);
        try {
            robot = new Robot();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        while (1 > 0) {
            CommonHelper.moveAndClickWithTerminal(进攻);
            Thread.sleep(800);
            for (int i = 0; i < 3; i++) {
                CommonHelper.moveAndClickWithTerminal(开战);
                CommonHelper.moveAndClickWithTerminal(开战);
                CommonHelper.moveAndClickWithTerminal(开战);
                CommonHelper.moveAndClickWithTerminal(开战);
                for (int k = 1; k < 18; k++) {
                    CommonHelper.moveAndClickWithTerminal(技能1);
                }
                Thread.sleep(3500);
            }
//            if (System.currentTimeMillis() > 晚上8点半)
//                break;
            Thread.sleep(24000);
        }
    }
}
