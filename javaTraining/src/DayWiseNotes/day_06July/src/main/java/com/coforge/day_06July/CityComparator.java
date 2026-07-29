package com.coforge.day_06July;

import java.util.Comparator;

public class CityComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCity().compareTo(o2.getCity());
    }
}