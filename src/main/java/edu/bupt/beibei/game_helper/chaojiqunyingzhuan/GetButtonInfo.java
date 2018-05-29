package edu.bupt.beibei.game_helper.chaojiqunyingzhuan;

import edu.bupt.game.helper.sanguo.ButtonLocation;

import java.awt.*;
import java.util.Scanner;

public class GetButtonInfo {

    public static void main(String[] args) {
        getNativeLocation();
//        getAbsLocation();
    }

    public static void getNativeLocation() {
        Scanner sb = new Scanner(System.in);
        int total = 1;
        while (total > 0) {
            String title = sb.nextLine();
            int x = (MouseInfo.getPointerInfo().getLocation().x - ButtonLocation.绝对_左上角.getX()) * 100 / (ButtonLocation.绝对_右下角.getX() - ButtonLocation.绝对_左上角.getX());
            int y = (MouseInfo.getPointerInfo().getLocation().y - ButtonLocation.绝对_左上角.getY()) * 100 / (ButtonLocation.绝对_右下角.getY() - ButtonLocation.绝对_左上角.getY());
            System.out.println("public static Location " + title + " = new Location(" + x + ", " + y + ");");
        }
    }

    public static void getAbsLocation() {
        Scanner sb = new Scanner(System.in);
        int total = 1;
        while (total > 0) {
            String s = sb.nextLine();
            int x = MouseInfo.getPointerInfo().getLocation().x;
            int y = MouseInfo.getPointerInfo().getLocation().y;
            System.out.println(x + "," + y);
        }
    }


}
