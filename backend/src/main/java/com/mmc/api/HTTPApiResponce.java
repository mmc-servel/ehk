package com.mmc.api;

import com.mmc.api.utils.Convert;
import org.json.*;

public class HTTPApiResponce {

    JSONObject responce;

    public HTTPApiResponce(String status, String message, String data) {
        responce = Convert.getInstance().stringToJson("{\"responce\":\"" + status + "\",\"message\":\"" + message + "\",\"data\":" + data + "}");
    }

    public JSONObject getResponeString() {
        System.out.println("    ResponceJSON=" + responce);
        return responce;
    }
}
