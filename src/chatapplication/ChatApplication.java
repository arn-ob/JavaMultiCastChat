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
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author Arnob
 */
public class ChatApplication extends Thread {
   int port;
   String ip;
    
    public void getset(int ports,String ips){
        port = ports;
        ip = ips;
    }
    
    @Override
    public void run(){
            try{
            DatagramSocket ds = new DatagramSocket();
            InetAddress is = InetAddress.getByName(ip);
            Scanner sc = new Scanner(System.in);
            byte b[] = ("Server Running").getBytes();
            DatagramPacket dp3 = new DatagramPacket(b,b.length,is,port);
            ds.send(dp3);
            }
            catch(Exception e){
                e.getMessage();
            }
    }
            
            
       
   
}
