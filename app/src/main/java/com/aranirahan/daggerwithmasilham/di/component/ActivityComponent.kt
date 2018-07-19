package com.aranirahan.daggerwithmasilham.di.component

import com.aranirahan.daggerwithmasilham.main.MainActivity
import com.aranirahan.daggerwithmasilham.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent//boleh tanpa module, hanya dengan inject
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        fun build(): ActivityComponent
    }
}