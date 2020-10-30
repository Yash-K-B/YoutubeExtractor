# YoutubeExtractor
Extract youtube Video and Audio download links

# Add To Your Project
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  
dependencies {
	        implementation 'com.github.Yash-K-B:YoutubeExtractor:1.0.2'
	}
```
# How to use

```java
1. Using callback
	Extractor extractor = new Extractor();
        extractor.extract("videoId", new Extractor.Callback() {
            @Override
            public void onSuccess(VideoDetails videoDetails) {
                ...
            }
        });

2. Inline return
	Extractor extractor = new Extractor();
        VideoDetails videoDetails = extractor.extract("videoId");

```

# Credits

[JSoup](https://github.com/jhy/jsoup) - webpage source code download
