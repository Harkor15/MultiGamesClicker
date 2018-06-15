package harkorrezun.multigames_clicker;

public class Collection {
    private int id;
    private String name;
    private int IdCategory;
    private int price;
    private int image;
    public Collection(int id,String name,int categoryID, int price,int image){
        this.id=id;
        this.name=name;
        this.IdCategory=categoryID;
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
        return IdCategory;
    }
    public int getId() {
        return id;
    }
}
