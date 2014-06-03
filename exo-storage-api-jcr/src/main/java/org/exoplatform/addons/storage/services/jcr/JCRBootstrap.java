package org.exoplatform.addons.storage.services.jcr;

import org.exoplatform.addons.storage.listener.GuiceManager;
import org.exoplatform.addons.storage.services.NotificationService;
import org.exoplatform.container.PortalContainer;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.jcr.ext.app.SessionProviderService;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.logging.Logger;

public class JCRBootstrap {
  private static RepositoryService repositoryService_;
  private static SessionProviderService sessionProviderService_;

  private static Logger log = Logger.getLogger("JCRBootstrap");

  public static void init()
  {
    if (repositoryService_ == null)
    {
      log.warning("WE WILL NOW USE CHAT SERVER WITH JCR IMPLEMENTATION...");
      log.warning("BE AWARE...");
      log.warning("JCR IMPLEMENTATION SHOULD NEVER BE USED IN PRODUCTION!");
      PortalContainer portalContainer = PortalContainer.getInstance();
      repositoryService_ = (RepositoryService)portalContainer.getComponentInstanceOfType(RepositoryService.class);
      sessionProviderService_ = (SessionProviderService)portalContainer.getComponentInstanceOfType(SessionProviderService.class);
    }
  }

  public static Session getSession()
  {
    if (sessionProviderService_ == null) JCRBootstrap.init();

    Session session = null;
    try {
      session = sessionProviderService_.getSystemSessionProvider(null).getSession("collaboration", repositoryService_.getCurrentRepository());
    } catch (RepositoryException e) {
      e.printStackTrace();
    }

    return session;

  }

  public static void initChat()
  {
    Session session = getSession();

    try {
      Node rootNode = session.getRootNode();
      if (rootNode.hasNode("chat"))
      {
        Node chatNode = rootNode.getNode("chat");
        chatNode.remove();
        session.save();

        NotificationService notificationService = GuiceManager.getInstance().getInstance(NotificationService.class);
        if (notificationService instanceof NotificationServiceImpl)
        {
          ((NotificationServiceImpl)notificationService).initNodetypes();
          ((NotificationServiceImpl)notificationService).initMandatoryNodes();
        }

      }

    } catch (RepositoryException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }


  }

  public static void close() {
    repositoryService_ = null;
    sessionProviderService_ = null;
  }
}
