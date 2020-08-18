package com.eco.study.leetcode.bitmanipulation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序
 *
 * 编写一个函数来查找目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 * 示例：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class Lesson187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution187 solution = new Solution187();
        solution.findRepeatedDnaSequences(s).forEach(f-> System.out.println(f));
    }
}

class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int dstLen = 10;
        List<String> res = new ArrayList<>();
        Map<String,Integer> t = new HashMap<>();
        String tmp = null;
        for (int i = 0; i <= s.length()-dstLen; i++) {
           tmp =  s.substring(i,i+dstLen);
           t.put(tmp,t.getOrDefault(tmp,0)+1);
           if(t.getOrDefault(tmp,0) > 1){
               res.add(tmp);
           }
        }

        return res;
    }

    /**
     * 其思想是对字符串进行切片，并在滑动窗口中计算序列的掩码，两者都是在一个恒定的时间内进行的。
     *
     * 和 Rabin-Karp 一样，将字符串转换为两个比特位整数数组。
     *
     * A−>0=002,C−>1=012,G−>2=102,T−>3=112A -> 0 = 00_2, \quad C -> 1 = 01_2, \quad G -> 2 = 10_2, \quad T -> 3 = 11_2A−>0=002​,C−>1=012​,G−>2=102​,T−>3=112​。
     *
     * GAAAAACCCCCAAAAACCCCCCAAAAAGGGTTT -> 200000111110000011111100000222333。
     *
     * 计算第一个序列的掩码：200000111。序列中的每个数字（0、1、2 或 3）占用的位不超过2位：
     *
     * 0=002,1=012,2=102,3=1120 = 00_2, \quad 1 = 01_2, \quad 2 = 10_2, \quad 3 = 11_20=002​,1=012​,2=102​,3=112​
     *
     * 因此，可以在循环中计算掩码：
     *
     *     左移以释放最后两位：bitmask <<= 2。
     *     将当前数字存储到 2000001111 的后两位：bitmask |= nums[i]。
     *
     */
    public static void findRepeatedDnaSequencesBitManiputation(){

    }
}
