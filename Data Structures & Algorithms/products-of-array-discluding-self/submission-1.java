class Solution {
    public int[] productExceptSelf(int[] nums) {
        Set<Integer> zeroIndices = new HashSet<>();
        var res = new int[nums.length];
        Arrays.fill(res,0);
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0) zeroIndices.add(i);
        }
        if(zeroIndices.size()>1){
            return res;
        }
        int product = 1;
        if(zeroIndices.size() == 1){
            int skip = zeroIndices.iterator().next();
            for(int i =0; i<nums.length; i++){
                if(i==skip) continue;
                product *= nums[i];
            }
            res[skip] = product;
            return res;
        }
        
        for(int i =0; i<nums.length; i++){
         product *= nums[i];
        }
        final int prod = product; //lambda var must be final
        Arrays.setAll(res, i->prod/nums[i]);
        return res;
        }
    }
 
