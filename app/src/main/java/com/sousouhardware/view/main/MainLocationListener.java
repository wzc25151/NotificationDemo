package com.sousouhardware.view.main;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.sousouhardware.base.MyApplication;
import com.sousouhardware.event.MsgEvent;
import com.sousouhardware.util.PermissionUtil;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by wangxiangbo on 2016/7/19.
 */
public class MainLocationListener implements AMapLocationListener {
    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (null != aMapLocation) {
            if (aMapLocation.getErrorCode() == 0) {
                EventBus.getDefault().post(new MsgEvent(MsgEvent.MSG_LOCATION,aMapLocation.getDistrict()));
            } else if(aMapLocation.getErrorCode()==12){
                MyApplication.showToast("定位失败，请允许定位权限");
                PermissionUtil.showMissingPermissionDialog();
            }else {
                MyApplication.showToast("定位失败，请检查网络是否畅通");
            }
        }
    }
}
//public class LocationUtil {
//    /**
//     *  开始定位
//     */
//    public final static int MSG_LOCATION_START = 0;
//    /**
//     * 定位完成
//     */
//    public final static int MSG_LOCATION_FINISH = 1;
//    /**
//     * 停止定位
//     */
//    public final static int MSG_LOCATION_STOP= 2;
//
//    public final static String KEY_URL = "URL";
//    public final static String URL_H5LOCATION = "file:///android_asset/location.html";
//    /**
//     * 根据定位结果返回定位信息的字符串
//     * @param
//     * @return
//     */
//    public synchronized static String getLocationStr(AMapLocation location){
//        if(null == location){
//            return "";
//        }
//        StringBuffer sb = new StringBuffer();
//        //errCode等于0代表定位成功，其他的为定位失败，具体的可以参照官网定位错误码说明
//        if(location.getErrorCode() == 0){
//            sb.append("定位成功" + "\n");
//            sb.append("定位类型: " + location.getLocationType() + "\n");
//            sb.append("经    度    : " + location.getLongitude() + "\n");
//            sb.append("纬    度    : " + location.getLatitude() + "\n");
//            sb.append("精    度    : " + location.getAccuracy() + "米" + "\n");
//            sb.append("提供者    : " + location.getProvider() + "\n");
//
//            if (location.getProvider().equalsIgnoreCase(
//                    android.location.LocationManager.GPS_PROVIDER)) {
//                // 以下信息只有提供者是GPS时才会有
//                sb.append("速    度    : " + location.getSpeed() + "米/秒" + "\n");
//                sb.append("角    度    : " + location.getBearing() + "\n");
//                // 获取当前提供定位服务的卫星个数
//                sb.append("星    数    : "
//                        + location.getSatellites() + "\n");
//            } else {
//                // 提供者是GPS时是没有以下信息的
//                sb.append("国    家    : " + location.getCountry() + "\n");
//                sb.append("省            : " + location.getProvince() + "\n");
//                sb.append("市            : " + location.getCity() + "\n");
//                sb.append("城市编码 : " + location.getCityCode() + "\n");
//                sb.append("区            : " + location.getDistrict() + "\n");
//                sb.append("区域 码   : " + location.getAdCode() + "\n");
//                sb.append("地    址    : " + location.getAddress() + "\n");
//                sb.append("兴趣点    : " + location.getPoiName() + "\n");
//            }
//        } else {
//            //定位失败
//            sb.append("定位失败" + "\n");
//            sb.append("错误码:" + location.getErrorCode() + "\n");
//            sb.append("错误信息:" + location.getErrorInfo() + "\n");
//            sb.append("错误描述:" + location.getLocationDetail() + "\n");
//        }
//        return sb.toString();
//    }
//}
