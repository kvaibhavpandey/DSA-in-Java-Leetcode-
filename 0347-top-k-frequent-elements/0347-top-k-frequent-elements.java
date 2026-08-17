class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int num : map.keySet()){
            int frequency = map.get(num);
            pq.add(new int[]{num, frequency});
            if(pq.size() > k){
                pq.poll();
            }
        }
        int [] result = new int[k];
        int index = 0;
        while (!pq.isEmpty()){
            result[index++]=pq.poll()[0];
        }
        return result;
    }
}