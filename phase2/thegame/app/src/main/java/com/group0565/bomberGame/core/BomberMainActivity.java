package com.group0565.bomberGame.core;

import com.group0565.engine.android.GameActivity;
import com.group0565.engine.gameobjects.GlobalPreferences;
import com.group0565.preferences.IPreferenceInteractor;
import com.group0565.preferences.PreferencesInjector;
import com.group0565.theme.Themes;

public class BomberMainActivity extends GameActivity {

  public BomberMainActivity() {

    super(new BomberGame());
    IPreferenceInteractor prefInter = PreferencesInjector.inject();
    this.getGame()
        .setGlobalPreferences(
            new GlobalPreferences(
                Themes.valueOf(prefInter.getTheme()),
                prefInter.getLanguage(),
                prefInter.getVolume()));
  }
}