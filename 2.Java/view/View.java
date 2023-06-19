package view;

import presenter.Presenter;

/**
 * view
 */
public interface View {

    void print(String text);

    void start();

    void setPresenter(Presenter presenter);
}