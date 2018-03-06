package com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.presenter;

import com.wks.daggertutorial.dependencies.PerFragment;
import com.wks.daggertutorial.ui.common.presenter.BasePresenter;
import com.wks.daggertutorial.ui.examples.example2.fragments.fragment_b.view.Example2BView;
import com.wks.daggertutorial.util.PerActivityUtil;
import com.wks.daggertutorial.util.PerFragmentUtil;
import com.wks.daggertutorial.util.SingletonUtil;

import javax.inject.Inject;

/**
 * Created by waqqassheikh on 06/03/2018.
 */
@PerFragment
public class Example2BPresenterImpl extends BasePresenter<Example2BView> implements Example2BPresenter {

    private final SingletonUtil singletonUtil;
    private final PerActivityUtil perActivityUtil;
    private final PerFragmentUtil perFragmentUtil;

    @Inject
    public Example2BPresenterImpl(Example2BView view,
                                  SingletonUtil singletonUtil,
                                  PerActivityUtil perActivityUtil,
                                  PerFragmentUtil perFragmentUtil){
        super(view);
        this.singletonUtil = singletonUtil;
        this.perActivityUtil = perActivityUtil;
        this.perFragmentUtil = perFragmentUtil;
    }

    @Override
    public void onDoSomething() {
        String something = singletonUtil.doSomething();
        something += "\n" + perActivityUtil.doSomething();
        something += "\n" + perFragmentUtil.doSomething();
        view.showSomething(something);;
    }
}
