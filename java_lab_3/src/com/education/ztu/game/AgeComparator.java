package com.education.ztu.game;

import java.util.Comparator;

public class AgeComparator implements Comparator<Participant> {
    @Override
    public int compare(Participant o1, Participant o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
