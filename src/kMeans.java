import java.util.ArrayList;

/**
 * Created by esso on 10.03.15.
 */
public class kMeans {

    private ArrayList<Cluster> clusters;
    private ArrayList<DataPoint> dataPoints;

    public kMeans(ArrayList<DataPoint> dataPoints, ArrayList<DataPoint> initialCentroids){
        this.dataPoints = dataPoints;
        setupClusters(initialCentroids);

        System.out.println("Datapoints: " + dataPoints);
        System.out.println("Starting clusters: " + clusters);

        kMeans();
    }

    private void setupClusters(ArrayList<DataPoint> initialCentroids) {
        clusters = new ArrayList<Cluster>();
        for (int i = 0; i < initialCentroids.size(); i++){
            Cluster cl = new Cluster(initialCentroids.get(i));
            clusters.add(cl);
        }
    }

    private void kMeans(){
        int loopCount = 0;
        do {
            for (int i = 0; i < dataPoints.size(); i++){
                double leastDistance = 1000000;
                Cluster bestCluster = null;
                for (int j = 0; j < clusters.size(); j++){
                    double newDist = calculateDistance(clusters.get(j).getCentroid(), dataPoints.get(i));
                    if (newDist < leastDistance){
                        leastDistance = newDist;
                        bestCluster = clusters.get(j);
                    }
                }
                bestCluster.add(dataPoints.get(i));
            }
            System.out.println("Loop number " + loopCount + " with result: ");
            System.out.println(clusters);

            recalcAllCentroids();
            loopCount += 1;
            emptyClusters();

        }while(!allCentroidsStable());

        System.out.println(clusters);

    }

    private void emptyClusters() {
        for (int i = 0; i < clusters.size(); i++){
            clusters.get(i).clearClusterEntries();
        }
    }

    private void recalcAllCentroids() {
        for (int i = 0; i < clusters.size(); i++){
            clusters.get(i).recalcCentroid();
        }
    }

    private boolean allCentroidsStable() {
        for (int i = 0; i < clusters.size(); i++){
            if (clusters.get(i).getCentroid().getValue() != clusters.get(i).getLastCentroid().getValue() ){
                return false;
            }
        }
        return true;
    }

    private double calculateDistance(DataPoint A, DataPoint B){
        return Math.abs(A.getValue() - B.getValue());
    }

}
