/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.miwok.R.*;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one","lutti", drawable.number_one, raw.number_one));
        words.add(new Word("two","otiiko", drawable.number_two,raw.number_two));
        words.add(new Word("three","tolookosu", drawable.number_three,raw.number_three));
        words.add(new Word("four","oyyisa", drawable.number_four,raw.number_four));
        words.add(new Word("five","massokka", drawable.number_five,raw.number_five));
        words.add(new Word("six","temmokka", drawable.number_six,raw.number_six));
        words.add(new Word("seven","kenekaku", drawable.number_seven,raw.number_seven));
        words.add(new Word("eight","kawinta", drawable.number_eight,raw.number_eight));
        words.add(new Word("nine","wo’e", drawable.number_nine,raw.number_nine));
        words.add(new Word("ten","na’aacha", drawable.number_ten,raw.number_ten));

        WordAdapter adapter = new WordAdapter(this,words, color.category_numbers);
        ListView listView = (ListView) findViewById(id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word word = words.get(i);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioResources());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}
