package com.eco.study.leetcode.sort;

import java.util.*;
import java.util.stream.Collector;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 提示：
 *
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 */
public class Lesson56 {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        Solution56 solution = new Solution56();
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            for (int i1 = 0; i1 < res[i].length; i1++) {
                System.out.print(res[i][i1]+ ",");
            }
            System.out.println();
        }
    }
}

class Solution56{

    public int[][] merge(int[][] intervals){

        if(intervals.length==1){
            return intervals;
        }
        List<int[]> target = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            target.add(intervals[i]);
        }
        target.sort((x,y)->{
            return x[0]-y[0];
        });


        for (int i = 0; i < target.size()-1; i++) {
            int[] now = target.get(i);
            int[] next = target.get(i+1);

            if(now[0] > next[1] || next[0] > now[1]){
                continue;
            }else {
                now[0] = Math.min(now[0],next[0]);
                now[1] = Math.max(now[1],next[1]);
                target.set(i,now);
                target.remove(i+1);
                i--;
            }
        }

        return target.toArray(new int[target.size()][]);
    }
}
