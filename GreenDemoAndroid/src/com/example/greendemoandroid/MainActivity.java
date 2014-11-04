package com.example.greendemoandroid;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.TextView;

import com.liu.demo.Note;

public class MainActivity extends Activity {
	private TextView tv;
	private DbService dbService;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.tv);
		dbService = DbService.getInstance(this);
		handler = new Handler();

		handler.post(new Runnable() {
			@Override
			public void run() {
				dbService.saveNote(new Note(Long.valueOf(1), "hello",
						"greenDao", new Date()));
				// List<Note> lists = dbService.loadAllNote();
				Note note = dbService.loadNote(1);
				tv.setText(note.toString());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
