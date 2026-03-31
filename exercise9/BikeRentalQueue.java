import java.util.LinkedList;
import java.util.Queue;


public class BikeRentalQueue {

    private Queue<BikeRequest> requestQueue;


    public BikeRentalQueue() {

        requestQueue = new LinkedList<>();
    }


    public void enqueueRequest(BikeRequest request) {
        requestQueue.offer(request);
    }


    public BikeRequest processNextRequest() {
        return requestQueue.poll();
    }


    public boolean isQueueEmpty() {
        return requestQueue.isEmpty();
    }

    
    public int getQueueSize() {
        return requestQueue.size();
    }
}