package com.eco.study.leetcode.string;

import java.util.HashSet;

/**
 * ClassName Lesson387
 * Description
 * Date 2021/8/25
 * Author wangxiyue.xy@163.com
 *
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class Lesson387 {

    public static void main(String[] args) {
        String s = "aabb";
        Solution387 solution = new Solution387();
        System.out.println(solution.firstUniqChar(s));
    }


}

class Solution387 {

    public int firstUniqChar(String s){
        HashSet<Object> re = new HashSet<>();
        char cur;
        for (int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if (re.contains(cur)) {
                continue;
            }
            int count = 0;
            for (int j = i+1; j < s.length(); j++) {
                if(cur == s.charAt(j)){
                    re.add(cur);
                    break;
                }
                count++;
            }
            if(count==(s.length()-i-1)){
                return i;
            }
        }
        return -1;
    }
}