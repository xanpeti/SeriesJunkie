package com.example.paladin.seriesjunkie.presenter;

/**
 * Created by PaLaDiN on 16/04/24.
 */
public abstract  class Presenter<S> {
    protected S view;

    public void attachView(S screen) {
        this.view = screen;
    }

    public void detachView() {
        this.view = null;
    }
}