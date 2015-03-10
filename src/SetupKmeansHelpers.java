import java.util.ArrayList;

/**
 * Created by esso on 10.03.15.
 */
public class SetupKmeansHelpers {


    public static ArrayList<DataPoint> createDatapoints(String names, double[] nums){
        ArrayList<DataPoint> dp = new ArrayList<DataPoint>();
        for (int i = 0; i < nums.length; i++){
            DataPoint d = new DataPoint(names.charAt(i), nums[i]);
            dp.add(d);
        }
        return dp;
    }

}
