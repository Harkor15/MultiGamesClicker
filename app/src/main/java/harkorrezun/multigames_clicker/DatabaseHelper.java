package harkorrezun.multigames_clicker;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Cards.db";
    public static final String TABLE_NAME ="Colections";
    public static final String TABLE2_NAME ="Cards";

    public static final String T1_COL1 ="_ID";
    public static final String T1_COL2 ="NAME";
    public static final String T1_COL3 ="CATEGORY";
    public static final String T1_COL4 ="PRICE";
    public static final String T1_COL5 ="IMAGE";

    public static final String T2_COL0 ="_ID";
    public static final String T2_COL1 ="ID_COLLECTION";
    public static final String T2_COL2 ="ID_CARD";
    public static final String T2_COL3 ="NAME";
    public static final String T2_COL4 ="AMOUNT";
    public static final String T2_COL5 ="IMAGE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
          final String T1_B="INSERT INTO "+TABLE_NAME+" ("+T1_COL1+", "+ T1_COL2+", "+T1_COL3+", "+T1_COL4+", "+T1_COL5+") VALUES (";
          final String T2_B="INSERT INTO "+TABLE2_NAME+" ("+T2_COL0+", "+T2_COL1+", "+T2_COL2+", "+T2_COL3+", "+T2_COL4+", "+T2_COL5+") "+"VALUES (";

    db.execSQL("create table "+ TABLE_NAME+" ("+T1_COL1+" INTEGER PRIMARY KEY, "+T1_COL2+" TEXT,"+T1_COL3+" INTEGER,"+T1_COL4+" INTEGER,"+T1_COL5+" INT);");
    db.execSQL("create table "+ TABLE2_NAME+" ("+T2_COL0+" INTEGER PRIMARY KEY,"+T2_COL1+" INTEGER, "+T2_COL2+" INTEGER, "+T2_COL3+" TEXT, "+T2_COL4+" INTEGER,"+T2_COL5+" INT);");
        db.execSQL(T1_B+ "1,'Brayan Machen',1, 250,"+R.drawable.t1_1+");");
        db.execSQL(T2_B+ "1,1,1,'Lewndowsky',0,"+R.drawable.t2_1_1+");");
        db.execSQL(T2_B+ "2,1,2,'Hammers',0,"+R.drawable.t2_1_2+");");
        db.execSQL(T2_B+ "3,1,3,'Bonteng',0,"+R.drawable.t2_1_3+");");
        db.execSQL(T2_B+ "4,1,4,'Rabben',0,"+R.drawable.t2_1_4+");");
        db.execSQL(T2_B+ "5,1,5,'Thiogo',0,"+R.drawable.t2_1_5+");");
        db.execSQL(T2_B+ "6,1,6,'Vodal',0,"+R.drawable.t2_1_6+");");
        db.execSQL(T2_B+ "7,1,7,'Alibaba',0,"+R.drawable.t2_1_7+");");
        db.execSQL(T2_B+ "8,1,8,'Robbery',0,"+R.drawable.t2_1_8+");");
        db.execSQL(T2_B+ "9,1,9,'Martonez',0,"+R.drawable.t2_1_9+");");
        db.execSQL(T2_B+ "10,1,10,'Rodringuez',0,"+R.drawable.t2_1_10+");");
        db.execSQL(T2_B+ "11,1,11,'Moller',0,"+R.drawable.t2_1_11+");");
        db.execSQL(T2_B+ "12,1,12,'Kommich',0,"+R.drawable.t2_1_12+");");
        db.execSQL(T2_B+ "13,1,13,'Ceman',0,"+R.drawable.t2_1_13+");");
        db.execSQL(T2_B+ "14,1,14,'Tolasso',0,"+R.drawable.t2_1_14+");");
        db.execSQL(T2_B+ "15,1,15,'Rady',0,"+R.drawable.t2_1_15+");");
         Log.d("DB","CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    // UPGRADE IN NEXT VER
    }
    public void addNewCard(int IDcol,int IDcard){
        SQLiteDatabase db=getWritableDatabase();
        final String query="UPDATE Cards SET AMOUNT = AMOUNT+1 WHERE ID_COLLECTION = "+IDcol+" AND ID_CARD = "+IDcard+";";
        db.execSQL(query);
        db.close();
        Log.d("Query","Card added");
    }
    public int howMany(int IDcol, int IDcard){
        SQLiteDatabase db=getWritableDatabase();
        final String query="SELECT "+T2_COL4+" FROM "+TABLE2_NAME+" WHERE "+T2_COL1+"="+IDcol+" AND "+T2_COL2+"="+IDcard+";";
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        db.close();
        return cursor.getInt(0);
    }
    public String getCollectionName(int idColelction){
        SQLiteDatabase db=getReadableDatabase();
        final String query="SELECT "+T1_COL2+" FROM "+TABLE_NAME+" WHERE "+T1_COL1+" = "+idColelction+";";
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        return cursor.getString(0);
    }
    public ArrayDeque<String> allCollections(){ //List of collections
        ArrayDeque<String> arrayDeque= new ArrayDeque<>();
        SQLiteDatabase db=getReadableDatabase();
        final String query="SELECT "+T1_COL2+" FROM "+TABLE_NAME+";";
        Cursor cursor=db.rawQuery(query,null);
        while(cursor.moveToNext()){
            arrayDeque.add(cursor.getString(0));
        }
        db.close();
        return arrayDeque;
    }
    public ArrayDeque<Card> allFromColection(int IDcol){ //List of cards in one collection TODO: REPAIR IT FOR NEW VERSION OF DATABASE!
        ArrayDeque<Card> arrayDeque=new ArrayDeque<>();
        SQLiteDatabase db=getReadableDatabase();
        final String query="SELECT * FROM "+TABLE2_NAME+" WHERE "+T2_COL1+" = "+IDcol+";";
        Cursor cursor=db.rawQuery(query,null);
        while(cursor.moveToNext()){
            Card card=new Card(cursor.getInt(1),cursor.getInt(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5));
            arrayDeque.add(card);
        }
        return arrayDeque;
    }
    public ArrayDeque<Collection> allCollectionsOfCategory(int IDcat){ //List of collections in one category
        ArrayDeque<Collection> arrayDeque= new ArrayDeque<>();
        SQLiteDatabase db=getReadableDatabase();
        final String query="SELECT * FROM "+TABLE_NAME+" WHERE "+T1_COL3+" ="+IDcat+";";
        Cursor cursor=db.rawQuery(query,null);
        while(cursor.moveToNext()){
            Collection col=new Collection(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
            arrayDeque.add(col);
        }
        db.close();
        return arrayDeque;
    }
    public Card getCard(int idCard,int idCollection){
        SQLiteDatabase db=getReadableDatabase();
        final String query="SELECT * FROM "+TABLE2_NAME+" WHERE "+T2_COL2+" ="+idCard+" AND "+T2_COL1+"="+idCollection+";";
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToNext();
        Card card=new Card(cursor.getInt(1),cursor.getInt(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5));
        db.close();
        return card;
    }
    public int getCategory(int idCollection){
        SQLiteDatabase db=getReadableDatabase();
        final String query="SELECT "+T1_COL3+" FROM "+TABLE_NAME+" WHERE "+T1_COL1+"="+idCollection+";";
        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }

}
