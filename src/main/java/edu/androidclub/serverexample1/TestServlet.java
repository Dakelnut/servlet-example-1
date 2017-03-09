package edu.androidclub.serverexample1;

import sun.net.httpserver.HttpServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dakelnut on 09.03.2017.
 */
public class TestServlet extends HttpServlet{

    public static final String PATH = "/test";
    private static final String VAl_NAME = "val";

    public TestServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            final String val = req.getParameter(VAl_NAME);
            PrintWriter responseWriter = resp.getWriter();
            responseWriter.append("INput val parametr = "+val);
            responseWriter.append("Stopping method");
            responseWriter.flush();

            super.doGet(req, resp);
    }
}
