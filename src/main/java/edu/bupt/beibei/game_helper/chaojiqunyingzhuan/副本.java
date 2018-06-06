package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;


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

    public static Location 活动或装备 = new Location(16, 45);
    private static int[] 活动副本武将数 = {2, 3, 3, 3, 4};

    public static Location 技能4 = new Location(60, 79);
    public static Location 技能3 = new Location(52, 79);
    public static Location 技能2 = new Location(46, 81);
    public static Location 技能1 = new Location(39, 80);


    public static void main(String[] args) throws Exception {
        instance(属性副本, 属性副本武将数,12);
        扫荡(属性副本, 7);
        instance(兑换活动副本, 兑换活动副本武将数, 40, 5);
        扫荡(兑换活动副本, 5);
    }

    public static void instance(Location location, int[] ints, int left) throws Exception {
        instance(location, ints, left, 7);
    }

    public static void instance(Location location, int[] ints) throws Exception {
        instance(location, ints, 10 * instance_available_time, 7);
    }

    public static String instance(Location location, int[] ints, int left, int count) throws Exception {
        Thread.sleep(1000);
        for (int k = 10 * instance_available_time - left; k < count * instance_available_time; k++) {
            System.out.println("第" + (k / instance_available_time + 1) + "副本第" + (k % instance_available_time + 1) + "场");
            //战斗10场补充忠诚
            if (k % 10 == 0) CommonHelper.addLoyalty(武将3);
            CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本);
            CommonHelper.moveAndClickWithMiddleTerminal(location);
            CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_挑战);
            CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_传说难度);
            CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.相对_副本_确认挑战);
//            CommonHelper.moveAndClickWithMiddleTerminal(武将2);
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
                CommonHelper.moveAndClick(技能4);
                CommonHelper.moveAndClick(技能4);
                Thread.sleep(4000);
            }
            Thread.sleep(4000);
            CommonHelper.moveAndClick(ButtonLocation.相对_胜利关闭);
            Thread.sleep(500);
        }
//        扫荡(location, count);
        return "成功";
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
}
