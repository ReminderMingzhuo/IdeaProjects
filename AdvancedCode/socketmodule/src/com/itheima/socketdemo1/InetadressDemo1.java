package com.itheima.socketdemo1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetadressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("Mingzhuo"); //主机名或者IP
        String hostName = address.getHostName();
        System.out.println("主机名为："+hostName);
        String ip = address.getHostAddress();
        System.out.println("IP:"+ip);
    }
}
