class Solution {
    public int jump(int[] nums) {
        int size = nums.length;
        if(size == 1)return 0;

        int arr[] = new int[size];
        Arrays.fill(arr,0);
        arr[0] = 1;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int jump = 0;

        while(!q.isEmpty()){

            int qsize = q.size();
            for(int i=0; i<qsize; i++){

                int index = q.poll();
                int val = nums[index];

                for(int j=1; j<=val && (index+j)<=size-1; j++){
                    if(index + j == size - 1)
                        return jump + 1;

                    if(arr[index+j] == 0){    
                        arr[index+j]=1;
                        q.add(index+j);
                    }

                }

            }
            jump++;

        }

        return -1;
    }
}