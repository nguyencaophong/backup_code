package com.application.wiselaptop.api;

import com.application.wiselaptop.models.Demand;

import java.util.ArrayList;
import java.util.List;

public class DemandApi {

    private static final String KEY_DEMAND_ENTITY = "demands";

    public static List<Demand> readDemands(){
       List<Demand>  demands = new ArrayList<>();
       return demands;
    }

}
