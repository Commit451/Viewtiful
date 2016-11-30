package com.commit451.viewtiful;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * Helper class which helps with {@link View} functions
 */
public class Viewtiful {

    private static float xdpi = Float.MIN_VALUE;

    /**
     * Converts dp to px
     *
     * @param context context
     * @param dp      the dp amount
     * @return the amount in pixels
     */
    public static int dpToPx(Context context, int dp) {
        if (xdpi == Float.MIN_VALUE) {
            xdpi = context.getResources().getDisplayMetrics().xdpi;
        }
        return Math.round(dp * (xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    /**
     * Since this has some cool rename deprecation, get rid of those lint warnings!
     *
     * @param view     the view to set the background on
     * @param drawable the drawable
     */
    public static void setBackground(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    /**
     * Sets just the top padding on a view
     *
     * @param view    the view
     * @param padding the padding in pixels
     */
    public static void setPaddingTop(View view, int padding) {
        view.setPadding(view.getPaddingLeft(), padding, view.getPaddingRight(), view.getPaddingBottom());
    }

    /**
     * Sets just the bottom padding on a view
     *
     * @param view    the view
     * @param padding the padding in pixels
     */
    public static void setPaddingBottom(View view, int padding) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), padding);
    }

    /**
     * Sets just the left padding on a view
     *
     * @param view    the view
     * @param padding the padding in pixels
     */
    public static void setPaddingLeft(View view, int padding) {
        view.setPadding(padding, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    /**
     * Sets just the right padding on a view
     *
     * @param view    the view
     * @param padding the padding in pixels
     */
    public static void setPaddingRight(View view, int padding) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), padding, view.getPaddingBottom());
    }

    /**
     * Pass in a runnable to run before the view starts drawing
     *
     * @param view     the view you wish to wait for a draw call on
     * @param runnable the runnable to run when about to draw
     */
    public static void onPreDraw(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                view.post(runnable);
                //Don't draw this time, since we are posting the runnable
                return false;
            }
        });
    }

    /**
     * Pass in a runnable to run when the view has been laid out
     *
     * @param view     the view
     * @param runnable the runnable to run when about to draw
     */
    public static void onGlobalLayout(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT <= 15) {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                runnable.run();
            }
        });
    }

    /**
     * Determine if the navigation bar will be on the bottom of the screen, based on logic in
     * PhoneWindowManager.
     * @return true if it is on bottom, false if not
     * @see <a href=https://github.com/nickbutcher/plaid/blob/master/app/src/main/java/io/plaidapp/util/ViewUtils.java>https://github.com/nickbutcher/plaid/blob/master/app/src/main/java/io/plaidapp/util/ViewUtils.java</a>
     */
    public static boolean isNavigationBarOnBottom(@NonNull Context context) {
        final Resources res= context.getResources();
        final Configuration cfg = context.getResources().getConfiguration();
        final DisplayMetrics dm =res.getDisplayMetrics();
        boolean canMove = (dm.widthPixels != dm.heightPixels &&
                cfg.smallestScreenWidthDp < 600);
        return(!canMove || dm.widthPixels < dm.heightPixels);
    }
}
