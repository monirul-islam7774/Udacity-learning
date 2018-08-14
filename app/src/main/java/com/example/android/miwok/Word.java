package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;

    private String mBanglaTranslation;

    public Word(String defaultTranslation, String banglaTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mBanglaTranslation = banglaTranslation;
    }

    public String getDefaultTranslation(){

        return mDefaultTranslation;
    }

    public String getBanglaTranslation(){

        return mBanglaTranslation;
    }
}
