package com.yash.youtube_extractor;

import com.yash.youtube_extractor.exceptions.ExtractionException;
import com.yash.youtube_extractor.models.VideoDetails;
import com.yash.youtube_extractor.models.YoutubeResponse;
import com.yash.youtube_extractor.models.YoutubeSong;
import com.yash.youtube_extractor.utility.HttpUtility;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

public class ExtractorHelperTest extends TestCase {


    @Test
    public void testSearch() throws ExtractionException {

        HttpUtility.initialise(null, null);

        YoutubeResponse youtubeResponse =  ExtractorHelper.search("janani    song");
        System.out.println(youtubeResponse);

        Extractor extractor = new Extractor();
        System.out.println(extractor.extract("WEBvHPvf0hM"));
    }
}