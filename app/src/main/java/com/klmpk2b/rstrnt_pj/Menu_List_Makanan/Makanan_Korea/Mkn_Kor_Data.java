package com.klmpk2b.rstrnt_pj.Menu_List_Makanan.Makanan_Korea;

import java.util.ArrayList;

public class Mkn_Kor_Data {
    public static String[][] Mkn_kor_data = new String[][]{
            {"Bibimbap", "Kering", "Rp. 25.000", "https://simplycook.imgix.net/recipes/129.jpeg?fit=crop&fm=jpg&h=1000&ixlib=php-1.0.6&lossless=1&q=50&w=1200&s=b1374df4303ffc0dc01db535b770f041"},
            {"Bulgogi","Kering","Rp. 35.000","https://www.maangchi.com/wp-content/uploads/2008/03/bulgogi.jpg"},
            {"Jjajangmyeon", "Kering", "Rp. 20.000", "http://kitchenmisadventures.com/wp-content/uploads/2017/11/jajangmyeon-13.jpg"},
            {"Galbi", "Kering", "Rp. 45.500", "https://www.thespruceeats.com/thmb/1OVoOdteNGo8Ec_b4mYXWtrJhTA=/3631x2574/filters:fill(auto,1)/galbi-155153527-588b65543df78caebc2acdbd.jpg"}
    };

    public static ArrayList<Mkn_Kor> getListData(){
        Mkn_Kor mkn_kor = null;
        ArrayList<Mkn_Kor> list = new ArrayList<>();
        for (String[] kor_aData : Mkn_kor_data){
            mkn_kor = new Mkn_Kor();
            mkn_kor.setNamemknkor(kor_aData[0]);
            mkn_kor.setJeniskor(kor_aData[1]);
            mkn_kor.setHargakor(kor_aData[2]);
            mkn_kor.setPhotokor(kor_aData[3]);
            list.add(mkn_kor);
        }

        return list;
    }
}
