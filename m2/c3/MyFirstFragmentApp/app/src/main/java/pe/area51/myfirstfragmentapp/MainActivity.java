package pe.area51.myfirstfragmentapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnShowWelcomeClickListener {

    private final static String FRAGMENT_TAG_LOGIN_FRAGMENT = "fragment_login";
    private final static String FRAGMENT_TAG_WELCOME_FRAGMENT = "fragment_welcome";

    private WelcomeFragment welcomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        LoginFragment loginFragment = (LoginFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_LOGIN_FRAGMENT);
        if (loginFragment == null) {
            loginFragment = new LoginFragment();
        }
        WelcomeFragment welcomeFragment = (WelcomeFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG_WELCOME_FRAGMENT);
        if (welcomeFragment == null) {
            welcomeFragment = new WelcomeFragment();
        }
        this.welcomeFragment = welcomeFragment;
        loginFragment.setOnShowWelcomeClickListener(this);
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_1, loginFragment, FRAGMENT_TAG_LOGIN_FRAGMENT)
                .replace(R.id.fragment_container_2, welcomeFragment, FRAGMENT_TAG_WELCOME_FRAGMENT)
                .commit();
    }

    @Override
    public void onShowWelcomeClick(String name) {
        welcomeFragment.setWelcomeMessage(getString(R.string.welcome_message, name));
    }
}
