package harkorrezun.multigames_clicker;

import android.util.Log;

public class Collection {
    /*
      public static final String T1_COL1 ="_ID";
    public static final String T1_COL2 ="NAME";
    public static final String T1_COL3 ="CATEGORY";
    public static final String T1_COL4 ="PRICE";
    public static final String T1_COL5 ="IMAGE";
    */
    private int id;
    private String name;
    private int ID_category;
    private int price;
    private int image;

    public Collection(int id,String name,int categoryID, int price,int image){
        this.id=id;
        this.name=name;
        this.ID_category=categoryID;
        this.price=price;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }

    public int getcateogryID() {
        return ID_category;
    }

    public int getId() {
        return id;
    }
}
