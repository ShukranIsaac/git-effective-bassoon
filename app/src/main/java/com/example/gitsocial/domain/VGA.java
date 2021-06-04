package com.example.gitsocial.domain;

public class VGA implements Plug<VGAConnector> {
    @Override
    public void set(VGAConnector plug) {
        plug.present();
    }
}
