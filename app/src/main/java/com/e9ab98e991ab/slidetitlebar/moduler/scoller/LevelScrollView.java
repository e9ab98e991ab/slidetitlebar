package com.e9ab98e991ab.slidetitlebar.moduler.scoller;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * 带滚动监听的scrollview
 */
public class LevelScrollView extends ScrollView {

	public interface ScrollViewListener {

		void onScrollChanged(LevelScrollView scrollView, int x, int y,
							 int oldx, int oldy);

	}

	private ScrollViewListener scrollViewListener = null;

	public LevelScrollView(Context context) {
		super(context);
	}

	public LevelScrollView(Context context, AttributeSet attrs,
						   int defStyle) {
		super(context, attrs, defStyle);
	}

	public LevelScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setScrollViewListener(ScrollViewListener scrollViewListener) {
		this.scrollViewListener = scrollViewListener;
	}

	@Override
	protected void onScrollChanged(int x, int y, int oldx, int oldy) {
		super.onScrollChanged(x, y, oldx, oldy);
		if (scrollViewListener != null) {
			scrollViewListener.onScrollChanged(this, x, y, oldx, oldy);
		}
	}

}