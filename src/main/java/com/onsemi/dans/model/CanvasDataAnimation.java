/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.onsemi.dans.model;

/**
 *
 * @author zbqb9x
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONArray;

public class CanvasDataAnimation {

    static Map<Object, Object> map2 = null;
    static List<List<Map<Object, Object>>> list2 = new ArrayList<List<Map<Object, Object>>>();
    static List<Map<Object, Object>> dataPoints2 = new ArrayList<Map<Object, Object>>();

    static {
        map2 = new HashMap<Object, Object>();
        map2.put("label", "Accomodation");
        map2.put("y", 30);
        dataPoints2.add(map2);
        map2 = new HashMap<Object, Object>();
        map2.put("label", "Food & Groceries");
        map2.put("y", 25);
        dataPoints2.add(map2);
        map2 = new HashMap<Object, Object>();
        map2.put("label", "Utilities");
        map2.put("y", 5);
        dataPoints2.add(map2);
        map2 = new HashMap<Object, Object>();
        map2.put("label", "Entertainment & Fun");
        map2.put("y", 20);
        dataPoints2.add(map2);
        map2 = new HashMap<Object, Object>();
        map2.put("label", "Savings");
        map2.put("y", 10);
        dataPoints2.add(map2);
        map2 = new HashMap<Object, Object>();
        map2.put("label", "Cellphone & Internet");
        map2.put("y", 10);
        dataPoints2.add(map2);

        list2.add(dataPoints2);
    }

    public static List<List<Map<Object, Object>>> getCanvasjsDataListAnimation() {
        return list2;
    }

}