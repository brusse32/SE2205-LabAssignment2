import java.lang.*;

public class QueueSimulator {
    public enum Event {ARRIVAL, DEPARTURE};
    private double currTime;
    private double arrivalRate;
    private double serviceTime;
    private double timeForNextArrival;
    private double timeForNextDeparture;
    private double totalSimTime;
    LinkedListQueue<Data> buffer = new LinkedListQueue<Data>();
    LinkedListQueue<Data> eventQueue = new LinkedListQueue<Data>();
    private Event e;

    public double getRandTime(double arrivalRate) {
        double num, time1, max = 1, min = 0, randNUM;
        randNUM = Math.random();
        time1 = (-1 / arrivalRate) * (Math.log(1 - randNUM));
        //System.out.println(time1);
        return time1;
    }

    public QueueSimulator(double aR, double servT, double simT) {
        arrivalRate = aR;
        serviceTime = servT;
        totalSimTime = simT;
        currTime = 0;
        timeForNextArrival = getRandTime(arrivalRate);
        timeForNextDeparture = serviceTime;
    }

    public double calcAverageWaitingTime() {
        double combinedTime = 0;
        for(int i = 0; i < eventQueue.size(); i++){
            Data curr = eventQueue.dequeue();
            combinedTime+=(curr.getDepartureTime()-curr.getArrivalTime());
        }
        return combinedTime/eventQueue.size();
    }

    public double runSimulation() {
        while(currTime < totalSimTime){
            e = (timeForNextArrival < timeForNextDeparture)||buffer.isEmpty() ? Event.ARRIVAL : Event.DEPARTURE;
            switch (e){
                case ARRIVAL:{
                    currTime+=timeForNextArrival;
                    if(!buffer.isEmpty())
                        timeForNextDeparture-=timeForNextArrival;
                    Data d = new Data();
                    d.setArrivalTime(currTime);
                    buffer.enqueue(d);
                    timeForNextArrival = getRandTime(arrivalRate);
                    break;
                }
                case DEPARTURE:{
                    currTime+=timeForNextDeparture;
                    timeForNextArrival-=timeForNextDeparture;
                    Data d = buffer.dequeue();
                    d.setDepartureTime(currTime);
                    eventQueue.enqueue(d);
                    timeForNextDeparture = serviceTime;
                    break;
                }
            }
        }
        return calcAverageWaitingTime();
    }
}






