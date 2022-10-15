package com.mmc.api;

import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.json.*;
import com.mmc.api.utils.Convert;

public abstract class AAPIProcessor {

    public final HttpExchange t;

    public AAPIProcessor(HttpExchange t) {
        this.t = t;
    }

    abstract public HTTPApiResponce processRequest() throws Exception;

    protected JSONObject getrequestBodyString() throws UnsupportedEncodingException, IOException {
        InputStreamReader isr = new InputStreamReader(t.getRequestBody(), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        int b;
        StringBuilder buf = new StringBuilder(10000);
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }
        br.close();
        isr.close();
        System.out.println("    RequestJSON="+buf.toString());
        return Convert.getInstance().stringToJson(buf.toString());
    }
}
