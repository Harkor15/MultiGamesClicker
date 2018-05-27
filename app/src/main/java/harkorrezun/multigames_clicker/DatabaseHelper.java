package harkorrezun.multigames_clicker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Cards.db";
    public static final String TABLE_NAME ="Colections";
    public static final String TABLE2_NAME ="Cards";

    public static final String T1_COL1 ="_ID";
    public static final String T1_COL2 ="NAME";

    public static final String T2_COL0 ="_ID";
    public static final String T2_COL1 ="ID_COLLECTION";
    public static final String T2_COL2 ="ID_CARD";
    public static final String T2_COL3 ="NAME";
    public static final String T2_COL4 ="AMOUNT";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
          final String T1_B="INSERT INTO "+TABLE_NAME+" ("+T1_COL1+", "+ T1_COL2+") VALUES (";
          final String T2_B="INSERT INTO "+TABLE2_NAME+" ("+T2_COL0+", "+T2_COL1+", "+T2_COL2+", "+T2_COL3+", "+T2_COL4+") "+"VALUES (";

          final String T1I1 =T1_B+ "1,'Vegetables');";
          final String T2I1L1  =T2_B+ "1,1,1,'Golden Carrot',0);";
          final String T2I1L2  =T2_B+ "2,1,2,'Corn',0);";
          final String T2I1L3  =T2_B+ "3,1,3,'Beetroot',0);";
          final String T2I1L4  =T2_B+ "4,1,4,'Radish',0);";
          final String T2I1L5  =T2_B+ "5,1,5,'Chili',0);";
          final String T2I1L6  =T2_B+ "6,1,6,'Red Pepper',0);";
          final String T2I1L7  =T2_B+ "7,1,7,'Mushroom',0);";
          final String T2I1L8  =T2_B+ "8,1,8,'Spinach',0);";
          final String T2I1L9  =T2_B+ "9,1,9,'Broccoli',0);";
          final String T2I1L10 =T2_B+ "10,1,10,'Cabbage',0);";
          final String T2I1L11 =T2_B+ "11,1,11,'Cucumber',0);";
          final String T2I1L12 =T2_B+ "12,1,12,'Tomato',0);";
          final String T2I1L13 =T2_B+ "13,1,13,'Salad',0);";
          final String T2I1L14 =T2_B+ "14,1,14,'Potatoes',0);";
          final String T2I1L15 =T2_B+ "15,1,15,'Onion',0);";
        //public static final String INS2 = "";






    db.execSQL("create table "+ TABLE_NAME+" ("+T1_COL1+" INTEGER PRIMARY KEY, "+T1_COL2+" TEXT);");
    db.execSQL("create table "+ TABLE2_NAME+" ("+T2_COL0+" INTEGER PRIMARY KEY,"+T2_COL1+" INTEGER, "+T2_COL2+" INTEGER, "+T2_COL3+" TEXT, "+T2_COL4+" INTEGER);");

    db.execSQL(T1I1);
    db.execSQL(T2I1L1);
    db.execSQL(T2I1L2);
    db.execSQL(T2I1L3);
    db.execSQL(T2I1L4);
    db.execSQL(T2I1L5);
    db.execSQL(T2I1L6);
    db.execSQL(T2I1L7);
    db.execSQL(T2I1L8);
    db.execSQL(T2I1L9);
    db.execSQL(T2I1L10);
    db.execSQL(T2I1L11);
    db.execSQL(T2I1L12);
    db.execSQL(T2I1L13);
    db.execSQL(T2I1L14);
    db.execSQL(T2I1L15);




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
        Log.d("Query","Card added");
    }
    public int howMany(int IDcol, int IDcard){
        SQLiteDatabase db=getWritableDatabase();
        final String query="SELECT "+T2_COL4+" FROM "+TABLE2_NAME+" WHERE "+T2_COL1+"="+IDcol+" AND "+T2_COL2+"="+IDcard+";";

        Cursor cursor=db.rawQuery(query,null);
        cursor.moveToFirst();
        return cursor.getInt(0);
    }



}
