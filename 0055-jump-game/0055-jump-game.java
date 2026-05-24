// class Solution {
//     public boolean canJump(int[] nums) {
//         int size = nums.length;
//         if(size == 1) return true;

//         int arr[] = new int[size];
//         Arrays.fill(arr,0);
//         arr[0] = 1;


//         for(int i=0; i<size; i++){

//             if(arr[i]==0) return false;

//             int val = nums[i];

//             for(int j=1; j<=val && (i+j)<=size-1; j++){
//                 if((i+j) == size-1)
//                     return true;
//                 arr[i+j]++;
//             }

//         }

    
//         return false;
//     }
// }


//      N^2


// class Solution {
//     public boolean canJump(int[] nums) {

//         int size = nums.length;
//         if(size == 1) return true;
//         int possible = 0;

//         for(int i=0; i<size; i++){
//             if(i>possible) return false;
//             possible = Math.max(possible, i+nums[i]);

//             if(possible>=size-1) return true;
//         }
//         return false;
//     }
// }


class Solution {
    public boolean canJump(int[] nums) {
        int size = nums.length;
        if(size == 1)return true;

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
                        return true;

                    if(arr[index+j] == 0){    
                        arr[index+j]=1;
                        q.add(index+j);
                    }

                }

            }
            jump++;

        }

        return false;
    }
}