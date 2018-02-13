package simulation;

public class TwoParticleCollision extends Collision{
  /**
   * Constructor for ParticleWallCollision.
   */
    public TwoParticleCollision(Particle p1, Particle p2, double t){
	super(t, new Particle[]{p1, p2});
	
   }

   /**
    * When Particle-Wall Collisions event happen, update the particle state and tell the ParticleEventHandler to react
    */
   public void happen(ParticleEventHandler h){
       h.reactTo(this);
       Particle.collide(this.getParticles[0], this.getParticles[1]);
   }

}
