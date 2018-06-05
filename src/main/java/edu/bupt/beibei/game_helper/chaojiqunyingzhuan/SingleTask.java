package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

public class SingleTask {

    public static void main(String[] args) {
        int i = 500;
        while (i > 1) {
            Location 确定 = new Location(34, 80);
            CommonHelper.moveAndClickWithMiddleTerminal(确定);
            i--;
        }
    }
}
