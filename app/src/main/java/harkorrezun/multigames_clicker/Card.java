package harkorrezun.multigames_clicker;

/**
 * Created by Harkor on 2018-05-28.
 */

public class Card {
    int ID_collection;
    int ID_card;
    String name;
    int amount;
    int image;


    public Card(int _ID_collection, int _ID_card, String _name, int _amount,int image) {
        ID_collection = _ID_collection;
        ID_card = _ID_card;
        name = _name;
        amount = _amount;
        this.image=image;
    }
}
