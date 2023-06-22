package com.mmc.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

public class DB1 {

    public String runAction(String actionName, String sessionid, JSONObject json) {
        String arguments = "p_sessionid=>?,";
        JSONArray key = json.names();
        for (int i = 0; i < key.length(); ++i) {
            arguments = arguments + "p_" + key.getString(i) + "=>?,";
        }
        arguments = arguments.substring(0, arguments.length() - 1);//remove last comma

        try {
            Class.forName("org.postgresql.Driver");
            try ( Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/housemanager", "housemanager", "POIqwe#123");  
                    CallableStatement dbFunction = conn.prepareCall("{ ? = call " + actionName + "(" + arguments + ") }")) {
                dbFunction.registerOutParameter(1, Types.VARCHAR);
                dbFunction.setString(2, sessionid);
                for (int i = 0; i < key.length(); ++i) {                    
                    String keys = key.getString(i);
                    dbFunction.setString(i + 3, json.getString(keys));
                }
                dbFunction.execute();
                return dbFunction.getString(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB1.class.getName()).log(Level.SEVERE, null, ex);
            return "{\"responce\":\"ERROR\",\"message\":\"Generic error (checl application logs).\"}";
        }
    }

}