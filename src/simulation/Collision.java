package simulation;

public abstract class Collision extends AbstractEvent{
    private Particle[] particles;
    private int[] hits;
    /**
     * Constructor for Collision
     */
    public Collision(double t, Particle[] ps) {
        // TODO implement constructor
        super(t);
        particles = ps;
	hits = new int[ps.length];
	for (int i=0; i<ps.length; i++) {
	    hits[i] = ps[i].collisions();
	}
    }

    /**
     * Returns true if this Collision is (still) valid.
     */
    @Override
    public boolean isValid() {
        for(int i=0; i<particles.length; i++) {
	    System.out.print("particles");
	    if (particles[i].collisions() != hits[i])
		return false;
	}
	return true;
    }

    /**
     * Returns an array containing the Particles involved in this Collision.
     */
    public Particle[] getParticles() {
        // TODO implement this method

        return particles;
    }
}
