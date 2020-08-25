// Generated by data binding compiler. Do not edit!
package com.mooc.ppjoke.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.mooc.ppjoke.R;
import com.mooc.ppjoke.model.User;
import com.mooc.ppjoke.view.PPImageView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class LayoutFeedAuthorBinding extends ViewDataBinding {
  @NonNull
  public final TextView authorName;

  @NonNull
  public final PPImageView avatar;

  @NonNull
  public final TextView createTime;

  @NonNull
  public final ImageView feedDelete;

  @Bindable
  protected User mUser;

  protected LayoutFeedAuthorBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView authorName, PPImageView avatar, TextView createTime, ImageView feedDelete) {
    super(_bindingComponent, _root, _localFieldCount);
    this.authorName = authorName;
    this.avatar = avatar;
    this.createTime = createTime;
    this.feedDelete = feedDelete;
  }

  public abstract void setUser(@Nullable User user);

  @Nullable
  public User getUser() {
    return mUser;
  }

  @NonNull
  public static LayoutFeedAuthorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_feed_author, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static LayoutFeedAuthorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<LayoutFeedAuthorBinding>inflateInternal(inflater, R.layout.layout_feed_author, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutFeedAuthorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.layout_feed_author, null, false, component)
   */
  @NonNull
  @Deprecated
  public static LayoutFeedAuthorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<LayoutFeedAuthorBinding>inflateInternal(inflater, R.layout.layout_feed_author, null, false, component);
  }

  public static LayoutFeedAuthorBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static LayoutFeedAuthorBinding bind(@NonNull View view, @Nullable Object component) {
    return (LayoutFeedAuthorBinding)bind(component, view, R.layout.layout_feed_author);
  }
}
