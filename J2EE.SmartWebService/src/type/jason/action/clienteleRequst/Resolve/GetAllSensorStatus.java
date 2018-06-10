package type.jason.action.clienteleRequst.Resolve;

import org.json.JSONException;
import type.jason.action.clienteleRequst.BaseServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 2018/5/1.
 * @author 陈玉奇
 * @version 1.0
 * @since 获取所有传感器状态
 */
public class GetAllSensorStatus extends BaseServlet {
    @Override
    public String getSystemData(String requestData) throws JSONException {
        return getAllData().getSonsorStatusSystemData().getStatusBySensorID(requestData);
    }

    @Override
    public void sendPost(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getSystemData(requestData);
            sendDataPost(resp, respData);
            System.out.println("获取sensor状态数据数据为："+respData);
        } catch (JSONException e) {
            SystemGet("获取sensor状态数据数据为：", e.getMessage());
        } catch (IOException e) {
            SystemOut("获取sensor状态数据数据为：", e.getMessage());
        }
    }

    @Override
    public void sendGet(HttpServletResponse resp) {
        String requestData = getData();
        String respData;
        try {
            respData = getSystemData(requestData);
            sendDataGet(resp, respData);
            System.out.println("获取传感器数据数据为："+respData);
        } catch (JSONException e) {
            SystemGet("获取传感器数据数据：", e.getMessage());
        } catch (IOException e) {
            SystemOut("获取传感器数据数据：", e.getMessage());
        }
    }
}
