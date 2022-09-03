package com.example.proyects1;

import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDP_Thread extends Thread{
    int dstPort, dstPort2, dstPort3;
    String ubicacion;

    DatagramSocket socket;
    InetAddress address, address2, address3;
    InetAddress IP, IP2, IP3;

    public UDP_Thread(int puerto_servidor, int puerto_servidor2, int puerto_servidor3, String toString, InetAddress IPad, InetAddress IPad2, InetAddress IPad3) {
        super();
        dstPort = puerto_servidor;
        dstPort2 = puerto_servidor2;
        dstPort3 = puerto_servidor3;
        ubicacion = toString;
        IP = IPad;
        IP2 = IPad2;
        IP3 = IPad3;

    }




    @Override
    public void run() {
        boolean running = true;


        try {
            socket = new DatagramSocket();
            address= IP;
            address2= IP2;
            address3= IP3;
            String mensaje = ubicacion;

            byte[] buffer = mensaje.getBytes();

            DatagramPacket Envio = new DatagramPacket(buffer, buffer.length, address, dstPort);

            socket.send(Envio);

            DatagramPacket Envio2 = new DatagramPacket(buffer, buffer.length, address2, dstPort2);

            socket.send(Envio2);

            DatagramPacket Envio3 = new DatagramPacket(buffer, buffer.length, address3, dstPort3);

            socket.send(Envio3);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }

    }
}
