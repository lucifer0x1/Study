package com.eco.study.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName Lesson383
 * Description
 * Date 2021/8/26
 * Author wangxiyue.xy@163.com
 *
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 *
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 提示：
 *
 * 你可以假设两个字符串均只含有小写字母。
 */
public class Lesson383 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        Solution383 solution =  new Solution383();
        System.out.println(solution.canConstruct(ransomNote,magazine));
    }
}

class Solution383 {

    //利用字符串查找 , 这个方法貌似效率 也不高， 因为需要每次 replace 重新赋值
    public boolean canConstruct(String ransomNote , String magazine){
        String noteStr = null;
        for (int i = 0; i < ransomNote.length(); i++) {
            noteStr = ransomNote.substring(i,i+1);
            if(magazine.indexOf(noteStr) ==-1){
                return false;
            }else {
                magazine = magazine.replaceFirst(noteStr,"");
            }
        }
        return true;
    }

    //利用HashMap 计数统计，简单但是效率和性能不够
    public boolean canConstruct2(String ransomNote , String magazine){
        Map<String,Integer> r = countCharSumToMap(ransomNote);
        Map<String,Integer> m = countCharSumToMap(magazine);
        for (String k : r.keySet()) {
            if(m.getOrDefault(k,0).intValue() < r.get(k).intValue()){
                return false;
            }
        }
        return true;
    }

    private Map<String,Integer> countCharSumToMap(String targetString){
        HashMap<String,Integer> sumChar = new HashMap<>();
        for (int i = 0; i < targetString.length(); i++) {
            sumChar.put(String.valueOf(targetString.charAt(i)),
                    sumChar.getOrDefault(String.valueOf(targetString.charAt(i)),0)+1);
        }
        return sumChar;
    }
}