package com.klmpk2b.rstrnt_pj;

import com.klmpk2b.rstrnt_pj.Makanan_Data.Makanan;

import java.util.ArrayList;

public class Rest_Data {
    public static String[][] Rest_data = new String[][]{
            {"Restaurant Indonesia","indonesia"},
            {"Restaurant Chinese","chinese"},
            {"Restaurant Jepang","jepang"},
            {"Restaurant Korea","indonesia"}
    };

    public static ArrayList<Rest> getListData(){
        Rest rest = null;
        ArrayList<Rest> list = new ArrayList<>();
        for (String[] rest_aData : Rest_data){
            rest = new Rest();
            rest.setNamerest(rest_aData[0]);
            rest.setJenisrest(rest_aData[1]);
            list.add(rest);
        }

        return list;
    }
}
