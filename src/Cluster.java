import java.util.ArrayList;

/**
 * Created by esso on 10.03.15.
 */
public class Cluster {
    private DataPoint centroid;
    private DataPoint lastCentroid;
    private ArrayList<DataPoint> cluster;


    public Cluster(DataPoint c){
        cluster = new ArrayList<DataPoint>();
        this.centroid = c;
    }


    public boolean remove(DataPoint dp){
        return cluster.remove(dp);
    }

    public void recalcCentroid(){
        double sum = 0;
        for (int i = 0; i < cluster.size(); i++){
            sum += cluster.get(i).getValue();
        }
        lastCentroid = centroid;
        centroid = new DataPoint(lastCentroid.getName(), sum/cluster.size());
    }

    public DataPoint getLastCentroid(){
        return lastCentroid;
    }

    public DataPoint getCentroid() {
        return centroid;
    }

    public void setCentroid(DataPoint centroid) {
        this.centroid = centroid;
    }

    public ArrayList<DataPoint> getCluster() {
        return cluster;
    }

    public void add(DataPoint dp){
        cluster.add(dp);
    }

    public String toString(){
        if (cluster.size() == 0 ) {
            return "Centroid is: " + centroid + " and it is empty";
        }

        String clusterPoints = "";
        for (int i = 0; i < cluster.size(); i++ ){
            clusterPoints += cluster.get(i);
        }
        return "Cluster: " + centroid.getName() + " \n With centroid value: " + centroid.getValue() + " \n With datapoints "  + clusterPoints + "\n";
    }

    public void clearClusterEntries(){
        cluster = new ArrayList<DataPoint>(); // New object
    }
}
