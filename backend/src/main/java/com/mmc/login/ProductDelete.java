
package com.mmc.login;

import com.mmc.api.AAPIProcessor;
import com.mmc.api.HTTPApiResponce;
import com.mmc.db.Db;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;

public class ProductDelete extends AAPIProcessor{
    public ProductDelete(HttpExchange t) {
        super(t);
    }
    @Override
    public HTTPApiResponce processRequest() throws Exception {
        JSONObject reqJsonObj = getrequestBodyString();
        Db db = new Db();
        db.deleteProduct(reqJsonObj.getInt("product_id"));
        return new HTTPApiResponce("OK", "Product delete success.", "{}");
    }
    
}
