package me.mvp.frame.widget.imageloader;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * ImageLoader
 */
@Singleton
public class ImageLoader {

    private BaseImageLoader imageLoader;

    @Inject
    public ImageLoader(BaseImageLoader imageLoader) {
        setImageLoader(imageLoader);
    }

    public <T extends ImageConfig> void load(Context context, T config) {
        this.imageLoader.load(context, config);
    }

    public <T extends ImageConfig> void clear(Context context, T config) {
        this.imageLoader.clear(context, config);
    }

    public void setImageLoader(BaseImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public BaseImageLoader getImageLoader() {
        return imageLoader;
    }
}