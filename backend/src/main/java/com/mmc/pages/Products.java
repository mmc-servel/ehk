
package com.mmc.pages;

import com.mmc.api.AAPIProcessor;
import com.mmc.api.HTTPApiResponce;
import com.mmc.backend.HTTPProcessor;
import com.mmc.db.Db;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import org.json.JSONObject;

public class Products extends AAPIProcessor {
    
    public Products(HttpExchange t) {
        super(t);
    }
    
    @Override
    public HTTPApiResponce processRequest() throws UnsupportedEncodingException, IOException, ClassNotFoundException, SQLException {
            JSONObject reqJsonObj= getrequestBodyString();
            Db db = new Db();
            String productTable = db.getProductTable();
            return new HTTPApiResponce("OK", "Product table.", productTable);
    }  
}
