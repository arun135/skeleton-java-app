package com.develogical;

import com.develogical.web.ApiResponse;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.develogical.web.StatusPage;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlet.Source;

public class WebServer {

  public WebServer() throws Exception {

    Server server = new Server(portNumberToUse());

    ServletHandler handler = new ServletHandler();
    handler.addServletWithMapping(new ServletHolder(new RootPage()), "/*");
    handler.addServletWithMapping(new ServletHolder(new Api()), "/api/*");
    server.setHandler(handler);

    server.start();
  }

  static class Api extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String query = req.getParameter("q");
      new ApiResponse(new QueryProcessor().process(query)).writeTo(resp);
      //at=info method=GET path="/api?q=31482c70:%20what%20is%20your%20name"
      // host=skeleton-java-app-arun.herokuapp.com
      // request_id=4cc6385f-6273-4f01-b3f7-7f060f17acf3 fwd="54.246.22.217" dyno=web.1 connect=0ms service=3ms status=200 bytes=183 protocol=https
    }
  }

  private static class RootPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      new StatusPage().writeTo(resp);
    }
  }

  private Integer portNumberToUse() {
    return System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 5000;
  }

  public static void main(String[] args) throws Exception {
    new WebServer();
  }
}