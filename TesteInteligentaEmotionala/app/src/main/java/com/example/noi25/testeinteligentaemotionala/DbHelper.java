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
		Question q1 = new Question("Uneori nu ma simt in largul meu cand vorbesc cu oameni necunoscuti.","DA", "NU", "0", "2");
		this.addQuestion(q1);

		Question q2 = new Question("Uneori ii accept cu greu pe oameni asa cum sunt ei.", "DA", "NU", "0", "2");
		this.addQuestion(q2);

		Question q3 = new Question("Ma simt in largul meu in mijlocul unei multimi de oameni.","DA", "NU","2","0");
		this.addQuestion(q3);

		Question q4 = new Question("Am prestat unele activitati voluntare in comunitatea mea.","DA", "NU","2","0");
		this.addQuestion(q4);

		Question q5 = new Question("Imi face placere sa particip la discutii de grup.","DA", "NU","2","0");
		this.addQuestion(q5);

		Question q6 = new Question("Consider important sa ma implic in viata sociala de la un loc de munca nou.","DA", "NU","2","0");
		this.addQuestion(q6);

		Question q7 = new Question("Imi vine greu sa recunosc comiterea unor greseli.","DA", "NU","2","0");
		this.addQuestion(q7);

		Question q8 = new Question("Nu sunt o persoana care sa caute in mod continuu experiente si idei noi.","DA", "NU","0","2");
		this.addQuestion(q8);

		Question q9 = new Question("Ma interereseaza la fel de mult mediul ambiant ca si lumeain general.","DA", "NU","2","0");
		this.addQuestion(q9);

		Question q10 = new Question("Nu-mi vine usor sa imi fac prieteni.","DA", "NU","0","2");
		this.addQuestion(q10);

		Question q11 = new Question("Petrec o parte foarte mica a timpului meu liber pentru a socializa activ cu un grup de oameni sau pentru a participa la petreceri.","DA", "NU","0","2");
		this.addQuestion(q11);

		Question q12 = new Question("Intarzii foarte rar la intalniri.","DA", "NU","2","0");
		this.addQuestion(q12);

		Question q13 = new Question("Ma inteleg la fel de bine cu oameni de toate varstele si ma bucur de compania lor.","DA", "NU","2","0");
		this.addQuestion(q13);

		Question q14 = new Question("Intodeauna raspund cu promptitudine la corespondenta.","DA", "NU","2","0");
		this.addQuestion(q14);

		Question q15 = new Question("Ma straduiesc in mod constient sa gandesc inainte de a spune ori a face ceva.","DA", "NU","2","0");
		this.addQuestion(q15);

		Question q16 = new Question("Pentru mine este important sa incerc sa fiu constient de nevoile si dorintele altora.","DA", "NU","2","0");
		this.addQuestion(q16);

		Question q17 = new Question("Prefer sa discut personal cu un singur om decat cu un grup format din mai mult de cinci persoane.","DA", "NU","0","2");
		this.addQuestion(q17);

		Question q18 = new Question("Constat ca imi vine greu sa ma alatur conversatiilor la reuniunile sociale si manifest mai degraba tendinta de a asculta.","DA", "NU","0","2");
		this.addQuestion(q18);

		Question q19 = new Question("Prefer sa am un cerc larg si variat de prieteni si cunostinte","DA", "NU","2","0");
		this.addQuestion(q19);

		Question q20 = new Question("Rareori leg prietenii noi si de durata in timpul vacantelor, ba poate chiar niciodata.","DA", "NU","0","2");
		this.addQuestion(q20);

		Question q21 = new Question("Prefer sa ma izolez de agitatia si trepidatia vietii cotidiene.","DA", "NU","0","2");
		this.addQuestion(q21);

		Question q22 = new Question("Adesea caut sfaturile altora sau le cer parerea.","DA", "NU","2","0");
		this.addQuestion(q22);

		Question q23 = new Question("Intodeauna le telefonez persoanelor care m-au cautat in absenta mea si mi-au lasat vorba sa le sun.","DA", "NU","2","0");
		this.addQuestion(q23);

		Question q24 = new Question("Imi vine foarte greu sa discut drespre sentimentele mele.","DA", "NU","0","2");
		this.addQuestion(q24);

		Question q25 = new Question("Cand sunt intr-o incapere plina de oameni la o reuniune sociala, ma pozitionez mai degraba spre perete decat spre centrul salii.","DA", "NU","0","2");
		this.addQuestion(q25);

		Question q26 = new Question("Sunt capabil sa-i incurajez pe oameni sa imi impartaseasca problemele lor.","DA", "NU","2","0");
		this.addQuestion(q26);

		Question q27 = new Question("Daca vrei sa iasa o treaba buna, fa-o tu insuti.","DA", "NU","0","2");
		this.addQuestion(q27);

		Question q28 = new Question("As prefera o slujba care sa implice multa interactiune cu oamenii.","DA", "NU","2","0");
		this.addQuestion(q28);

		Question q29 = new Question("Este mai important sa cunosti oamenii potriviti, decat sa ai un cerc larg de cunostinte.","DA", "NU","0","2");
		this.addQuestion(q29);

		Question q30 = new Question("Nu pot spune cu ca astept cu nerabdare sa particip la evenimente sociale de amploare, cum ar fi nuntile.","DA", "NU","0","2");
		this.addQuestion(q30);

		Question q31 = new Question("Prefer sa fiu singuratic, decat sociabil.","DA", "NU","0","2");
		this.addQuestion(q31);

		Question q32 = new Question("Imi vine greu sa incep o conversatie cu necunoscuti.","DA", "NU","0","2");
		this.addQuestion(q32);
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
