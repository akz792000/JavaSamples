package com.zalando;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Second {

    public static int solution(String S) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            Character character = S.charAt(i);
            Integer num = map.get(character);
            if (num != null) {
                num = num + 1;
            } else {
                num = 1;
            }
            map.put(character, num);
        }

        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            while (set.contains(value)) {
                value--;
                result++;
            }
            if (value != 0) {
                set.add(value);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.print(solution("ccaaffddecee"));
        //System.out.print(solution("example"));
    }

}
