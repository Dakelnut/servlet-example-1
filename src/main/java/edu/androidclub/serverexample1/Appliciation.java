package edu.androidclub.serverexample1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Dakelnut on 09.03.2017.
 */
public class Appliciation implements Runnable{
    private final Server jetty;
    private static  final int  JETTY_PORT = 8080;
    private static Appliciation app;


    public Appliciation(){
        this.jetty = new Server(JETTY_PORT);
    }

    public  static void  main(String[] args){
        app = new Appliciation();
        app.init();
        app.run();

    }
    private  void  init(){
        ServletContextHandler servletHandler = new ServletContextHandler(
            ServletContextHandler.SESSIONS
                );
        servletHandler.addServlet(new ServletHolder(new TestServlet()), TestServlet.PATH);
        jetty.setHandler(servletHandler);

    }


    @Override
    public void run(){
        if (jetty != null && !jetty.isStarted()){
            try{
                jetty.start();
                System.out.println("Server`s started on port "+JETTY_PORT);
                jetty.join();
            } catch (Exception ex){
                System.err.println(ex);
                System.exit(0);
            }
        }else {
            throw new RuntimeException("Jetty not ready");}
    }
}


