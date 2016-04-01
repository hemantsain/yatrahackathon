package com.yatra.yatrahackathon.webaccess;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ResponseParser {

    public static Object getdataFromResponse(WSActions RequestAction, JsonElement json) {

        switch (RequestAction) {

            case SAVE_USER:
                return Parser.saveUserParser((JsonObject) json);

            case SESSION_BEGIN:
                return Parser.sessionBeginParser((JsonObject)json);

            case SESSION_END:
                return Parser.sessionEndParser((JsonObject)json);

            case GET_NEWS_SINCE:
            case GET_TOP_NEWS:
                return Parser.getNewsSinceParser((JsonObject)json);

            case GET_NEWS_BEFORE:
                return Parser.getNewsBeforeParser((JsonObject)json);

            case SAVE_CARD:
                return Parser.saveCardParser((JsonObject)json);

            case GET_META_INFO:
                return Parser.getMetaData((JsonObject)json);

            case CATEGORY:
                return Parser.parseCategory((JsonObject)json);

            case TIME_SAVED:
                return Parser.parseTimeSaved((JsonObject)json);

            case USER_OPINION:
                return Parser.parseUserOpinionResult((JsonObject)json);

            case OPINION_COUNT_FOR_CARD:
                return Parser.parseGetOpinionCountForCard((JsonObject)json);

            case OPINION_COUNT_FOR_DEVICE_ID:
                return Parser.parseGetOpinionCountForDeviceId((JsonArray)json);

            case GET_LATEST_QUESTION:
                return Parser.getLatestOpinion((JsonObject)json);

            default:
                return "error:Action " + RequestAction + " is undefined";
        }
    }
}