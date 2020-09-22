package com.lihang;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.TypedValue;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * Created by leo
 * on 2020/8/3.
 */
public class GlideRoundUtils {
    public static void setRoundCorner(final View view, final Drawable resourceId, final float cornerDipValue) {

        if (cornerDipValue == 0) {
            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    @Override
                    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        Glide.with(view.getContext())
                                .load(resourceId)
                                .asBitmap()
                                .centerCrop()
                                .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                        view.setBackground(new BitmapDrawable(view.getResources(), resource));
                                    }
                                });
                    }
                });
            } else {
                Glide.with(view.getContext())
                        .load(resourceId)
                        .asBitmap()
                        .centerCrop()
                        .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                view.setBackground(new BitmapDrawable(view.getResources(), resource));
                            }
                        });
            }

        } else {

            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    @Override
                    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        Glide.with(view.getContext())
                                .load(resourceId)
                                .asBitmap()
                                .centerCrop()
                                .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                        RoundedBitmapDrawable circularBitmapDrawable =
                                                RoundedBitmapDrawableFactory.create(view.getResources(), resource);
                                        circularBitmapDrawable.setCornerRadius(dp2px(view.getResources(), cornerDipValue));
                                        view.setBackground(circularBitmapDrawable);
                                    }
                                });
                    }
                });
            } else {
                Glide.with(view.getContext())
                        .load(resourceId)
                        .asBitmap()
                        .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                RoundedBitmapDrawable circularBitmapDrawable =
                                        RoundedBitmapDrawableFactory.create(view.getResources(), resource);
                                circularBitmapDrawable.setCornerRadius(dp2px(view.getResources(), cornerDipValue));
                                view.setBackground(circularBitmapDrawable);
                            }
                        });
            }

        }

    }


    public static void setCorners(final View view, final Drawable resourceId, final float leftTop_corner, final float leftBottom_corner, final float rightTop_corner, final float rightBottom_corner) {
        if (leftTop_corner == 0 && leftBottom_corner == 0 && rightTop_corner == 0 && rightBottom_corner == 0) {
            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    @Override
                    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        Glide.with(view.getContext())
                                .load(resourceId)
                                .asBitmap()
                                .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                        view.setBackground(new BitmapDrawable(view.getResources(), resource));
                                    }
                                });
                    }
                });
            } else {
                Glide.with(view.getContext())
                        .load(resourceId)
                        .asBitmap()
                        .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                view.setBackground(new BitmapDrawable(view.getResources(), resource));
                            }
                        });
            }

        } else {
            if (view.getMeasuredWidth() == 0 && view.getMeasuredHeight() == 0) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    @Override
                    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        GlideRoundTransform transform = new GlideRoundTransform(view.getContext(), leftTop_corner, leftBottom_corner, rightTop_corner, rightBottom_corner);
                        Glide.with(view.getContext())
                                .load(resourceId)
                                .asBitmap()
                                .transform(transform)
                                .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                        view.setBackground(new BitmapDrawable(view.getResources(), resource));
                                    }
                                });
                    }
                });
            } else {

                GlideRoundTransform transform = new GlideRoundTransform(view.getContext(), leftTop_corner, leftBottom_corner, rightTop_corner, rightBottom_corner);
                Glide.with(view.getContext())
                        .load(resourceId)
                        .asBitmap()
                        .transform(transform)
                        .override(view.getMeasuredWidth(), view.getMeasuredHeight())
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                                view.setBackground(new BitmapDrawable(view.getResources(), resource));
                            }
                        });

            }

        }

    }

    private static float dp2px(Resources resources, float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }

}
