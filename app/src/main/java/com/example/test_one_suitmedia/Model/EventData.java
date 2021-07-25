package com.example.test_one_suitmedia.Model;

import com.example.test_one_suitmedia.R;

import java.util.ArrayList;

public class EventData {
    private static String[] eventNames = {
            "Event 1",
            "Event 2",
            "Event 3",
            "Event 4"

    };
    private static String[] eventTanggal = {
            "22-10-2021",
            "06-05-2021",
            "10-10-2021",
            "22-05-2021"

    };
    private static int[] eventImages = {
            R.drawable.elementary,
            R.drawable.endevaour_os,
            R.drawable.garuda_linux,
            R.drawable.kali_linux
    };

    static ArrayList<EventModel> getListData() {
        ArrayList<EventModel> list = new ArrayList<>();
        for (int position = 0; position < eventNames.length; position++) {
            EventModel event = new EventModel();
            event.setNameEvent(eventNames[position]);
            event.setTanggal(eventTanggal[position]);
            event.setPhoto(eventImages[position]);
            list.add(event);
        }
        return list;
    }
}
