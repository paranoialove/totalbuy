/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.totalbuy.web;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author PattyTai
 */
//@WebListener
public class LoginCountListener implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Totalbuy app start....");
        ServletContext application = sce.getServletContext();

        //讀回properties...
        Properties props = new Properties();
        String path = application.getRealPath("/WEB-INF/counter.properties");
        try (FileReader in = new FileReader(path);) {
            props.load(in);
            application.log("counters讀取檔案成功: " + path);
            
            //待續...            
            
        } catch (IOException ex) {
            System.out.println("無法讀取檔案:" + path);
            application.log("無法讀取檔案:" + path, ex);
        }    
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Totalbuy app stop....");
        ServletContext application = sce.getServletContext();

        Enumeration<String> names = application.getAttributeNames();
        Properties props = new Properties();

        while (names.hasMoreElements()) {
            String name = names.nextElement();
            if (name.indexOf("app.") == 0) {
                Object value = application.getAttribute(name);
                System.out.println(name + ":" + value);
                props.setProperty(name, value.toString());
            }
        }

        String path = application.getRealPath("/WEB-INF/counter.properties");
        try (FileWriter out = new FileWriter(path);) {
            props.store(out, "no comments");
            application.log("counters存檔成功: " + path);
        } catch (IOException ex) {
            System.out.println("無法存檔:" + path);
            application.log("無法存檔:" + path, ex);
        }

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
