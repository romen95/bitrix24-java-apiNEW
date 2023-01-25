package com.javastream.utils.deal;

import com.javastream.entity.Contact;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.MultiFields;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ParamDealUtils {
    private final static String ID = "id";
    private final static String SPACE_PARAM = "%20";

    public UriParamsCreator getMethod(Integer idDeal) {
        UriParamsCreator params = new UriParamsCreator();
        params.put(ID, idDeal.toString());
        params.build();
        return params;
    }

    public UriParamsCreator getAllMethod() {
        UriParamsCreator params = new UriParamsCreator();
        params.build();
        return params;
    }

    private String check(String field) {
        if (field == null) {
            return SPACE_PARAM;
        } else {
            return URLEncoder.encode(field.toString());
        }
    }
}