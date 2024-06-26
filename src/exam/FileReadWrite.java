/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author RHYSTER
 */
public class FileReadWrite {
    
    public void writeMessage(String encrypt){
        try {
            BufferedWriter bw = null;String filename = "C:\\Rhyster\\Study\\BaoMatThongTin\\ThucHanh\\Exam\\message.txt";
            
            bw = new BufferedWriter(new FileWriter(filename));
            bw.write(encrypt);
            bw.close();
        } catch (Exception e) {
                Logger.getLogger(frmEncrypt.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void writeKey2(int key){
        try {
            BufferedWriter bw = null;
            String filename = "C:\\Rhyster\\Study\\BaoMatThongTin\\ThucHanh\\Exam\\key2.txt";
            String k = String.valueOf(key);
            
            bw = new BufferedWriter(new FileWriter(filename));
            bw.write(k);
            bw.close();
        } catch (Exception e) {
                Logger.getLogger(frmEncrypt.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void writeKey1(String key){
        try {
            BufferedWriter bw = null;
            String filename = "C:\\Rhyster\\Study\\BaoMatThongTin\\ThucHanh\\Exam\\key1.txt";

            bw = new BufferedWriter(new FileWriter(filename));
            bw.write(key);
            bw.close();
        } catch (Exception e) {
                Logger.getLogger(frmEncrypt.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public String readMessage(){
        String str = null;
        
        try {
            BufferedReader br = null;
            String filename = "C:\\Rhyster\\Study\\BaoMatThongTin\\ThucHanh\\Exam\\message.txt";
            br = new BufferedReader(new FileReader(filename));
            
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, "Open successfully");
            char[] ca = new char[5];
            while (br.ready()){
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            
            System.out.println("Data is: " + sb);
            str = sb.toString();
            
            return str;
        } catch (Exception e) {
                Logger.getLogger(frmDecrypt.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return str;
    }
    
    public int readKey2(){
        int key = 0;
        
        try {
            BufferedReader br = null;
            String filename = "C:\\Rhyster\\Study\\BaoMatThongTin\\ThucHanh\\Exam\\key2.txt";
            br = new BufferedReader(new FileReader(filename));
            
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, "Open successfully");
            char[] ca = new char[5];
            while (br.ready()){
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            
            System.out.println("Key is: " + sb);
            key = Integer.parseInt(sb.toString());
            
            return key;
        } catch (Exception e) {
                Logger.getLogger(frmDecrypt.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return key;
    }
    
    
    public String readKey1(){
        String key = null;
        
        try {
            BufferedReader br = null;
            String filename = "C:\\Rhyster\\Study\\BaoMatThongTin\\ThucHanh\\Exam\\key1.txt";
            br = new BufferedReader(new FileReader(filename));
            
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, "Open successfully");
            char[] ca = new char[5];
            while (br.ready()){
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            
            System.out.println("Key is: " + sb);
            key = sb.toString();
            
            return key;
        } catch (Exception e) {
                Logger.getLogger(frmDecrypt.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return key;
    }
}
