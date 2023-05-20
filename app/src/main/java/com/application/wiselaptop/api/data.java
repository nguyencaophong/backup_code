package com.application.wiselaptop.api;


import com.application.wiselaptop.models.Brand;
import com.application.wiselaptop.models.Demand;

import java.util.ArrayList;
import java.util.List;

public class data {
    public String[] suggestProduct(){
        String[] PRODUCTS =
                {
                        "MacBook Pro và MacBook Air của Apple",
                        "Dell XPS",
                        "HP Spectre x360",
                        "Lenovo ThinkPad X1 Carbon",
                        "Microsoft Surface Laptop",
                        "Asus ZenBook",
                        "Acer Swift",
                        "Razer Blade Stealth",
                        "MSI Prestige",
                        "LG Gram",
                        "Huawei MateBook",
                        "Samsung Notebook",
                        "Google Pixelbook",
                        "Toshiba Portege"
                };
        return PRODUCTS;
    }

    public List<String> getValueInfoConfiguration() {
        List<String> list = new ArrayList<>();
        list.add("AMD Ryzen 5 5600H");
        list.add("Windows 11");
        list.add("DDR4 8GB 3200MHZ, 2 slot up to 16 GB");
        list.add("Geforce GTX 1650 4GB");
        list.add("15.6 FHD 120HZ IPS ");
        list.add("256GB, SSD NVMe M.2 PCL Gen3");
        list.add("1000Mbps Ethernet");
        list.add("802.11ax 2x2 Wifi Bluetooth");
        list.add("2x USB 3.2 Gen1\n" +
                "1x power connector");
        list.add("4 Zones RGB");
        list.add("45Wh");
        list.add("359.6 x  251.9");
        list.add("2.25kg");
        return list;
    }

    public List<String> getKeyInfoConfiguration() {
        List<String> list = new ArrayList<>();
        list.add("CPU");
        list.add("Hệ điều hành");
        list.add("RAM");
        list.add("GPU");
        list.add("Màn hình");
        list.add("Ổ cứng SSD");
        list.add("Bluetooth");
        list.add("Wireless LAN");
        list.add("Các cổng kết nối");
        list.add("Bàn phím");
        list.add("Pin");
        list.add("Kích thước");
        list.add("Trọng lượng");
        return list;
    }

    public static List<Brand> getListBrand(){
        List<Brand> demandItemCategories;
        demandItemCategories = new ArrayList<>();
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_vp"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_gaming"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_mong"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_dohoa"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_sv"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_camung"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_vp"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_v"));
        demandItemCategories.add(new Brand("1", "vanphong","R.drawable.demand_vp"));
        return demandItemCategories;
    }

    public static List<Demand> getListDemand(){
        List<Demand> demandItemCategories;
        demandItemCategories = new ArrayList<>();
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_vp"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_gaming"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_mong"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_dohoa"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_sv"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_camung"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_vp"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_v"));
        demandItemCategories.add(new Demand("1", "vanphong","R.drawable.demand_vp"));
        return demandItemCategories;
    }

    public static List<String> getDescriptions(){
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Phù hợp cho lập trình viên, thiết kế đồ họa 2D");
        descriptions.add("Hiệu năg vượt trội - Cân mọi tác vụ từ word, excel đến chỉnh sửa ảnh trên các phầm mềm nhưu AI, PTS");
        descriptions.add("Đa nhiệm mượt mà - Ram 8GB cho phép vừa mở trình duyệt để tra cứu thông tin, vừa làm việc trên phần mềm.");
        return descriptions;
    }

    String imageLaptop = "https://salt.tikicdn.com/cache/280x280/media/catalog/producttmp/5b/0d/cf/d3c1c4933bfa48ef31a3cab821167016.jpg";

//    public List<Laptop> getListProduct(){
//        List<Laptop> laptops = new ArrayList<>();
//        laptops.add(new Laptop("1","Laptop1","Des1",100.0,100.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1","Bluetooth1"));
//        laptops.add(new Laptop("1","Laptop1","Des1",100.0,100.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1","Bluetooth1"));
//        laptops.add(new Laptop("1","Laptop1","Des1",100.0,100.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1","Bluetooth1"));
//        laptops.add(new Laptop("1","Laptop1","Des1",100.0,100.0,"OS1","CPU","GPU","RAM","Screensolution","HardDisk","Lan1","Wifi1","Communication1","KB1","ScreeSize1","Battery1","Weith1",imageLaptop,"1","1","Bluetooth1"));
//
//        return laptops;
//    }
}
