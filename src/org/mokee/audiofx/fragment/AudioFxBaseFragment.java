/*
 * Copyright (C) 2016 The CyanogenMod Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mokee.audiofx.fragment;

import android.animation.Animator;
import android.app.Fragment;
import android.os.Bundle;
import android.widget.CompoundButton;
import org.mokee.audiofx.activity.ActivityMusic;
import org.mokee.audiofx.activity.MasterConfigControl;

public class AudioFxBaseFragment extends Fragment {

    MasterConfigControl mConfig;

    AudioFxFragment mFrag;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFrag = (AudioFxFragment) getParentFragment();

        mConfig = MasterConfigControl.getInstance(getActivity());
    }

    public int getDisabledColor() {
        return mFrag.getDisabledColor();
    }

    public int getCurrentBackgroundColor() {
        return mFrag.mCurrentBackgroundColor;
    }

    public void animateBackgroundColorTo(Integer colorTo, Animator.AnimatorListener listener,
                                         AudioFxFragment.ColorUpdateListener updateListener) {
        if (mFrag != null) {
            mFrag.animateBackgroundColorTo(colorTo, listener, updateListener);
        }
    }

    /**
     * Call to change the color and propogate it up to the activity, which will call
     * {@link #updateFragmentBackgroundColors(int)}
     *
     * @param color
     */
    public void setBackgroundColor(int color, boolean cancelAnimated) {
        if (mFrag != null) {
            mFrag.updateBackgroundColors(color, cancelAnimated);
        }
    }

    /**
     * For sub class fragments to override and apply the color
     *
     * @param color the new color to apply to any colored elements
     */
    public void updateFragmentBackgroundColors(int color) {
    }

    /**
     * For sub class fragments to override when they might need to update their enabled states
     */
    public void updateEnabledState() {

    }
}