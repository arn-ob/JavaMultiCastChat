/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapplication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 *
 * @author Arnob
 */
public class ClientCode {
    int pt;
    String ipadd;
    
    
    public void SendMessage(String message ,String YourName,int portNumber,String ip) throws IOException{
            pt = portNumber;
            ipadd = ip;
            DatagramSocket ds = new DatagramSocket();
            InetAddress is = InetAddress.getByName(ip);
            String s = message;
            byte b[] = (YourName+" : " + s).getBytes();
            DatagramPacket dp3 = new DatagramPacket(b,b.length,is,portNumber);
            ds.send(dp3);
            
    }
    
    
    
    public String Listen() throws IOException{
        MulticastSocket ms = new MulticastSocket(pt);
            InetAddress is = InetAddress.getByName(ipadd);
            ms.joinGroup(is);
            
            byte b[] = new byte[500];
            DatagramPacket p = new DatagramPacket(b,b.length);
            
            while(true){
                ms.receive(p);
                String s = new String(p.getData());
                return "\n"+s;
            }
    }
}
