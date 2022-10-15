
package com.mmc.api;

import com.sun.net.httpserver.HttpExchange;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class HTTPApi {

    final static HashMap<String, String> PROCESSORLIST = new HashMap<String, String>();

    static {
        PROCESSORLIST.put("/api/login", "com.mmc.pages.Login");
        PROCESSORLIST.put("/api/products", "com.mmc.pages.Products");
        PROCESSORLIST.put("/api/products/delete", "com.mmc.pages.ProductDelete");
    }

    public static AAPIProcessor getProcessor(HttpExchange t) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {        
        Class<?> cls = Class.forName(PROCESSORLIST.get(t.getRequestURI().toString())==null?"com.mmc.errors.InvalidUrl":PROCESSORLIST.get(t.getRequestURI().toString()));
        Constructor<?> cons = cls.getConstructor(HttpExchange.class);
        return (AAPIProcessor) cons.newInstance(t);
    }
}

