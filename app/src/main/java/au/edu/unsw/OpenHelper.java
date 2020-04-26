package au.edu.unsw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

// create database to put comment in
public class OpenHelper extends SQLiteOpenHelper {

    public static final String comment = "create table comment ("
            + "id integer primary key autoincrement, "
            + "content VARCHAR, "
            + "time VARCHAR)";

    public OpenHelper(Context context, String name, CursorFactory factory,
                      int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(comment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
