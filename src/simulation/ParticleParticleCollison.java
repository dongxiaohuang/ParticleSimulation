package simulation;

public class ParticleParticleCollision extends Collision{
  /**
   * Constructor for ParticleWallCollision.
   */
   public ParticleParticleCollision(double t, Particle[] ps){
     super(t, ps);
   }

   /**
    * When Particle-Wall Collisions event happen, update the particle state and tell the ParticleEventHandler to react
    */
   public void happen(ParticleEventHandler h){
     h.reactTo(this);
     Particle.collide(particles[0], particles[1]);
   }

}
