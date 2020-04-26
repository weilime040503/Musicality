package au.edu.unsw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

// create the class to access the database for comment
public class CommentDao {

    public static final String DB_NAME = "comment";

    public static final int VERSION = 1;

    private static CommentDao userDB;

    private SQLiteDatabase db;

   //GET TEH UNSTANCE OF THE OBJECT COMMENTDAO
    private CommentDao(Context context) {
        OpenHelper dbHelper = new OpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }
    //get the instance of comment object
    public synchronized static CommentDao getInstance(Context context) {
        if (userDB == null) {
            userDB = new CommentDao(context);
        }
        return userDB;
    }
    // content values needed to add into database
    public ContentValues getContentValues(Comment order){
        ContentValues cv = new ContentValues();
        cv.put("content", order.getContent());
        cv.put("time", order.getTime());
        return cv;

    }


       public boolean addComment(Comment order) {
        if (order != null) {
            long result = db.insert("comment", null, getContentValues(order));
            if (result != -1) {
                return true;
            } else {
                return false;
            }
        }
        return  false;
    }
    public void del(String id) {
        db.delete("comment", "id" + "=?" , new String[]{id});
    }

    //search for the data, create comment by cursor to create comment to add the object into ArrayList
    public List<Comment> loadComment(){
        ArrayList<Comment> orderList = new ArrayList<Comment>();
        Cursor cursor = db.query("comment", null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                Comment order = new Comment(id, content, time);
                orderList.add(order);
            }

            cursor.close();
        }
        return orderList;
    }

}
