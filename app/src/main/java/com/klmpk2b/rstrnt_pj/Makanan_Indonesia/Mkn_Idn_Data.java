package com.klmpk2b.rstrnt_pj.Makanan_Indonesia;

import java.util.ArrayList;

public class Mkn_Idn_Data {
    public static String[][] Mkn_idn_data = new String[][]{
            {"Nasi Goreng", "Kering", "Rp. 18.000", "https://www.foodforfitness.co.uk/wp-content/uploads/2018/05/IMG_7741-2000x1333.jpg"},
            {"Nasi Ayam Goreng","Kering","Rp. 22.000","http://gldelapan.com/images/WATERMARK/201603/20052/masakan-indonesia-nasi-ayam-sambal.jpg"},
            {"Soup Buntut", "Basah", "Rp. 18.000", "https://img.qraved.co/v2/journal/wp-content/uploads/2015/04/sop-buntut-1-600x400-x.jpg"},
            {"Soup Ayam", "Basah", "Rp. 17.000", "https://sifu.unileversolutions.com/image/id-ID/recipe-topvisual/2/1260-709/soto-ayam-50217424.jpg"}
    };

    public static ArrayList<Mkn_Idn> getListData(){
        Mkn_Idn mkn_idn = null;
        ArrayList<Mkn_Idn> list = new ArrayList<>();
        for (String[] idn_aData : Mkn_idn_data){
            mkn_idn = new Mkn_Idn();
            mkn_idn.setNamemknidn(idn_aData[0]);
            mkn_idn.setJenisidn(idn_aData[1]);
            mkn_idn.setHargaidn(idn_aData[2]);
            mkn_idn.setPhotoidn(idn_aData[3]);
            list.add(mkn_idn);
        }

        return list;
    }

}
