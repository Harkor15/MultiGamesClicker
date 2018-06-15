package harkorrezun.multigames_clicker;

import android.support.v4.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v4.app.FragmentTransaction;

public class MultiGamesMainActivity extends AppCompatActivity implements MenuFragment.MenuFragmentListener, F5gamblingFragment.GamblingFragmentListener {
    DatabaseHelper myDb;
    View mDecorView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_games_main);
                            myDb=new DatabaseHelper(this);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mDecorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mDecorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        fragmentManager=getSupportFragmentManager();
        changeContent(0);
    }

    @Override
    public void changeContent(int fragNr) {
        Fragment fragment;
        switch(fragNr){
            case 1: fragment=new F1clickerFragment(); break;
            case 2: fragment=new F2shopFragment(); break;
            case 3: fragment=new F3UpgradesFragment(); break;
            case 4: fragment=new F4collectionFragment(); break;
            case 5: fragment=new F5gamblingFragment(); break;
            case 6: fragment=new F999betaSettingsFragment(); break;
            default: fragment=new F0welcomeFragment();break;
        }
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rightContent,fragment,"FragmentContent");
        fragmentTransaction.commit();
    }

    @Override
    public void toGambling(int gID) {
        Fragment fragment;
        switch(gID){
            case 1: fragment=new G1ruletteFragment(); break;
            case 2: fragment=new G2sapperFragment(); break;
            case 3: fragment=new G3crashFragment(); break;
            case 4: fragment=new G4cardsFragment(); break;
            default: fragment=new G1ruletteFragment(); break;
        }
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rightContent,fragment,"FragmentGambling");
        fragmentTransaction.commit();
    }
}

