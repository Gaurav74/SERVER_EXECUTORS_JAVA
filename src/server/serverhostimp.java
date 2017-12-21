/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import hospital.hospitalserver;
import hospital.data_hospital;
import hospital.detail_patient;
import hostel.hosteldataentry;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author HP
 */
public class serverhostimp implements Runnable, Serializable {

    ResultSet rs = null;
    String name = "";
    ObjectInputStream din = null;
    ObjectOutputStream out = null;
    Socket s = null;//Thread t=null;
    ArrayList<detail_patient> array;

    serverhostimp(Socket s) {
        this.s = s;
    }

    @Override
    public synchronized void run() {
        // synchronized(this){
        //   this.t=Thread.currentThread();
        //}
        try {

            din = new ObjectInputStream(s.getInputStream());
            out = new ObjectOutputStream(s.getOutputStream());
            int id = (int) din.readObject();
            s.setKeepAlive(true);
            switch (id) {
                case 1:
                    String temp[] = (din.readUTF()).split("-");
                    int vtuno = Integer.parseInt(temp[0]);
      hospitalserver hserv = new hospitalserver(vtuno, temp[1], temp[2], temp[3], temp[4], temp[5]);
                    Thread tentry = new Thread(hserv, "entry");
                    // tentry.setDaemon(true);
                    tentry.start();
                    tentry.join();
                    if (!tentry.isAlive()) {
                        System.err.printf("here 4");

                        out.writeInt(hserv.flag());
                        out.flush();
                        System.out.println(hserv.flag() + "dd");
                        System.err.printf("\nhere 5");
                    }
                    break;
                case 2:
                    int vtu = (int) din.readObject();
                    data_hospital dthos = new data_hospital(vtu);
                    Thread tdata = new Thread(dthos, "find data");//tdata.setDaemon(true);
                    tdata.start();
                    tdata.join();
                    if (dthos.flag()) {
                        name = dthos.name();
                        out.writeObject((Object) name);
                        out.flush();    //the problem is here
                        array = new ArrayList<>();
                        System.out.println("size " + array.size());
                        array = dthos.returnresult();
                        System.out.println("ck: 1");
                        ListIterator<detail_patient> itlist = array.listIterator();
                        //     if(itlist.hasNext()){ 
                        int size = array.size();
                        out.writeObject((Object) size);
                        out.flush();
                        while (itlist.hasNext()) {
                            detail_patient ds = itlist.next();
                            String detail = ds.hostel + "-" + ds.disease + "-" + ds.diagnosis;
                            System.out.println(detail);
                            out.writeObject(detail);
                            out.flush();
                        }

                    }//}
                    break;
                case 3:
                    int roomno = (int) din.readObject();
                    String str[] = ((String) din.readObject()).split("-");
      hosteldataentry datahostel = new hosteldataentry(roomno, str[0], str[1], str[2], str[3]);
                    Thread t = new Thread(datahostel, "hostel data entry");
                    t.start();
                    t.join();
                    boolean bool=datahostel.returnstatus();
                    if(bool){
                        out.writeObject((Object)Boolean.TRUE);
                        out.flush();
                    }else{
                        out.writeObject((Object)Boolean.FALSE);
                        out.flush();
                    }
            }
            s.close();
            din.close();
            out.close();

        } catch (IOException | InterruptedException | NumberFormatException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "seerverhostimp:\n" + e.getMessage());
        }

    }
}
