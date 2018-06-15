package harkorrezun.multigames_clicker;

/**
 * Created by Harkor on 2018-05-28.
 */

public class Card {
    int idCollection;
    int idCard;
    String name;
    int amount;
    int image;

    public Card(int idCollection, int idCard, String name, int amount,int image) {
        this.idCollection=idCollection;
        this.idCard=idCard;
        this.name = name;
        this.amount = amount;
        this.image=image;
    }
}
