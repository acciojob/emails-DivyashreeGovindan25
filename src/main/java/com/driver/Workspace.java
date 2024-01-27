package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) throws ParseException {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings() throws DateTimeParseException {
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        Collections.sort(calendar,(a,b)->{
            if(a.getEndTime().equals(b.getEndTime())){
                return a.getStartTime().compareTo(b.getStartTime());
            }
            return a.getEndTime().compareTo(b.getEndTime());
        });
        int count = 1;
//        try {
            LocalTime endTime = calendar.get(0).getEndTime();
            for(int i=1; i<calendar.size(); i++){
                Meeting curr = calendar.get(i);
                if(curr.getStartTime().isAfter(endTime)){
                    endTime = curr.getEndTime();
                    count++;
                }
                //else if(curr.getStartTime().compareTo(endTime) > 0)
            }
            return count;
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        //return count;
    }
}
