// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        if(tops == null || bottoms == null) {
            return 0;
        }
        
        int top = getRotations(tops, bottoms, tops[0]);
        
        if(top != -1) {
            return top;
        }
        
        return getRotations(tops, bottoms, bottoms[0]);
    }
    
    private int getRotations(int[] top, int[] bottom, int target) {
        
        int topRotations = 0, bottomRotations = 0;
        
        for(int i = 0; i < top.length; i++) {
            
            if(top[i] != target && bottom[i] != target) {
                return -1;
            }
            
            if(top[i] != target) {
                topRotations++;
            }
            
            if(bottom[i] != target) {
                bottomRotations++;
            }
        }
        
        return Math.min(topRotations, bottomRotations);
    }
}