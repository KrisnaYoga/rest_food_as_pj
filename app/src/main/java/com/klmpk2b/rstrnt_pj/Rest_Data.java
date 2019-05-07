package com.klmpk2b.rstrnt_pj;

import com.klmpk2b.rstrnt_pj.Makanan_Data.Makanan;

import java.util.ArrayList;

public class Rest_Data {
    public static String[][] Rest_data = new String[][]{
            {"Restaurant Indonesia","indonesia", "http://4.bp.blogspot.com/_0-vDFYB3CPs/TJsI2yYvxCI/AAAAAAAAAKo/k2Xf0wtlGWA/s1600/DSC05321.JPG"},
            {"Restaurant Chinese","chinese", "http://static.asiawebdirect.com/m/bangkok/portals/bali-indonesia-com/homepage/magazine/happy-chappy-chinese/pagePropertiesImage/Happy-Chappy-Chinese-3.jpg"},
            {"Restaurant Jepang","jepang", "https://c-lj.gnst.jp/public/article/detail/a/00/02/a0002459/img/basic/a0002459_main.jpg?20180803171240"},
            {"Restaurant Korea","korea", "http://story.tourders.com/wp-content/uploads/2015/11/Kang-Ho-Dong-Restaurant-1024x576.jpg"}
    };

    public static ArrayList<Rest> getListData(){
        Rest rest = null;
        ArrayList<Rest> list = new ArrayList<>();
        for (String[] rest_aData : Rest_data){
            rest = new Rest();
            rest.setNamerest(rest_aData[0]);
            rest.setJenisrest(rest_aData[1]);
            rest.setPhotorest(rest_aData[2]);
            list.add(rest);
        }

        return list;
    }
}
