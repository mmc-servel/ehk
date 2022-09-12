package com.mmc.errors;

import com.mmc.api.AAPIProcessor;
import com.mmc.api.HTTPApiResponce;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class InvalidUrl extends AAPIProcessor {

    public InvalidUrl(HttpExchange t) {
        super(t);
    }

    @Override
    public HTTPApiResponce processRequest() throws UnsupportedEncodingException, IOException {
        return new HTTPApiResponce("ERROR", "Ivalid request operation.", "{}");
    }

}
