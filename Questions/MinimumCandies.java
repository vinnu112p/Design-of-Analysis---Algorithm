class MinimumCandies{
    
    static int minimumCandies(int rating[]){
        int result[] = {1,1,1,1,1,1,1,1,1};
        int candy = 0;
        
        for(int i = 1; i < result.length; i++){
            if (rating[i] > rating[i-1]){
                result[i] = result[i-1] + 1;
            }
        }
        
        for(int i = result.length-2; i >= 0; i--){
            if (rating[i] > rating[i+1]){
                result[i] = Math.max(result[i],result[i+1]+1);
            }
        }
        
        for(int num : result){
            candy  = candy + num;
        }
        
        return candy;
    }
    
    public static void main(String arg[]){
        int rating[] = {1,0,2,4,1,1,0,2,4};
        int rat[] = {3,4,1,0,2,3,1,2,1};
        
        System.out.println(minimumCandies(rating));
        System.out.println(minimumCandies(rat));
        
       
      
    }
}