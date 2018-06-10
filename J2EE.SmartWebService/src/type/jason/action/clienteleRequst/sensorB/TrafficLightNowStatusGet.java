package type.jason.action.clienteleRequst.sensorB;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2017/6/29.
 * @author 郭小浪
 * @version 1.0
 * @since 主要获取指定红绿灯指定灯的时间
 */
public class TrafficLightNowStatusGet extends BaseServlet {
    @Override
    public String getSystemData(String requestData) throws JSONException {
        return getAllData().getTrafficLightSystem().getIdTrafficLightInfoByLightName(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getSystemData(requestData);
            sendDataPost(resp, respData);
            System.out.println("获取指定红绿灯指定灯的时间数据为："+respData);
        } catch (JSONException e) {
            SystemGet("获取指定红绿灯指定灯的时间", e.getMessage());
        } catch (IOException e) {
            SystemOut("获取指定红绿灯指定灯的时间", e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getSystemData(requestData);
            sendDataGet(resp, respData);
            System.out.println("获取指定红绿灯指定灯的时间数据为："+respData);
        } catch (JSONException e) {
            SystemGet("获取指定红绿灯指定灯的时间", e.getMessage());
        } catch (IOException e) {
            SystemOut("获取指定红绿灯指定灯的时间", e.getMessage());
        }
    }
}
