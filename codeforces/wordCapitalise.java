package codeforces;
import java.util.*;
public class wordCapitalise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ns = s.substring(0,1).toUpperCase() + s.substring(1);
        System.out.println(ns);

    }
}
