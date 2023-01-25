package com.javastream.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javastream.entity.Contact;
import com.javastream.entity.Deal;
import com.javastream.entity.Lead;
import com.javastream.entity.model.chat.User;
import com.javastream.uriParamsCreator.UriParamsCreator;
import com.javastream.utils.PushRunner;
import com.javastream.utils.chat.ParamChatUtils;
import com.javastream.utils.deal.ParamDealUtils;
import com.javastream.utils.lead.ParamLeadUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * ContactService.
 *
 * @author javastream
 */
public class DealService {

    private Logger logger = LoggerFactory.getLogger(DealService.class);

    private final static String GET_METHOD = "crm.deal.get";
    private final static String LIST_METHOD = "crm.deal.list";
    private final static String GET_CONTACT_METHOD = "crm.deal.contact.items.get";

    public Deal get(Integer idDeal) {
        logger.info("Request: Get the deal by id: {}", idDeal);
        UriParamsCreator params = new ParamDealUtils().getMethod(idDeal);
        JSONObject jsonMain = PushRunner.get(params, GET_METHOD);
        JSONObject jsonResult = jsonMain.getJSONObject("result");
        Gson gson = new Gson();
        return gson.fromJson(jsonResult.toString(), Deal.class);
    }

    public List<Deal> getAll() {
        logger.info("Request: Get list of deals");
        UriParamsCreator params = new ParamDealUtils().getAllMethod();
        JSONObject json = PushRunner.get(params, LIST_METHOD);
        JSONArray result = json.getJSONArray("result");
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Deal>>(){}.getType();
        return gson.fromJson(result.toString(), type);
    }

    public List<Contact> getContactFromDeal(Integer idDeal) {
        logger.info("Request: Get the deal by id: {}", idDeal);
        UriParamsCreator params = new ParamDealUtils().getMethod(idDeal);
        JSONObject json = PushRunner.get(params, GET_CONTACT_METHOD);
        JSONArray result = json.getJSONArray("result");
        Gson gson = new Gson();

        Type type = new TypeToken<ArrayList<Contact>>(){}.getType();
        return gson.fromJson(result.toString(), type);
    }
}
