// Time Complexity : O(mlogn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int shortestWay(String source, String target) {
        int i = 0, pos = 0, count = 1;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for(int j = 0; j < source.length(); j++) {
            char ch = source.charAt(j);
            
            if(!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
            }
               
           map.get(ch).add(j);
        }
                
        while(i < target.length()) {
            char ch = target.charAt(i);
            
            if(!map.containsKey(ch)) {
                return -1;
            }

            List<Integer> list = map.get(ch);
            
            int k = Collections.binarySearch(list, pos);
            
            if(k < 0) {
                k = -k - 1;
            }
            
            if(k == list.size()) {
                pos = 0;
                count++;
            } else {
                pos = list.get(k) + 1;
                i++;
            }
        }
        
        return count;
    }
}