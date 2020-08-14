package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode ：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * */

public class LengthOfLongestSubstring {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int res = 0;
//            boolean[] remark = new boolean[256];
            Set<Character> remark = new HashSet<>(s.length());
            int left = 0, right = 0;
            char temp;
            while(right < s.length()){
                temp = s.charAt(right);
                if (remark.contains(temp)){
                    res = (right-left) > res? (right-left) : res;
                    while(s.charAt(left) != temp){
                        remark.remove(s.charAt(left));
                        left ++;
                    }
                    remark.remove(s.charAt(left));
                    left ++;
                }
                remark.add(s.charAt(temp));
                right ++;
            }
            res = (right-left) > res? (right-left) : res;
            return res;
        }
    }

    public static void main(String[] args) {
        String str = " ";
        new Solution().lengthOfLongestSubstring(str);
    }

}
