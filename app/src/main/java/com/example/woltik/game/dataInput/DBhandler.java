package com.example.woltik.game.dataInput;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by woLTik on 30-Nov-17.
 */

public class DBhandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "gameData";
    // Contacts table name
    private static final String TABLE_SCORES = "scores";
    // Scores Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_DATE = "date";
    private static final String KEY_SCORE = "score";
    private static final String KEY_NAME1 = "name1";
    private static final String KEY_NAME2 = "name2";

    public DBhandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_SCORES_TABLE = "CREATE TABLE "
                + TABLE_SCORES
                + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_DATE + " TEXT, "
                + KEY_SCORE + " TEXT, "
                + KEY_NAME1 + " TEXT, "
                + KEY_NAME2 + " TEXT)";
        sqLiteDatabase.execSQL(CREATE_SCORES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
        onCreate(sqLiteDatabase);
    }

    // Adding new score
    public void addScore(Score score) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlAddScript = "INSERT INTO " + TABLE_SCORES +
                "("+ KEY_DATE + ", " + KEY_SCORE +", " + KEY_NAME1 + ", " + KEY_NAME2 +")"
        +" VALUES ("+
        '"' + score.getDate()+'"' + ", "+ score.getScore() +", "+
        '"' + score.getName1()+'"' +", "+
        '"' + score.getName2()+'"' + ")";

        // Inserting Row
        db.execSQL(sqlAddScript);
        db.close(); // Closing database connection
    }

    // Getting All Shops
    public ArrayList<Score> getAllScore() {
        ArrayList<Score> scoreList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_SCORES + " ORDER BY " + KEY_SCORE + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                Score score = new Score(cursor.getString(1),Integer.parseInt(cursor.getString(2)), cursor.getString(3), cursor.getString(4));
                scoreList.add(score);
            } while (cursor.moveToNext());
        }
        return scoreList;
    }

    //delete scores
    public void deleteScore(){
        String deleteQuery = "DROP TABLE "+ TABLE_SCORES;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(deleteQuery);
        onCreate(db);
    }
}
