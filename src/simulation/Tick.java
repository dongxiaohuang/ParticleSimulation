package simulation;

public class Tick extends AbstractEvent{

    /**
     * Constructor for Tick
     */
    public Tick(double time) {
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
     * When Tick event happen, make a callback to the ParticleEventHandler
     */
    public void happen(ParticleEventHandler h){
      h.reactTo(this);
    }
}
