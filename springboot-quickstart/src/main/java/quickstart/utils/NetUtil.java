package quickstart.utils;

import java.net.InetAddress;

public class NetUtil {

    /**
     * 判断设备是否在线
     *
     * @param ip
     * @param timeout
     * @return
     * @throws Exception
     */
    public static boolean isOnline(String ip,int timeout) throws Exception {
        boolean status = InetAddress.getByName(ip).isReachable(timeout);
        return status;
    }

    public static void main(String[] args) throws Exception{
        boolean b = isOnline("192.168.205.97", 3000);
        System.out.println(b);
    }
}
