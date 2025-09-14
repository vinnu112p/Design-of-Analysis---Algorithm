
import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing{

    public static void main(String[] args) {
        
        int jobs[][] = {{4,20},{1,10},{1,40},{1,30}};

        Arrays.sort(jobs, Comparator.comparingDouble(o -> o[1]));

        int time = 0;
        int maxJob = 0;
        

        for(int i = jobs.length-1; i >= 0; i--){
            if(jobs[i][0] > time){
                time++;
                maxJob++;
            }
        }

        System.out.println("Max Job: " + maxJob);

    }

}