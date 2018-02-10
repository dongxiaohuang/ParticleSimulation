package simulation;

public abstract class Collision extends AbstractEvent{
    protected Particle[] particles;
    /**
     * Constructor for Collision
     */
    public Collision(double t, Particle[] ps) {
        // TODO implement constructor
        super(t);
        particles = ps;

    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        // TODO implement his method
        for(int i =0; i < particles.length; i++)
        {
          if(!particles[i].isValid())
            return false;
        }
        return true;
    }

    /**
     * Returns an array containing the Particles involved in this Collision.
     */
    public Particle[] getParticles() {
        // TODO implement this method

        return null;
    }
}
