package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

public class ResourceHelper {
    private static String[] 小号 = {
            "2196009",
            "2196010",
            "2221003",
            "2221004",
            "2221006",
            "2413004",
            "2413005",
            "2413006"
    };
    public static Location 争霸 = new Location(25, 50);
    public static Location 争霸定位 = new Location(94, 80);
    //    public static Location 争霸定位 = new Location(92, 79);
    public static Location 争霸_输入框 = new Location(58, 76);
    public static Location 输入 = new Location(43, 95);
    public static Location 争霸_查找坐标 = new Location(74, 76);
    public static Location 主城_关闭 = new Location(76, 17);
    public static Location 城池 = new Location(49, 49);
    public static Location 撤军 = new Location(51, 37);
    public static Location 攻占 = new Location(41, 43);
    public static Location 位置 = new Location(91, 16);
    public static Location 武将1 = new Location(53, 29);
    public static Location 出击 = new Location(83, 81);

    public static void main(String[] args) {
        占坑();
    }

    public static void 占坑() {
        CommonHelper.sleep(2000);
        CommonHelper.moveAndClickWithMiddleTerminal(ButtonLocation.世界);
        CommonHelper.moveAndClickWithMiddleTerminal(争霸);
        CommonHelper.sleep(2000);
        for (String s : 小号) {
            CommonHelper.moveAndClickWithMiddleTerminal(争霸定位);
            CommonHelper.moveAndClickWithTerminal(争霸_输入框);
            CommonHelper.moveAndClickWithTerminal(输入);
            CommonHelper.input(s);
            CommonHelper.moveAndClickWithTerminal(争霸_查找坐标);
            CommonHelper.moveAndClickWithTerminal(争霸_查找坐标);
            CommonHelper.moveAndClickWithMiddleTerminal(主城_关闭);
            CommonHelper.moveAndClickWithMiddleTerminal(城池);
            CommonHelper.moveAndClickWithTerminal(撤军);
            CommonHelper.moveAndClickWithMiddleTerminal(城池);
//            49001
            CommonHelper.moveAndClickWithMiddleTerminal(攻占);
            CommonHelper.moveAndClickWithMiddleTerminal(位置);
            CommonHelper.moveAndClickWithMiddleTerminal(位置);
            CommonHelper.moveAndClickWithMiddleTerminal(武将1);
            CommonHelper.moveAndClickWithMiddleTerminal(出击);
            CommonHelper.sleep(25000);
        }
    }
}
