package org.exoplatform.addons.storage.listener;

import org.exoplatform.addons.storage.services.jcr.SchedulerService;
import org.quartz.SchedulerException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class SchedulerManager implements ServletContextListener {

  private static SchedulerService schedulerService;
  private static Logger log = Logger.getLogger("SchedulerManager");

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    log.info("INITIALIZING SCHEDULER");
    schedulerService = new SchedulerService();
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    log.info("CLOSING SCHEDULER");

    try {
      schedulerService.shutdown();
    } catch (SchedulerException e) {
      log.warning("for some reasons, Scheduler didn't want to stop");
    }

  }

}
