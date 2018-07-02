package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

public class DaliyController {

    public static Location 主界面_日常 = new Location(88, 20);
    public static Location 日常_关闭 = new Location(89, 5);
    public static Location 幻境挑战 = new Location(43, 37);
    public static Location 修罗降临 = new Location(85, 37);
    public static Location 妖师来袭 = new Location(43, 53);


    public static Location 过关斩将 = new Location(84, 53);
    public static Location 过关斩将_重置 = new Location(68, 80);
    public static Location 过关斩将_扫荡 = new Location(96, 78);
    public static Location 过关斩将_困难 = new Location(36, 12);
    public static Location 过关斩将_确认奖励 = new Location(59, 72);
    public static Location 过关斩将_关闭 = new Location(89, 8);

    public static Location 乱之争雄 = new Location(43, 69);
    public static Location 演武榜 = new Location(85, 68);
    public static Location 部署武将_关闭 = new Location(95, 7);
    public static Location 确认部署 = new Location(59, 61);

    public static Location 幻境_扫荡 = new Location(89, 89);
    public static Location 幻境_确认奖励 = new Location(47, 68);
    public static Location 幻境_关闭 = new Location(94, 7);
    public static Location 刷新 = new Location(4, 8);
    public static Location 刷新幻境 = new Location(33, 17);

    public static void 挑战过关斩将() {
        CommonHelper.moveAndClickWithTerminal(主界面_日常);
        CommonHelper.moveAndClickWithTerminal(过关斩将);
        for (int i = 0; i < 2; i++) {
            CommonHelper.moveAndClickWithTerminal(过关斩将_重置);
            CommonHelper.moveAndClickWithTerminal(过关斩将_扫荡);
            CommonHelper.moveAndClickWithTerminal(过关斩将_确认奖励);
            CommonHelper.moveAndClickWithTerminal(过关斩将_困难);
            CommonHelper.moveAndClickWithTerminal(过关斩将_扫荡);
            CommonHelper.moveAndClickWithTerminal(过关斩将_确认奖励);
        }
        CommonHelper.moveAndClickWithTerminal(过关斩将_关闭);
        CommonHelper.moveAndClickWithTerminal(日常_关闭);
    }

    public static void main(String[] args) {
        挑战幻境();
    }

    public static void 挑战幻境() {
        CommonHelper.moveAndClickWithTerminal(主界面_日常);
        CommonHelper.sleep(500);
        CommonHelper.moveAndClickWithTerminal(幻境挑战);
        CommonHelper.sleep(500);
        //部署武将
        CommonHelper.moveAndClickWithTerminal(ButtonLocation.智力);
        CommonHelper.sleep(500);
        CommonHelper.moveAndClickWithTerminal(副本.武将4);
        CommonHelper.moveAndClickWithTerminal(副本.武将2);
        CommonHelper.moveAndClickWithTerminal(副本.武将1);
        CommonHelper.moveAndClickWithTerminal(部署武将_关闭);
        CommonHelper.moveAndClickWithTerminal(确认部署);
        for (int i = 0; i < 6; i++) {
            CommonHelper.moveAndClickWithTerminal(幻境_扫荡);
            CommonHelper.sleep(800);
            //容错
            int k = 22;
            while (k > 0) {
                k--;
                CommonHelper.moveAndClickWithTerminal(幻境_确认奖励);
                CommonHelper.sleep(800);
            }
        }
        CommonHelper.moveAndClickWithTerminal(幻境_关闭);
        CommonHelper.moveAndClickWithTerminal(日常_关闭);
    }
}
