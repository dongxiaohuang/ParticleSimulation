package simulation;

public class ParticleWallCollision extends Collision{
    Wall wall;
  /**
   * Constructor for ParticleWallCollision.
   */
   public ParticleWallCollision(Particle ps, Wall w, double t){

     super(t, new Particle[]{ps});
     wall = w;
   }

   /**
    * When Particle-Wall Collisions event happen, update the particle state and tell the ParticleEventHandler to react
    */
   public void happen(ParticleEventHandler h){
     Particle.collide(this.getParticles()[0], wall);
     h.reactTo(this);
   }

}
