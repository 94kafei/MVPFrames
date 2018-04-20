package me.mvp.frame.frame;

import org.simple.eventbus.EventBus;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Presenter
 */
public class BasePresenter<M extends IModel, V extends IView> implements IPresenter {

    protected M model;
    protected V view;

    protected CompositeDisposable compositeDisposable;

    public BasePresenter() {

        this.onStart();
    }

    public BasePresenter(M model) {
        this.model = model;

        this.onStart();
    }

    public BasePresenter(V view) {
        this.view = view;

        this.onStart();
    }

    public BasePresenter(M model, V view) {
        this.model = model;
        this.view = view;

        this.onStart();
    }

    /**
     * Start
     */
    @Override
    public void onStart() {
        if (useEventBus()) {
            // 注册EventBus
            EventBus.getDefault().register(this);
        }
    }

    /**
     * Destroy
     */
    @Override
    public void onDestroy() {
        if (useEventBus()) {
            // 注册EventBus
            EventBus.getDefault().register(this);
        }

        // 解除订阅
        this.unDispose();

        if (model != null) {
            model.onDestroy();
        }

        this.model = null;
        this.view = null;
        this.compositeDisposable = null;
    }

    /**
     * 使用eventBus
     *
     * @return
     */
    protected boolean useEventBus() {
        return true;
    }

    public void addDispose(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);//将所有disposable放入,集中处理
    }

    public void unDispose() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();//保证activity结束时取消所有正在执行的订阅
        }
    }
}