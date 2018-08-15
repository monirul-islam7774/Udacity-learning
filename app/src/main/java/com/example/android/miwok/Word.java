package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = imageResourceId;
        this.mAudioResourceId = audioResourceId;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation,int mAudioResourceId) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mAudioResourceId = mAudioResourceId;
    }

    public String getDefaultTranslation(){

        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){

        return mMiwokTranslation;
    }

    public int getImageResourceId(){

        return mImageResourceId;
    }

    public boolean hasImage(){

        return mImageResourceId != NO_IMAGE_PROVIDED;

    }

    public int getAudioResources(){

        return mAudioResourceId;
    }
}
