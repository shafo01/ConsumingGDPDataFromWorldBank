/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.text.DecimalFormat;
import model.YearlyGDP;
import model.YearlyGDPsJSON;
import java.util.ArrayList;
import java.util.Collections;
import javax.json.JsonArray;
import javax.json.JsonObject;

/**
 *
 * @author starw
 */
public class GDPParser {

    private YearlyGDPsJSON yearlyGDPsJSON;

    public GDPParser() {

        yearlyGDPsJSON = new YearlyGDPsJSON();
    }

    public void parseCountryGDP(String url) {
        GDPClient client = new GDPClient();
        JsonArray gdpJSONArray = client.getJSONfromWorldBank(url);
        System.out.println("TEST");
        System.out.println(gdpJSONArray);
        //country and its yearly gdp data in arrays
        JsonArray yearlyGDPs = gdpJSONArray.getJsonArray(1);
        ArrayList<YearlyGDP> gdpdataset = new ArrayList<YearlyGDP>();

        ArrayList years = new ArrayList();
        ArrayList values = new ArrayList();

        for (int i = 0; i < yearlyGDPs.size(); i++) {
            JsonObject yearlygdpJSON = (JsonObject) yearlyGDPs.get(i);
            if (yearlygdpJSON.get("value").toString() != null && !"null".equals(yearlygdpJSON.get("value").toString())) {

                //String value_str = yearlygdpJSON.get("value").toString();
                String value_str = yearlygdpJSON.get("value").toString();
                String date_str = yearlygdpJSON.get("date").toString();
                //removing the quotes from date
                date_str = date_str.replace("\"", "");

                int date = Integer.parseInt(date_str);
                System.out.println("double " + value_str);
                //DecimalFormat decim = new DecimalFormat("0.00");
                double value = Double.parseDouble(value_str);
                //value = Double.parseDouble(decim.format(value));

                YearlyGDP yearlyGDP = new YearlyGDP(date, value);
                gdpdataset.add(yearlyGDP);

                years.add(date);
                values.add(value);
            }

        }

        //sorting the years and gdps
        Collections.sort(years);
        Collections.sort(values);

        YearlyGDPsJSON gdpforJSON = new YearlyGDPsJSON();

        //set the values
        if (gdpdataset.size() > 0) {
            gdpforJSON.setDataset(gdpdataset);
            gdpforJSON.setStartYear((int) years.get(0));
            gdpforJSON.setEndYear((int) years.get(years.size() - 1));
            gdpforJSON.setLowestGDP((double) values.get(0));
            gdpforJSON.setHighestGDP((double) values.get(values.size() - 1));
            setYearlyGDPsJSON(gdpforJSON);

        }

    }

    public YearlyGDPsJSON getYearlyGDPsJSON() {
        return yearlyGDPsJSON;
    }

    public void setYearlyGDPsJSON(YearlyGDPsJSON yearlyGDPsJSON) {
        this.yearlyGDPsJSON = yearlyGDPsJSON;
    }

}
