package simulation;

public abstract class AbstractEvent implements Event {
    private double _time;
    /**
     * Constructor for AbstractEvent.
     */
    public AbstractEvent(double time) {
        // TODO implement the constructor
        this._time = time;

    }

    /**
     * Returns the time (in ticks) at which this event will occur.
     */
    @Override
    public double time() {
        // TODO implement this method
        return _time;
    }

    /**
     * Compares this object with the specified Event.
     */
    @Override
    public int compareTo(Event that) {
        // TODO implement this method
        if(_time < that.time())
          return -1; // less priority
        else if(_time > that.time())
          return 1; // high priority
        return 0;
    }

}
