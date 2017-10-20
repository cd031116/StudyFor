package t.s.com.desgin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import t.s.com.R;

public class DesignActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initview();
    }


    private void initview( ){
    }


//    private void changeFrament(Fragment fragment, Bundle bundle, String tag){
//        FragmentTransaction fg = getSupportFragmentManager().beginTransaction();
//        fg.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragment.setArguments(bundle);
//        fg.replace(R.id.f_content, fragment, tag);
////      fg.addToBackStack(tag);
//        fg.commit();
//    }


}
