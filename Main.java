package com.company;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/*
    Author: Chyanne Haugen

    Program checks for duplicate event IDs and will not process events with IDs that have
    already been processed. In this example, duplicates are assumed to be within some time period,
    so program stores event IDs in that period and when period has expired the hashmap is cleaned
    out. Another way I looked into would be to have each element in the hashmap have its own timer
    and then iterate through the map this may be slower depending on the implementation because you have
    to keep going through the whole map, but would work in cases where elements have different expiration times.

    Note: Just putting it all in main so it will be in one file. Depending on how it needs to be implemented
    and used you would probably want to put stuff in separate classes.
 */
public class Main
{
     static Timer t = new Timer();
     static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException
    {
        //Schedules the deletion for every 1 second after first second has passed,
        //delay period will change depending on how long the gap of inserts needs to be.
        t.scheduleAtFixedRate(
                new TimerTask()
                {
                    public void run()
                    {
                        map.clear();
                    }
                }, 1000, 1000
        );


        //Test processes
        processEvent("1","");
        processEvent("2","");
        processEvent("3","");
        processEvent("4","");
        processEvent("5","");
        processEvent("6","");
        processEvent("7","");
        processEvent("8","");
        processEvent("9","");
        processEvent("9","");
        processEvent("10","");
        processEvent("11","");
        processEvent("12","");
        processEvent("13","");
        processEvent("13","");
        processEvent("21","");
        processEvent("22","");
        processEvent("22","");
        processEvent("23","");
        processEvent("24","");
        processEvent("25","");
        processEvent("26","");
        processEvent("27","");
        processEvent("28","");
        processEvent("29","");
        processEvent("20","");
        processEvent("31","");
        processEvent("32","");
        processEvent("33","");

        //Might also want to remove any remaining elements in map here

        System.exit(0); //terminates the timer thread
    }

    //Method to process incoming events, processes events if it's not a
    //duplicate. Assuming that EventID and EventBody will be valid
    //nonempty strings.
    public static void processEvent(String EventID, String EventBody) throws InterruptedException
    {
        System.out.println(EventID + " " + EventBody);

        if(map.containsKey(EventID))
        {
            return;
        }

        map.put(EventID, EventBody);

        System.out.println("Items in hashmap: " + map);

        processEventWithoutDuplicates(EventID, EventBody);

        //using sleep for testing
        Thread.sleep(500);

    }

    public static void processEventWithoutDuplicates(String EventID, String EventBody)
    {
        // this does something very complicated that we do not what do touch
    }
}
