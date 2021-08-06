package com.example.chordsbyear;

import static android.graphics.Color.parseColor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity_Learn extends AppCompatActivity implements View.OnTouchListener {

    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_learn);

        ImageView iv = (ImageView) findViewById(R.id.image_learn_mask);
        if (iv != null) {
            iv.setOnTouchListener(this);
        }

        AudioAttributes audioAttributes =  new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build();


        sound1 = soundPool.load(this, R.raw.aminor, 1);
        sound2 = soundPool.load(this, R.raw.cmajor, 1);
        sound3 = soundPool.load(this, R.raw.dmajor, 1);
        sound4 = soundPool.load(this, R.raw.gmajor, 1);


    }

    /*@Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }*/


    public boolean onTouch(View v, MotionEvent ev) {
        boolean handledHere = false;

        final int action = ev.getAction();

        final int evX = (int) ev.getX();
        final int evY = (int) ev.getY();

        // If we cannot find the imageView, return.
        ImageView imageView = (ImageView) v.findViewById(R.id.image_learn_mask);
        if (imageView == null) return false;

        // When the action is Down, see if we should show the "pressed" image for the default image.
        // We do this when the default image is showing. That condition is detectable by looking at the
        // tag of the view. If it is null or contains the resource number of the default image, display the pressed image.
        Integer tagNum = (Integer) imageView.getTag();
        int currentResource = (tagNum == null) ? R.drawable.learn_image : tagNum.intValue();

        // Now that we know the current resource being displayed we can handle the DOWN and UP events.

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (currentResource == R.drawable.learn_image) {
                    //handledHere = true;

                } else //handledHere = true;
                break;

            case MotionEvent.ACTION_UP:
                // On the UP, we do the click action.
                // The hidden image (image_areas) has three different hotspots on it.
                // The colors are red, blue, and yellow.
                // Use image_areas to determine which region the user touched.
                int touchColor = getHotspotColor(R.id.image_learn_mask, evX, evY);

                // Compare the touchColor to the expected values. Switch to a different image, depending on what color was touched.
                // Note that we use a Color Tool object to test whether the observed color is close enough to the real color to
                // count as a match. We do this because colors on the screen do not match the map exactly because of scaling and
                // varying pixel density.
                ColorTool ct = new ColorTool();
                int tolerance = 15;
                //nextImage = R.drawable.p2_ship_default;
                if (ct.closeMatch(parseColor("#385723"), touchColor, tolerance)){
                    soundPool.play(sound1,1,1,0,0,1);
                    Log.d("Creator", "Touching 1");}
                else if (ct.closeMatch(parseColor("#A9D18E"), touchColor, tolerance))
                    soundPool.play(sound2,1,1,0,0,1);
                else if (ct.closeMatch(parseColor("#1F4E79"), touchColor, tolerance))
                    Log.d("Creator", "Touching 3");
                else if (ct.closeMatch(parseColor("#9DC3E6"), touchColor, tolerance))
                    Log.d("Creator", "Touching 4");
                else if (ct.closeMatch(parseColor("#7F6000"), touchColor, tolerance))
                    Log.d("Creator", "Touching 5");
                else if (ct.closeMatch(parseColor("#FFD966"), touchColor, tolerance))
                    Log.d("Creator", "Touching 6");
                else if (ct.closeMatch(parseColor("#525252"), touchColor, tolerance))
                    Log.d("Creator", "Touching 7");
                else if (ct.closeMatch(parseColor("#C9C9C9"), touchColor, tolerance))
                    Log.d("Creator", "Touching 8");
                else if (ct.closeMatch(parseColor("#843C0C"), touchColor, tolerance))
                    Log.d("Creator", "Touching 9");
                else if (ct.closeMatch(parseColor("#F4B183"), touchColor, tolerance))
                    Log.d("Creator", "Touching 10");
                else if (ct.closeMatch(parseColor("#203864"), touchColor, tolerance))
                    Log.d("Creator", "Touching 11");
                else if (ct.closeMatch(parseColor("#8FAADC"), touchColor, tolerance))
                    Log.d("Creator", "Touching 12");
                else if (ct.closeMatch(parseColor("#8A2BE2"), touchColor, tolerance))
                    Log.d("Creator", "Touching 13");
                else if (ct.closeMatch(parseColor("#8470FF"), touchColor, tolerance))
                    Log.d("Creator", "Touching 14");
                else if (ct.closeMatch(parseColor("#A62A2A"), touchColor, tolerance))
                    Log.d("Creator", "Touching 15");
                else if (ct.closeMatch(parseColor("#FF4040"), touchColor, tolerance))
                    Log.d("Creator", "Touching 16");
                else if (ct.closeMatch(parseColor("#5C3317"), touchColor, tolerance))
                    Log.d("Creator", "Touching 17");
                else if (ct.closeMatch(parseColor("#FF9900"), touchColor, tolerance))
                    Log.d("Creator", "Touching 18");
                else if (ct.closeMatch(parseColor("#8B0A50"), touchColor, tolerance))
                    Log.d("Creator", "Touching 19");
                else if (ct.closeMatch(parseColor("#FF69B4"), touchColor, tolerance))
                    Log.d("Creator", "Touching 20");
                else if (ct.closeMatch(parseColor("#8B8B00"), touchColor, tolerance))
                    Log.d("Creator", "Touching 21");
                else if (ct.closeMatch(parseColor("#FFFF00"), touchColor, tolerance))
                    Log.d("Creator", "Touching 22");
                else if (ct.closeMatch(parseColor("#8B6969"), touchColor, tolerance))
                    Log.d("Creator", "Touching 23");
                else if (ct.closeMatch(parseColor("#FFC1C1"), touchColor, tolerance))
                    Log.d("Creator", "Touching 24");

                break;

            default:
                handledHere = true;
        } // end switch

        if (handledHere) { //Atm bool handledHere checks nothing

            Log.d("Creator", "Give Order");

        }
        return handledHere;
    }


    /**
     * Resume the activity.
     */

 /*  @Override protected void onResume() {
        super.onResume();

        View v  = findViewById (R.id.wglxy_bar);
        if (v != null) {
            Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
            //anim1.setAnimationListener (new StartActivityAfterAnimation (i));
            v.startAnimation (anim1);
        }
    }*/

    /**
     * Handle a click on the Wglxy views at the bottom.
     *
     */

    public void onClickWglxy (View v) {
        Intent viewIntent = new Intent ("android.intent.action.VIEW",
                Uri.parse("http://double-star.appspot.com/blahti/ds-download.html"));
        startActivity(viewIntent);

    }


/**
 */
// More methods

    /**
     * Get the color from the hotspot image at point x-y.
     *
     */

    public int getHotspotColor (int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        if (img == null) {
            Log.d ("ImageAreasActivity", "Hot spot image not found");
            return 0;
        } else {
            img.setDrawingCacheEnabled(true);
            Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
            if (hotspots == null) {
                Log.d ("ImageAreasActivity", "Hot spot bitmap was not created");
                return 0;
            } else {
                img.setDrawingCacheEnabled(false);
                return hotspots.getPixel(x, y);
            }
        }
    }

}//end class