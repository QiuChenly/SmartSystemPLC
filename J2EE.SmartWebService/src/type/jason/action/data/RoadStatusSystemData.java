package type.jason.action.data;

import org.json.JSONException;
import org.json.JSONObject;
import type.jason.action.Cantast;

import java.util.ArrayList;

/**
 * Created by Admin on 2017/6/27.
 */
public class RoadStatusSystemData extends BaseData {
    private ArrayList<RoadStatuInfo> list = new ArrayList<>();

    @Override
    protected void init() {
        for (int i = 0; i < 12; i++) {
            list.add(new RoadStatuInfo());
        }

    }

    @Override
    protected void logic() {
        for (RoadStatuInfo info : list) {
            info.logic();
        }
    }

    @Override
    protected String getData(Object object) throws JSONException {
        return null;
    }

    //    查询道路状态
//    调用路径 http://ip:port/transportservice/action/GetRoadStatus.do
    public String getStatusBySensorID(String request) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        //随机数据
        jsonObject.put("CO2", "120");
        jsonObject.put("NH3", "163");
        jsonObject.put("Humidity", "129");
        jsonObject.put("Temperature", "65");
        jsonObject.put("H2S", "22");
        jsonObject.put("Light", "352");
        return jsonObject.toString();
    }

    @Override
    public int sleep() {
        return 0;
    }

    private class RoadStatuInfo {
        private int status;

        public int getStatus() {
            return status;
        }

        public void logic() {
            status = (int) (Math.random() * 5 + 1);
        }
    }
}
