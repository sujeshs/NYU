package edu.nyu.sdg.penalties.threadpool;

import edu.nyu.sdg.penalties.inputstream.file.SOANAFileLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public final class BlockingThreadPoolExecutor extends ThreadPoolExecutor {

  private static final Logger LOG = LoggerFactory.getLogger(SOANAFileLoader.class);

  private final Semaphore semaphore;

  public BlockingThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
  {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    semaphore = new Semaphore(corePoolSize + 50);
  }

  @Override
  protected void beforeExecute(Thread t, Runnable r)
  {
    super.beforeExecute(t, r);
  }

  @Override
  public void execute(final Runnable task)
  {
    boolean acquired = false;
    do
    {
      try
      {
        semaphore.acquire();
        acquired = true;
      } catch (final InterruptedException e)
      {
        //LOGGER.warn("InterruptedException whilst aquiring semaphore", e);
      }
    } while (!acquired);
    try
    {
      super.execute(task);
    } catch (final RejectedExecutionException e)
    {
      LOG.error("Task Rejected");
      semaphore.release();
      throw e;
    }
  }

  @Override
  protected void afterExecute(Runnable r, Throwable t)
  {
    super.afterExecute(r, t);
    if (t != null)
    {
      LOG.error(t.getMessage());
    }
    semaphore.release();
  }

}
