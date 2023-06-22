package com.mmc.pages;

import com.mmc.api.AAPIProcessor;
import com.mmc.api.HTTPApiResponce;
import com.mmc.backend.HTTPProcessor;
import com.mmc.db.DB1;
import com.mmc.db.Db;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import org.json.*;

public class Login extends AAPIProcessor {

    public Login(HttpExchange t) {
        super(t);
    }

    @Override
    public HTTPApiResponce processRequest() throws UnsupportedEncodingException, IOException, ClassNotFoundException, SQLException {
        DB1 db = new DB1();
        JSONObject requestBodyJson=getrequestBodyString();
        return new HTTPApiResponce(db.runAction("sec_login", null, requestBodyJson));

    }
}




        /* String ipAddress = t.getRemoteAddress().getAddress().getHostAddress();
        System.out.println("IP ADDRESS="+ipAddress);
        JSONObject reqJsonObj = getrequestBodyString();
        HTTPProcessor.sessionMap.put("aaaaa", "vvvvv");
        Db db = new Db();
        String sessionID = db.getSessi(facelonID(reqJsonObj.getString("username"), reqJsonObj.getString("password"));
        if (sessionID == null) {
            return new HTTPApiResponce("ERROR", "Invalid user/passwordX.", "{}");
        }*/