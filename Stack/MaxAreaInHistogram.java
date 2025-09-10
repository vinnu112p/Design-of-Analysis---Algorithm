import java.util.Stack;
public class MaxAreaInHistogram{

    public static int largeArea(int height[]){

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;


        int nsl[] = new int[height.length];   // Next smaller left  // 2,1,5,6,8,3

        for(int i = 0; i < height.length; i++){
            while(!st.isEmpty() && height[i] < height[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                nsl[i] = -1;
            }else{
                nsl[i] = st.peek();
            }
            st.push(i);
        }



        



        int nsr[] = new int[height.length];     // next smaller right

        for(int i = height.length-1; i >= 0; i--){

            while(!st.isEmpty() && height[i] < height[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                nsl[i] = height.length;
            }else{
                nsl[i] = height[st.peek()];
            }

            st.push(i);

        }

        for(int i = 0; i < height.length; i++){
            int currarea  = height[i]*(nsr[i]-nsl[i]-1);
            maxArea = Math.max(currarea,maxArea);
        }

    return maxArea;


    }

    public static void main(String[] args) {
        
        int height[] = {2,1,5,6,8,3};
        // int maxArea = Integer.MIN_VALUE;
       
        // int width = 1;

        // for(int i = 0; i < height.length; i++){
        //      int min = height[i];
        //     for(int j = i; j< height.length; j++){
        //         if(height[j] <= min){
        //             min = height[j];
        //         }
        //         int currArea = min*width;
        //         maxArea = Math.max(maxArea, currArea);
        //         width++;
        //     }
        //     min = 0;
        //     width = 1;
        // }

        // System.out.println(maxArea);

        System.out.println(largeArea(height));


    }

}