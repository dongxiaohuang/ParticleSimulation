package simulation;

public class ParticleWallCollision extends Collision{
  Wall wall;
  /**
   * Constructor for ParticleWallCollision.
   */
   public ParticleWallCollision(double t, Particle ps, Wall w){
     super(t, ps);
     wall = w;
   }

   /**
    * When Particle-Wall Collisions event happen, update the particle state and tell the ParticleEventHandler to react
    */
   public void happen(ParticleEventHandler h){
     h.reactTo(this);
     Particle.collide(particles[0], wall);
   }

}
