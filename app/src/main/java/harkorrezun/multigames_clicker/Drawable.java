package harkorrezun.multigames_clicker;

public class Drawable {
    private int drawable;

    public int getCollectionImage(int collection){
        switch (collection){
            case 1: drawable=R.drawable.t1_1; break;

            default:drawable=0;break;
        }
        return drawable;
    }
    public int getCardImage(int collelction,int card){
        switch (collelction){
            case 1:
                switch (card){
                    case 1: drawable=R.drawable.t2_1_1; break;
                    case 2: drawable=R.drawable.t2_1_2; break;
                    case 3: drawable=R.drawable.t2_1_3; break;
                    case 4: drawable=R.drawable.t2_1_4; break;
                    case 5: drawable=R.drawable.t2_1_5; break;
                    case 6: drawable=R.drawable.t2_1_6; break;
                    case 7: drawable=R.drawable.t2_1_7; break;
                    case 8: drawable=R.drawable.t2_1_8; break;
                    case 9: drawable=R.drawable.t2_1_9; break;
                    case 10: drawable=R.drawable.t2_1_10; break;
                    case 11: drawable=R.drawable.t2_1_11; break;
                    case 12: drawable=R.drawable.t2_1_12; break;
                    case 13: drawable=R.drawable.t2_1_13; break;
                    case 14: drawable=R.drawable.t2_1_14; break;
                    case 15: drawable=R.drawable.t2_1_15; break;
                } break;


        }
        return drawable;
    }

}
