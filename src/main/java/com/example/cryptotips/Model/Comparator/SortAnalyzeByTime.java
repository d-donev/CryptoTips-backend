package com.example.cryptotips.Model.Comparator;

import com.example.cryptotips.Model.Analyze;
import com.example.cryptotips.Model.MyPost;

import java.util.Comparator;

public class SortAnalyzeByTime implements Comparator<Analyze> {
    @Override
    public int compare(Analyze post1, Analyze post2) {
        return post1.getPostedOn().compareTo(post2.getPostedOn());
    }
}
