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

public class CanvasData {

    static Map<Object, Object> map = null;
    static List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
    static List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();

    static {
        int count = 1000;
        int yVal = 100;
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            yVal += rand.nextInt(11) - 5;
            map = new HashMap<Object, Object>();
            map.put("x", i + 1);
            map.put("y", yVal);
            dataPoints1.add(map);
        }

        list.add(dataPoints1);
    }

    public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
        return list;
    }

    static JSONArray json = null;

    static {
        try {
            json = readJsonFromUrl("https://canvasjs.com/data/gallery/spring-mvc/letter-frequency-of-vowels-in-english.json");
//            json = "[{\"label\":\"A\",\"y\":8.17},{\"label\":\"E\",\"y\":12.7},{\"label\":\"I\",\"y\":6.97},{\"label\":\"O\",\"y\":7.51},{\"label\":\"U\",\"y\":2.76}]";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = new JSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static String getCanvasjsDataListJson() {
        return json.toString();
    }

}