public class Data {
    double arrivalTime;
    double departureTime;

    //Setting initial values
    public Data() {
        arrivalTime = departureTime = 0;
    }

    //Update arrival time
    public void setArrivalTime(double a) {
        arrivalTime = a;
    }

    //Update departure time
    public void setDepartureTime(double d) {
        departureTime = d;
    }

    //Returns current departure time
    public double getDepartureTime() {
        return departureTime;
    }

    //Returns current arrival time
    public double getArrivalTime() {
        return arrivalTime;
    }
}