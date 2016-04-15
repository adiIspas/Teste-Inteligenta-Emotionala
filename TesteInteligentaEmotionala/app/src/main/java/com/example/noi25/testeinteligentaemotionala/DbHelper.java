package com.example.noi25.testeinteligentaemotionala;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;

	private static final String DATABASE_NAME = "YSPDB";
	private static final String TABLE_QUEST = "quest";

	private static final String KEY_ID = "id";
	private static final String KEY_QUES = "question";
    private static final String KEY_OPTA = "opta";
    private static final String KEY_OPTB = "optb";
	private static final String KEY_ANSWER1 = "answer1";
	private static final String KEY_ANSWER2= "answer2";

	private SQLiteDatabase dbase;

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		dbase = db;

		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
				+ " TEXT, " + KEY_ANSWER1+ " TEXT, "+ KEY_OPTA +" TEXT, "
				+ KEY_OPTB + " TEXT, " + KEY_ANSWER2 + " TEXT)";

		db.execSQL(sql);
		addQuestions();
	}

	private void addQuestions() {
		Question q1=new Question("Intrebarea 1","DAAAA", "NU", "11", "21");
		this.addQuestion(q1);

		Question q2=new Question("Intrebarea 2", "DA :)", "NUUU", "12", "22");
		this.addQuestion(q2);

		Question q3=new Question("Intrebarea 3","DA", "NU","13","23");
		this.addQuestion(q3);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
		onCreate(db);
	}

	public void addQuestion(Question quest) {
		ContentValues values = new ContentValues();

		values.put(KEY_QUES, quest.getQUESTION());
		values.put(KEY_ANSWER1, quest.getANSWER1());
		values.put(KEY_OPTA, quest.getOPTA());
		values.put(KEY_OPTB, quest.getOPTB());
		values.put(KEY_ANSWER2, quest.getANSWER2());

		dbase.insert(TABLE_QUEST, null, values);
	}
	public List<Question> getAllQuestions() {
		List<Question> quesList = new ArrayList<Question>();

		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		dbase = this.getReadableDatabase();
		Cursor cursor = dbase.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Question quest = new Question();
				quest.setID(cursor.getInt(0));
				quest.setQUESTION(cursor.getString(1));
				quest.setANSWER1(cursor.getString(2));
				quest.setOPTA(cursor.getString(3));
				quest.setOPTB(cursor.getString(4));
				quest.setANSWER2(cursor.getString(5));
				quesList.add(quest);
			} while (cursor.moveToNext());
		}

		return quesList;
	}

	public int rowcount()
	{
		int row = 0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row = cursor.getCount();
		return row;
	}
}
