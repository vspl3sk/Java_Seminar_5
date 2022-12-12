package java_Seminar_5;

import java.util.HashMap;

// 3. Написать метод, который переведет число из римского
// формата записи в арабский. Например, MMXXII = 2022
// (правила см. во вложениях к уроку, где ссылка на репозиторий).

public class javaSeminar5task3 {
    public static void main(String[] args) {
        javaSeminar5task3 roman = new javaSeminar5task3();

        System.out.println(roman.romanToInt("VI"));
        System.out.println(roman.romanToInt("XVII"));
        System.out.println(roman.romanToInt("CIX"));
        System.out.println(roman.romanToInt("XXXIV"));
    }

    public int getArabian(char roman) {
        if ('I' == roman)
            return 1;
        else if ('V' == roman)
            return 5;
        else if ('X' == roman)
            return 10;
        else if ('L' == roman)
            return 50;
        else if ('C' == roman)
            return 100;
        else if ('D' == roman)
            return 500;
        else if ('M' == roman)
            return 1000;
        return 0;
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = map.get(arr[i]);

            if (arabian < map.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}
