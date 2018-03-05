package org.fossasia.openevent.common.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.MenuItem;

import org.fossasia.openevent.data.repository.RealmDataRepository;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * The purpose of this activity is to be able to log some output based on
 * Activity life-cycle
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static int count = 0;

    protected abstract int getLayoutResource();

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Timber.i("Activity onCreate: total instances %d", ++count);
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);

        setContentView(getLayoutResource());
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        RealmDataRepository.compactDatabase();
        Timber.i("Activity onDestroy: total instances %d", --count);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Timber.i("Activity onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Timber.i("Activity onResume");
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                //Do nothing
        }
        return super.onOptionsItemSelected(item);
    }
}
