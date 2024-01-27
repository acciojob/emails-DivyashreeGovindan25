package com.driver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    private ArrayList<Mails> inbox;
    private ArrayList<Mails> trash;
//    Mails inbox;
//    Mails trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        inbox = new ArrayList<>();
        trash = new ArrayList<>();
//        try{
//            inbox = new Mails(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999"),"First","Duplicate");
//            trash = new Mails(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999"),"First","Duplicate");
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
//        if(getInboxSize() >= inboxCapacity){
//            String oldest = findOldestMessage();
//            deleteMail(oldest);
//        }
//        Mails root = inbox;
////        Mails prev = null;
//        //if(root == null) System.out.println("Null in rm");
//        while(root.next != null){
////            prev = root;
//            root = root.next;
//        }
//        Mails newMail = new Mails(date,message,sender);
//        root.next = newMail;
        if(inbox.size() >= inboxCapacity){
            trash.add(inbox.remove(0));
        }
        inbox.add(new Mails(date,message,sender));
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
//        Mails root = inbox;
//        Mails prev = null;
//        //if(root == null) System.out.println("Null in dm");
//        while(root != null && !root.getMessage().equals(message)){
//            prev = root;
//            root = root.next;
//        }
//        if(root == null){
////            throw new NoEmailWithTheGivenMessageFounf(message);
//            return;
//        }
//        Mails frwd = root.next;
//        Mails curr = root;
//        prev.next = frwd;
//        Mails rootTrash = trash;
//        while(rootTrash.next != null ){
//            rootTrash = rootTrash.next;
//        }
//        rootTrash.next = curr;
//        curr.next = null;
        for (int i=0; i<inbox.size(); i++){
            Mails curr = inbox.get(i);
            if(curr.getMsg().equals(message)){
                trash.add(inbox.remove(i));
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
//        Mails root = inbox;
//        //if(root == null) System.out.println("Null in flm");
//        while(root.next != null){
//            root = root.next;
//        }
//        return root.getMessage();
        return inbox.get(inbox.size()-1).getMsg();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
//        Mails root = inbox;
//        //if(root == null) System.out.println("Null in fom");
//        if(root.next == null) return "null";
//        root = root.next;
//        return root.getMessage();
        return inbox.get(0).getMsg();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
//        int no = 0;
//        Mails root = inbox;
//        //if(root == null) System.out.println("Null in fmbd");
//        while(root != null){
//            if(root.getDate().compareTo(start) >= 0 && root.getDate().compareTo(end) <= 0){
//                no++;
//            }
//            root = root.next;
//        }
//        return no;
        int count = 0;
        for(Mails curr : inbox) {
            if (curr.getDate().compareTo(start) >= 0 && curr.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
//        int size = -1;
//        Mails root = inbox;
//        //if(root == null) System.out.println("Null in gi");
//        while(root != null){
//            root = root.next;
//            size++;
//        }
//        return size;
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
//        int size = -1;
//        Mails root = trash;
//        //if(root == null) System.out.println("Null in gt");
//        while(root != null){
//            root = root.next;
//            size++;
//        }
//        return size;
        return trash.size();
    }

    public void emptyTrash(){
//        Mails root = trash;
//       // if(root == null) System.out.println("Null in et");
//        root.next = null;
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
