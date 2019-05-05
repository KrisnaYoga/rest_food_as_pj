package com.klmpk2b.rstrnt_pj.Makanan_Jepang;

import java.util.ArrayList;

public class Mkn_Jpn_Data {
    public static String[][] Mkn_jpn_data = new String[][]{
            {"Sushi & Shashimi", "Kering", "Rp. 40.000", "https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/01/13/10/sushi.jpg?w968h681"},
            {"Ramen","Basah","Rp. 50.000","https://cdn-image.foodandwine.com/sites/default/files/styles/medium_2x/public/1543591797/collard-greens-ramen-ft-RECIPE0119.jpg?itok=ZmwAvi5t"},
            {"Gyudon", "Kering", "Rp. 65.000", "https://www.seriouseats.com/images/2016/07/20160711-gyudon-beef-rice-bowl-japanese-recipe-15.jpg"},
            {"Yakitori", "Kering", "Rp. 30.000", "https://www.epicurus.com/food/recipes/wp-content/uploads/2012/07/beef-yakitori.jpg"}
    };

    public static ArrayList<Mkn_Jpn> getListData(){
        Mkn_Jpn mkn_jpn = null;
        ArrayList<Mkn_Jpn> list = new ArrayList<>();
        for (String[] Jpn_aData : Mkn_jpn_data){
            mkn_jpn = new Mkn_Jpn();
            mkn_jpn.setNamemknjpn(Jpn_aData[0]);
            mkn_jpn.setJenisjpn(Jpn_aData[1]);
            mkn_jpn.setHargajpn(Jpn_aData[2]);
            mkn_jpn.setPhotojpn(Jpn_aData[3]);
            list.add(mkn_jpn);
        }

        return list;
    }
}
