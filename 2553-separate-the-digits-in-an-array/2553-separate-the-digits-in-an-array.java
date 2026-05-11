class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        List<Integer> ans = new ArrayList<>();
        int index = 0;
        int start = 0;

        for(int i =0; i<n; i++){
            int digit = nums[i];
            start = index;
            while(digit>0){
                int r = digit%10;
                ans.add(r);
                digit= digit/10;
                index++;
            }

            Collections.reverse(ans.subList(start, index));


        }
        
        int size = ans.size();
        int arr[] = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = ans.get(i);
        }

        return arr;
    }
}