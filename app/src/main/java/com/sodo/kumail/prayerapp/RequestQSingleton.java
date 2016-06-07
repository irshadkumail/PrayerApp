package com.sodo.kumail.prayerapp;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by kumail on 6/5/2016.
 */

public class RequestQSingleton {

    private static RequestQueue requestQueue;

    private static ImageLoader imageLoader;

    private RequestQSingleton()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(MyApplication.getMyApplication().getApplicationContext());
        }
        if(imageLoader==null)
        {
            imageLoader=new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
                LruCache<String,Bitmap> lruCache= new LruCache<>(20);
                @Override
                public Bitmap getBitmap(String url) {
                    return lruCache.get(url);
                }

                @Override
                public void putBitmap(String url, Bitmap bitmap) {

                    lruCache.put(url,bitmap);
                }
            });
        }

    }
    public static RequestQueue getRequestQueue()
    {
        RequestQSingleton requestQSingleton= new RequestQSingleton();

        return requestQueue;
    }
    public static ImageLoader getImageLoader()
    {
        RequestQSingleton requestQSingleton= new RequestQSingleton();

        return imageLoader;
    }


}
