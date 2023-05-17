package hw1.topic1;

import java.util.Arrays;

public class StringTopic {
    public static void main(String[] args) {
        System.out.println("---------P1---------");
        p1();
        System.out.println("---------P2---------");
        p2();
        System.out.println("---------P3---------");
        p3();
        System.out.println("---------P4---------");
        p4();
    }

    private static void p1() {
        String str = "Algorithm";
        System.out.println(str.substring(2, 4));
        System.out.println(str.substring(0, 4));
    }

    private static boolean ifEqual(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        for (int i=0; i<str1.length(); i++){
            if(str1.charAt(i)!=str2.charAt(i)) return false;
        }
        return true;
    }

    private static void p2() {
        String str1 = "abc";
        String str2 = "abd";
        String str3 = "abc";
        System.out.println(ifEqual(str1, str2));
        System.out.println(ifEqual(str1, str3));
    }

    private static void p3() {
        String str1 = "https://www.amazon.com/demo?test=abc";
        System.out.println(Arrays.toString(str1.split("[:/.?=]+")));
    }

    private static void p4() {
        String[] strings = {"https", "www", "amazon", "com", "demo", "test", "abc"};
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s).append(" ");
        }
        System.out.println(sb);
    }
}
