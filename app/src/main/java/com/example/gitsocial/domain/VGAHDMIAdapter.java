package com.example.gitsocial.domain;

public final class VGAHDMIAdapter implements VGAConnector {
    private final HDMIConnector mConnector;

    public VGAHDMIAdapter(HDMIConnector connector) {
        this.mConnector = connector;
    }

    @Override
    public void present() {
        this.mConnector.present();
    }
}
