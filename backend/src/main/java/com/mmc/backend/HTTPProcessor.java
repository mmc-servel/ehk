package com.mmc.backend;

import com.mmc.api.*;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HTTPProcessor implements HttpHandler {

    public static HashMap<String, String> sessionMap = new HashMap<String, String>();
    private int i = 0;

    @Override
    public void handle(HttpExchange t) {
        i++;
        String fileName = t.getRequestURI().toString();
        System.out.println("Start processing req:(" + i + ") " + fileName);
        if (fileName.startsWith("/api")) {
            processApi(t);
        } else {
            processReact(t);
        }
        System.out.println("End processing req:(" + i + ") " + fileName);
    }

    private void processApi(HttpExchange t) {
        try {
            //TO DO: t.getRequestMethod() return error in case of GET method
            sendResponce(t,200, HTTPApi.getProcessor(t).processRequest().getResponeString().toString().getBytes(), "application/json");
        } catch (Exception ex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
            HTTPApiResponce vvv = new HTTPApiResponce("ERROR", "Request error. Check server logs.", "{}");
            sendResponce(t,200, vvv.getResponeString().toString().getBytes(), "application/json");
        }

    }

    private void sendResponce(HttpExchange t,int httpStatus, byte[] msg, String contentType) {
        OutputStream os = t.getResponseBody();
        if (contentType != null) {
            //t.getResponseHeaders().put("Content-Type", Collections.singletonList(contentType));
            t.getResponseHeaders().set("Content-Type", contentType);
        }
        try {
            t.sendResponseHeaders(httpStatus, msg.length);
            os.write(msg, 0, msg.length);
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void processReact(HttpExchange t) {
        try {

            String fileName = t.getRequestURI().toString();
            if (fileName.equals("/") || !fileName.startsWith("/static")) {
                fileName = "/index.html";
            }
            

            fileName = "WEB-INF" + fileName.replace("/test", "");
            System.out.println("    FileName=" + fileName);
            InputStream is = MainClass.class.getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                String errorMessage = "    ERROR: The file " + fileName + " not found.";
                System.out.println(errorMessage);
                sendResponce(t,404, errorMessage.getBytes(), "text/plain");
                return;
            }
            byte[] fileData = new byte[1024 * 1024];
            int nRead;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            while ((nRead = is.read(fileData, 0, fileData.length)) != -1) {
                bos.write(fileData, 0, nRead);
            }
            is.close();
            String contentType=fileName.endsWith(".js")?"text/javascript":"";
            sendResponce(t,200, bos.toByteArray(), contentType);
        } catch (IOException eex) {
            Logger.getLogger(HTTPProcessor.class.getName()).log(Level.SEVERE, null, eex);
        }
    }

}
