class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> (map.get(b) - map.get(a)));
        pq.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 1){
            char ch1 = pq.remove();
            char ch2 = pq.remove();
            sb.append(ch1);
            sb.append(ch2);
            map.put(ch1, map.get(ch1) - 1);
            map.put(ch2, map.get(ch2) - 1);
            
            if(map.get(ch1) > 0){
                pq.add(ch1);
            }
            if(map.get(ch2) > 0){
                pq.add(ch2);
            }
        }
        if(pq.size() > 0){
            char ch = pq.poll();
            if(map.get(ch) > 1){
                return "";
            }
            sb.append(ch);
        }
        
        return sb.toString();
    }
}
