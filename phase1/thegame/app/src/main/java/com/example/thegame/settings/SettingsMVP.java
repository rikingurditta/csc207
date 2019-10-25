package com.example.thegame.settings;

import com.group0565.mvp.BaseMVP;

/** An interface for the Settings module MVP */
public interface SettingsMVP extends BaseMVP {
  /** An interface for the Settings presenter */
  interface SettingsPresenter extends BaseMVP.BasePresenter {}

  /** An interface for the Settings view */
  interface SettingsView extends BaseMVP.BaseView {}
}
