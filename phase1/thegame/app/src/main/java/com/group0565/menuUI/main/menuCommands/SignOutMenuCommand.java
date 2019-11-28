package com.group0565.menuUI.main.menuCommands;

import com.group0565.menuUI.main.MainMVP;

public class SignOutMenuCommand implements MenuCommand {
  /** A reference for the presenter that will sign the user out */
  private MainMVP.MainPresenter mainPresenter;

  /**
   * Initiates a new Game1Command with the view
   *
   * @param mainPresenter The presenter that will sign out
   */
  public SignOutMenuCommand(MainMVP.MainPresenter mainPresenter) {
    this.mainPresenter = mainPresenter;
  }

  /** Execute the command and sign user out */
  @Override
  public void execute() {
    mainPresenter.signOut();
  }
}
