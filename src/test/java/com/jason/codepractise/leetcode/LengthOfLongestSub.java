package com.jason.codepractise.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSub {

    public static Integer solution(String s) {
        Map<String, Integer> st = new HashMap<>();
        int i = 0;
        int ans = 0;
        int result = 0;

        for (int j = 0; j < s.length();) {
            String c = String.valueOf(s.charAt(j));
            if (st.containsKey(c)) {
                i = Math.max(st.get(c) + 1, i);
            }
            result = Math.max(result, j - i + 1);
            st.put(c, j);
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = LengthOfLongestSub.solution("abca");
        System.out.println(a);
    }
}
