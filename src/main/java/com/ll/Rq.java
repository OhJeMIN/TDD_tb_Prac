package com.ll;

import lombok.Getter;

import java.util.HashMap;

public class Rq {
    @Getter
    public String cmd;
    public  HashMap<String,String> paramsMap;
    public Rq(String cmd){
        String[] cmdBits = cmd.split("\\?",2);
        this.cmd = cmdBits[0];

        if(cmdBits.length == 1){
            return;
        }
        if(cmdBits[1].isBlank()){
            return;
        }
        int id = 0;
        String[] params = cmdBits[1].split("&");
        paramsMap = new HashMap<>();
        for(int i=0; i< params.length;i++){
            String paramKey = params[i].split("=")[0];
            String paramValue = params[i].split("=")[1];
            paramsMap.put(paramKey,paramValue);
        }
    }

    public int getParamAsInt(String cmd, int defaultValue){
        try{
            int id = Integer.parseInt(paramsMap.get(cmd));
            return id;
        }catch (NullPointerException e){
            return defaultValue;
        }
    }
}
