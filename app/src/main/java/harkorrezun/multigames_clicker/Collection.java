package harkorrezun.multigames_clicker;

public class Collection {
    private int id;
    private String name;
    private int idCategory;
    private int price;

    public Collection(int id,String name,int categoryID, int price){
        this.id=id;
        this.name=name;
        this.idCategory=categoryID;
        this.price=price;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getcateogryID() {
        return idCategory;
    }
    public int getId() {
        return id;
    }
    public int getCategoryName(){
        switch (idCategory){
            case 1: return R.string.football;

            default:return R.string.football;
        }
    }
}
