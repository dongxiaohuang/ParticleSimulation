package simulation;

public class Ticks extends AbstractEvent{

    /**
     * Constructor for Ticks
     */
    public Ticks(double time) {
        // TODO implement constructor
        super(time);
    }

    /**
     * Returns true if this Tick is (still) valid.
     */
    @Override
    public boolean isValid() {
        // TODO implement his method
        return true;
    }

    /**
     * When Ticks event happen, make a callback to the ParticleEventHandler
     */
    public void happen(ParticleEventHandler h){
      h.reactTo(this);
    }
}
