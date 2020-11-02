[![Release](https://jitpack.io/v/Yash-K-B/YoutubeExtractor.svg)](https://jitpack.io/#Yash-K-B/YoutubeExtractor)

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
	        implementation 'com.github.Yash-K-B:YoutubeExtractor:Tag'
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

# License
```
MIT License

Copyright (c) 2020 Yashobanta Kumar Behera

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
