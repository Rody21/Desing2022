package com.example.proyects1;

import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDP_Thread extends Thread{
    int dstPort;
    String ubicacion;

    DatagramSocket socket;
    InetAddress address, address2, address3, address4;
    InetAddress IP, IP2, IP3, IP4;

    public UDP_Thread(int puerto_servidor, String toString, InetAddress IPad, InetAddress IPad2, InetAddress IPad3, InetAddress IPad4) {
        super();
        dstPort = puerto_servidor;
        ubicacion = toString;
        IP = IPad;
        IP2 = IPad2;
        IP3 = IPad3;
        IP4 = IPad4;

    }

    @Override
    public void run() {
        boolean running = true;


        try {
            socket = new DatagramSocket();
            address= IP;
            address2= IP2;
            address3= IP3;
            address4= IP4;
            String mensaje = ubicacion;

            byte[] buffer = mensaje.getBytes();

            DatagramPacket Envio = new DatagramPacket(buffer, buffer.length, address, dstPort);

            socket.send(Envio);

            DatagramPacket Envio2 = new DatagramPacket(buffer, buffer.length, address2, dstPort);

            socket.send(Envio2);

            DatagramPacket Envio3 = new DatagramPacket(buffer, buffer.length, address3, dstPort);

            socket.send(Envio3);

            DatagramPacket Envio4 = new DatagramPacket(buffer, buffer.length, address4, dstPort);

            socket.send(Envio4);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null){
                socket.close();
            }
        }

    }
}
