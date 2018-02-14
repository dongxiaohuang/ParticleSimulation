package simulation;

import java.awt.List;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import utils.MinPriorityQueue;

public class ParticleSimulation implements Runnable, ParticleEventHandler{

    private static final long FRAME_INTERVAL_MILLIS = 40;

    private final ParticlesModel          model;
    private final ParticlesView           screen;
    private MinPriorityQueue			  mpq;
    private double 						  clock;

    /**
     * Constructor.
     */
    public ParticleSimulation(String name, ParticlesModel m) {
        // TODO implement constructor
    	clock = 0;
    	model = m;
    	screen = new ParticlesView(name, m);
    	mpq = new MinPriorityQueue<Event>();
    	mpq.add(new Tick(1));

    	Iterable<Collision> cs = model.predictAllCollisions(clock); // intialize 0??
    	for(Collision c: cs){
	    mpq.add(c);
    	}

    }

    /**
     * Runs the simulation.
     */
    @Override
    public void run() {
        try {
            SwingUtilities.invokeAndWait(screen);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO complete implementing this method
        while(!mpq.isEmpty()) {

	    //        	if (mpq.isHalfFull()) {
	    //        		mpq.doubleQSize();
	    //        	}

	    Event event = (Event) mpq.remove();
	    if (event.isValid()) {
		System.out.print("fucking2\n");
		if (event instanceof Tick) {
		    System.out.print("shit");
		}
		double preClock = clock;
		clock = event.time();
		System.out.print(clock);
		model.moveParticles(clock - preClock);
		event.happen(this); // eventhandler??
	    }
        }
    }

    @Override
    public void reactTo(Tick tick) {
	// TODO Auto-generated method stub
	try {
	    Thread.sleep(FRAME_INTERVAL_MILLIS);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	screen.update();
	System.out.print(tick.time() + 1);
	mpq.add(new Tick(tick.time() + 1));
    }

    @Override
    public void reactTo(Collision c) {
	// TODO Auto-generated method stub
	Particle[] particles = c.getParticles();
	for(Particle p: particles) {
	    Iterable<Collision> cs = model.predictCollisions(p, c.time());
	    for(Collision newc: cs) {
		mpq.add(newc);
	    }
	}

    }

}
