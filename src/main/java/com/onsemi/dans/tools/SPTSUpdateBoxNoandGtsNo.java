package com.onsemi.dans.tools;

//import com.onsemi.dans.dao.WhRequestDAO;
//import com.onsemi.dans.model.WhRequest;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SPTSUpdateBoxNoandGtsNo {

    public static void main(String[] args) throws IOException, ParseException {

        System.out.println("HEllo here");
        /*
        //to insert box no to existing data
        WhRequestDAO whReqD = new WhRequestDAO();
        List<WhRequest> WhReq = whReqD.getWhRequestListForShipmentAndActive();

        for (int i = 0; i < WhReq.size(); i++) {

            //create boxNo to replace mpNo 140922
            DateFormat df = new SimpleDateFormat("yyMMdd");
            Date dateBox = new Date();
            String nowDate = df.format(dateBox);

            WhRequestDAO sampleReqDao = new WhRequestDAO();
            int max = sampleReqDao.getCountMaxBox(nowDate) + 1;

            String index = Integer.toString(max);
            if (index.length() == 1) {
                index = "000" + index;
            } else if (index.length() == 2) {
                index = "00" + index;
            } else if (index.length() == 3) {
                index = "0" + index;
            }
            String reqBoxNo = nowDate + index;

            WhRequest whReq = new WhRequest();
            whReq.setBoxNo(reqBoxNo);
            whReq.setGtsNo("0011011");
            whReq.setId(WhReq.get(i).getId());
            sampleReqDao = new WhRequestDAO();
            QueryResult queryResult = sampleReqDao.updateWhRequestActiveWithBoxNoAndGtsNo(whReq);
        }

//get item from sfitem
        System.out.println("GET SFITEM PCB QUAL A BY PARAM...");
        JSONObject paramsQualA = new JSONObject();
        paramsQualA.put("itemID", "Testing CDARS");
        paramsQualA.put("itemStatus", "0");
        JSONArray getItemByParamA = SPTSWebService.getItemByParam(paramsQualA);
//         JSONArray getItemByParamA = SPTSWebService.getItemTypeAll();
        System.out.println("COUNT GET ITEM BY PARAM..." + getItemByParamA.length());
        for (int i = 0; i < getItemByParamA.length(); i++) {
//            System.out.println(getItemByParamA.getJSONObject(i).getString("ItemID"));f
            System.out.println(getItemByParamA.getJSONObject(i));
        }
        int itempkid = getItemByParamA.getJSONObject(0).getInt("PKID");
        System.out.println("itempkid............." + itempkid);

        //                        //insert transaction spts
        JSONObject params2 = new JSONObject();
//                            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        //get current date time with Date()
        Date date = new Date();
        String formattedDate = dateFormat.format(date);

        String date1 = formattedDate.substring(0, 10);
        String time = formattedDate.substring(11, 23);
        String completeDateTime = date1 + "T" + time;
        params2.put("dateTime", completeDateTime);
        params2.put("itemsPKID", itempkid);
        params2.put("transType", "19");
        params2.put("transQty", "1");
        params2.put("remarks", "send to storage factory through HIMS");
        SPTSResponse TransPkid = SPTSWebService.insertTransaction(params2);
        System.out.println("transPKID: " + TransPkid.getResponseId());
        System.out.println("formattedDate............." + formattedDate);
        System.out.println("date1............." + date1);
        System.out.println("time............." + time);
        System.out.println("completeDateTime............." + completeDateTime);
        
        */
    }
}
