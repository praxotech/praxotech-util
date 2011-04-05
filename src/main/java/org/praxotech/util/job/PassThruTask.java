/**
 * Copyright (c), 2008 - 2011, PraxoTech Org.
 */
package org.praxotech.util.job;

/**
 * @author fyang
 *
 * This task class can be used in a job containing tasks dynamically
 * created at runtime.  When a task created at runtime has dependency
 * on a task other than the creator task, a pass-through task can be
 * used as the trigger for the runtime task.  The pass-through task
 * needs to be dependent of the creator and dependency tasks.  Otherwise
 * the runtime task may never be triggered due to the reason that the
 * dependency task may complete before the runtime task is created.  In
 * such situation, the notification of completion of dependency task will
 * never reach the runtime task.  A guard task set up as above ensures
 * the notification be delivered to runtime tasks depending on it.
 * 
 */
public class PassThruTask extends Task {
  /**
   * This variable defines the lag time between start and end of the task.
   * The unit of measure is millisecond. The default value is 0, i.e.,
   * no lag time.
   */
  private int lagTime;

  /**
   * @param ctx
   */
  public PassThruTask(JobContext ctx) {
    super(ctx);
    lagTime = 0;
  }
  
  public PassThruTask(JobContext ctx, int lagTime) {
    super(ctx);
    this.lagTime = lagTime;
  }

  /* (non-Javadoc)
   * @see org.praxotech.util.job.management.Task#executeTask(org.praxotech.util.job.management.JobContext)
   */
  @Override
  protected boolean executeTask() {
    if (lagTime > 0) {
      try {
        wait(lagTime);
      }
      catch (InterruptedException e) {
        // No handling necessary
      }
    }
    
    return true;
  }

}
