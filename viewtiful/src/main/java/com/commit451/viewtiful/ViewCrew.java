package com.commit451.viewtiful;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Logical group of views, without them having to be contained within a {@link android.view.ViewGroup}
 */
public class ViewCrew {

    private List<View> views = new ArrayList<>();

    public void addView(View view) {
        views.add(view);
    }

    public void removeView(View view) {
        views.remove(view);
    }

    public boolean removeView(int viewId) {
        for (int i=0; i<views.size(); i++) {
            View view = views.get(i);
            if (view.getId() == viewId) {
                views.remove(i);
                return true;
            }
        }
        return false;
    }

    public void setVisibility(int visibility) {
        for (View view : views) {
            view.setVisibility(visibility);
        }
    }
}
