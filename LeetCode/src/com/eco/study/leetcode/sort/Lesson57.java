package com.eco.study.leetcode.sort;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 *
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 *
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *  
 *
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals 根据 intervals[i][0] 按 升序 排列
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 *
 */
public class Lesson57 {
    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[] newInterval = {2,7};
        Solution57 solution = new Solution57();
        int[][] res = solution.insert(intervals,newInterval);
        for (int i = 0; i < res.length; i++) {
            for (int i1 = 0; i1 < res[i].length; i1++) {
                System.out.print(res[i][i1]+ ",");
            }
            System.out.println();
        }
    }
}

class Solution57 {
    public int[][] insert(int[][] intervals,int[] newInterval){
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> target = new LinkedList<>();
        for (int i = 0; i < intervals.length; i++) {
            target.add(intervals[i]);
        }
        target.add(newInterval);
        target.sort((x,y)->{
          return x[0]-y[0];
        });
        for (int i = 0; i < target.size()-1; i++) {
            int[] now = target.get(i);
            int[] next =target.get(i+1);
            // 当前小大于大 ， 当前 大小于小   跳过
            if(now[0] > next[1] || now[1] < next[0]){
                continue;
            }else {// 合并交集
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