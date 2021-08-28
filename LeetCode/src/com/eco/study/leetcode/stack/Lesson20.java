package com.eco.study.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Lesson20
 * Description
 * Date 2021/8/28
 * Author wangxiyue.xy@163.com
 *
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Lesson20 {

    public static void main(String[] args) {
        String s = "()'";
        Solution20 solution = new Solution20();
        System.out.println(solution.isValid(s));

    }
}

class Solution20 {

    public boolean isValid(String s) {
        List list =  new ArrayList<String>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c){
                case '{':
                case '[':
                case '(':
                    list.add(String.valueOf(c));
                    break;
                //
                case ')':
                    if(list.size()==0){
                        return false;
                    }
                    if(list.get(list.size()-1).equals("(")){
                        list.remove(list.size()-1);
                        break;
                    }else {
                        return false;
                    }
                case ']':
                    if(list.size()==0){
                        return false;
                    }
                    if(list.get(list.size()-1).equals("[")){
                        list.remove(list.size()-1);
                        break;
                    }else {
                        return false;
                    }
                case '}':
                    if(list.size()==0){
                        return false;
                    }
                    if(list.get(list.size()-1).equals("{")){
                        list.remove(list.size()-1);
                        break;
                    }else {
                        return false;
                    }
            }
        }
        if(list.size() > 0 ){
            return false;
        }
        return true;
    }
}