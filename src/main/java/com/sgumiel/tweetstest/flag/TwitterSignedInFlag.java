package com.sgumiel.tweetstest.flag;

import lombok.Getter;

@Getter
public class TwitterSignedInFlag {

  private boolean signedIn;

  public TwitterSignedInFlag(){
    this.signedIn=false;
  }

  public void signedIn(){
    this.signedIn = true;
  }
}
