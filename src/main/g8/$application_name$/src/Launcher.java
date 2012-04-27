import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

public class Launcher {
  static final Logger LOG = LoggerFactory.getLogger(Launcher.class);

  public static void main(String[] args) throws Exception {
    Server server = new Server();
    SelectChannelConnector connector = new SelectChannelConnector();
    connector.setPort(8080);
    server.addConnector(connector);

    WebAppContext webapp = new WebAppContext("webapp", "/");
    // Prevent file locking on Windows; pick up file changes.
    webapp.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
    server.setHandler(webapp);

    server.start();
    LOG.info("Server started");
  }
}