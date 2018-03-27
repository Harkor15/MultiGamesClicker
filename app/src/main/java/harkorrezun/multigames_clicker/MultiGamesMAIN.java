package harkorrezun.multigames_clicker;

import android.support.v4.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.support.v4.app.FragmentTransaction;

public class MultiGamesMAIN extends AppCompatActivity implements MenuFragment.MenuFragmentListener{

    View mDecorView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;



    public void oKur(View v){
        Toast.makeText(this,"O kurła, działa!!!",Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_games_main);
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
        //TODO: zmiana fragmentu prawego
        Toast.makeText(this,"Pikachu wybieram cie: "+fragNr,Toast.LENGTH_SHORT).show();
        Fragment fragment;
        switch(fragNr){
            case 1: fragment=new F1_clicker(); break;
            case 2: fragment=new F2_shop(); break;
            default: fragment=new F0_welcome();break;
        }
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rightContent,fragment,"FragmentContent");
        fragmentTransaction.commit();

    }
}

