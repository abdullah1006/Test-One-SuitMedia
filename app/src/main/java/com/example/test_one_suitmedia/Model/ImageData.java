package com.example.test_one_suitmedia.Model;

import com.example.test_one_suitmedia.R;

import java.util.ArrayList;

public class ImageData {
    private static int[] guestImage = {
            R.drawable.elementary,
            R.drawable.endevaour_os,
            R.drawable.garuda_linux,
            R.drawable.kali_linux,
            R.drawable.linux_mint
    };
    public static ArrayList<GuestModel> getListDataGuest() {
        ArrayList<GuestModel> list = new ArrayList<>();
        for (int position = 0; position < guestImage.length; position++) {
            GuestModel guest = new GuestModel();
            guest.setImageGuest(guestImage[position]);
            list.add(guest);
        }
        return list;
    }
}
