package harkorrezun.multigames_clicker;

/**
 * Created by Harkor on 2018-05-28.
 */

public class Card {
    int idCollection;
    int idCard;
    String name;
    int amount;


    public Card(int idCollection, int idCard, String name, int amount) {
        this.idCollection=idCollection;
        this.idCard=idCard;
        this.name = name;
        this.amount = amount;
    }
}
