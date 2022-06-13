package com.example.cryptotips.Model.Comparator;

import com.example.cryptotips.Model.MyPost;

import java.util.Comparator;

public class SortByDateAdded implements Comparator<MyPost> {
    @Override
    public int compare(MyPost post1, MyPost post2) {
        return post1.getDateAdded().compareTo(post2.getDateAdded());
    }
}
