package com.yash.youtube_extractor;

import com.yash.youtube_extractor.exceptions.ExtractionException;
import com.yash.youtube_extractor.models.VideoDetails;
import com.yash.youtube_extractor.models.YoutubeSong;

import junit.framework.TestCase;

import java.util.List;

public class ExtractorHelperTest extends TestCase {


    public void testSearch() {

       List<YoutubeSong> songs =  ExtractorHelper.search("janani    song");
        System.out.println(songs);

        Extractor extractor = new Extractor();
        System.out.println(extractor.extract("WEBvHPvf0hM"));
    }
}