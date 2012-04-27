package ee.devclub.web;

import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JuliHandler implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    for (Handler handler : rootLogger.getHandlers()) {
      rootLogger.removeHandler(handler);
    }
    SLF4JBridgeHandler.install();
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
  }
}