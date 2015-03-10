import java.util.ArrayList;

/**
 * Created by esso on 10.03.15.
 */
public class MainProgram {

    public static void main(String args[]){
        double[] values = {5, 2, 0, 7, 2, 10, 3, 4, 6, 1};
        double[] c1 = {2.0, 5.0};
        double[] c2 = {2.0, 6.0, 8.0};

        System.out.println("k-Means with initial centroids 2.0, 5.0");
        runKmeans(values, c1);

        System.out.println("k-Means with initial centroids: 2.0, 6.0, 8.0");
                runKmeans(values, c2);
    }

    private static void runKmeans(double[] values, double[] initialCentroids){
        ArrayList<DataPoint> dataPoints = SetupKmeansHelpers.createDatapoints("ABCDEFGHIJKLMNO", values);
        ArrayList<DataPoint> centroids = SetupKmeansHelpers.createDatapoints("12345", initialCentroids);

        kMeans k = new kMeans(dataPoints, centroids);

    }

}
