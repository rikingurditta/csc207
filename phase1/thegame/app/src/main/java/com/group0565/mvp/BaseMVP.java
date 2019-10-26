package com.group0565.mvp;

import androidx.lifecycle.LifecycleOwner;

import com.group0565.errorHandlers.IErrorDisplayer;

/** The base interface for MVP classes */
public interface BaseMVP {
    /** Base interface for presenter */
    interface BasePresenter {
        /** Destroy all references in this object */
        void onDestroy();
    }

    /** Base interface for view */
    interface BaseView extends IErrorDisplayer {
        /**
         * Get a LifeCycleOwner to enable LiveData observation
         *
         * @return A LifeCycleOwner
         */
        LifecycleOwner getLifeCycleOwner();
    }
}