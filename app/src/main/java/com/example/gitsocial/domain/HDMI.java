package com.example.gitsocial.domain;

public class HDMI implements Plug<HDMIConnector> {
    @Override
    public void set(HDMIConnector plug) {
        plug.present();
    }
}
