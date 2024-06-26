/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RHYSTER
 */
public class Encrypt {
    int vig[][];
    
    public void InitVig(){
        vig = new int[26][26];

        // Create alternative map with 26x26 equals A to Z
        for (int i=0; i<26; i++){
            for (int j=0; j<26; j++)
                vig[i][j] = (i+j) % 26;
        }
    }
    
    public String Vigenere(String message, String key) {
        String plain = message;
        int n = plain.length();
        String enc = "";
        int k = 0;
        
        for(int i = 0; i < n; i ++){
            // Insert new encrypted chars into enc
            if(Character.isLetter(plain.charAt(i))){
                enc += encrypt(plain.charAt(i), key.charAt(k));
                // Repeat key until k == plain.length
                k++;
                k = k % key.length();
            }
            else{
                enc += plain.charAt(i);
            }
        }
        
        return enc;
    }
    
    private char encrypt (char m, char k){
        InitVig();
        // Depends on the message's letter to decide the alternative pos in Vig
        int Mn = Character.toUpperCase(m) - 'A';
        // Depends on the key's letter to decide the alternative pos in Vig
        int Kn = Character.toUpperCase(k) - 'A';
        // Combine into a new char from  the pos of Mn and Kn
        int Yn = vig[Kn][Mn];
        
        return (char) (Yn + 'A');
    }
    
    public String encRF(String plain, int key){
        int n = plain.length();

        // Set the default rows and columns of 2D array hr
        int rows = key;
        int columns = (n + rows - 1) / rows;
        char[][] hr = new char[rows][columns];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (index < n) {
                    hr[i][j] = plain.charAt(index++);
                } else {
                    hr[i][j] = '\0'; // Put "null" into spare cells
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                if (hr[i][j] != '\0') {
                    result.append(hr[i][j]);
                }
            }
        }

        return result.toString();       
    }
    
    
    public String decRF(String cipher, int key) {
        int n = cipher.length();

        // Set the default rows and columns of 2D array hr
        int rows = key;
        int columns = (n + rows - 1) / rows;
        char[][] hr = new char[rows][columns];

        int index = 0;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                if (index < n) {
                    hr[i][j] = cipher.charAt(index++);
                } else {
                    hr[i][j] = '\0'; // Điền ký tự null nếu không đủ ký tự
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (hr[i][j] != '\0') {
                    result.append(hr[i][j]);
                }
            }
        }

        return result.toString();
    }
    
    
    public static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
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
    
    public void writeKey(int key){
        try {
            BufferedWriter bw = null;String filename = "C:\\Rhyster\\Study\\BaoMatThongTin\\ThucHanh\\Exam\\key.txt";
            String k = String.valueOf(key);
            
            bw = new BufferedWriter(new FileWriter(filename));
            bw.write(k);
            bw.close();
        } catch (Exception e) {
                Logger.getLogger(frmEncrypt.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
