[![Release](https://jitpack.io/v/Yash-K-B/YoutubeExtractor.svg)](https://jitpack.io/#Yash-K-B/YoutubeExtractor)
[![Generic badge](https://img.shields.io/badge/Build-passing-<COLOR>.svg)]()
[![Generic badge](https://img.shields.io/badge/API-5.0+-<COLOR>.svg)](https://developer.android.com/about/versions/lollipop)

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
	        implementation 'com.github.Yash-K-B:youtubeextractor:Tag'
	}
```
# How to use

```java
1. Asynchronous
	Extractor extractor = new Extractor();
	extractor.extract("videoId", new Extractor.Callback() {
	    @Override
	    public void onSuccess(VideoDetails videoDetails) {
		...
	    }

	    @Override
	    public void onError(ExtractionException e) {
		...
	    }
	});

2. Synchronous
	Extractor extractor = new Extractor();
	try {
	    VideoDetails details = extractor.extract("videoId");  //This may produce 
	    							  //NetworkOnMainThreadException
	}catch (ExtractionException e){
	    e.printStackTrace();
	}

```

# Response Object

![](https://github.com/Yash-K-B/YoutubeExtractor/blob/master/screenshots/Screenshot2.jpg?raw=true)
![](https://github.com/Yash-K-B/YoutubeExtractor/blob/master/screenshots/Screenshot1.png?raw=true)
![](https://github.com/Yash-K-B/YoutubeExtractor/blob/master/screenshots/Screenshot3.png?raw=true)
![](https://github.com/Yash-K-B/YoutubeExtractor/blob/master/screenshots/Screenshot4.png?raw=true)
![](https://github.com/Yash-K-B/YoutubeExtractor/blob/master/screenshots/Screenshot5.png?raw=true)

# Credits

[OkHttp](https://square.github.io/okhttp/) - Caching and downloading web pages

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
