#include <jni.h>
#include <string>
#include <iostream>

//
// Created by YASHOBANTA on 04-12-2020.
//
using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_yash_youtube_1extractor_Extractor_extractJsonFromHtml(JNIEnv *env, jobject thiz,
                                                               jstring html) {
    int counter = 0;
    string result;
    string source(env->GetStringUTFChars(html, nullptr));
    int st = source.find("\"responseContext\":{");
    for (int i = st - 1; source[i] != '\0'; ++i) {
        result.push_back(source[i]);
        if (source[i] == '{') {
            counter++;
            continue;
        }
        if (source[i] == '}') {
            counter--;
            if (counter == 0)break;
        }
    }
    return env->NewStringUTF(result.c_str());
}