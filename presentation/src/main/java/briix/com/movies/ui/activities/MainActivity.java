package briix.com.movies.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import briix.com.movies.R;
import briix.com.movies.data.Preferences;
import briix.com.movies.data.PreferencesImpl;
import briix.com.movies.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private Preferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPreferences = PreferencesImpl.getInstance(this);
    }
}
