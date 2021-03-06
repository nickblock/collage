package pl.collage.friendsearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import pl.collage.R;
import pl.collage.base.BaseActivity;

public class FriendSearchActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.layout_activity_friend_search, new FriendSearchFragment());
        transaction.commit();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_friend_search;
    }
}
