package org.exoplatform.addons.persistence.services.mongodb;

import org.exoplatform.addons.persistence.services.NotificationService;
import org.exoplatform.addons.persistence.services.mongodb.NotificationServiceImpl;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.logging.Logger;

public class NotificationCleanupJob implements Job
{
  Logger log = Logger.getLogger("NotificationCleanupJob");
  @Override
  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    log.info("Job started");
    NotificationServiceImpl.cleanupNotifications();
    log.info("Job finished");
  }
}
