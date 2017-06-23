package com.example.chiebuka.thebakingapp.ui.tabs.stepsTab


import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

import com.example.chiebuka.thebakingapp.R
import com.example.chiebuka.thebakingapp.models.IngredientsItem
import com.example.chiebuka.thebakingapp.models.StepsItem
import com.google.android.exoplayer2.DefaultLoadControl
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory


/**
 * A simple [Fragment] subclass.
 */
class Steps_Fragment : Fragment() {

    companion object {
        fun newInstance(step : StepsItem): Steps_Fragment {
            val step_frag  = Steps_Fragment()

            val args = Bundle()
            args.putSerializable("STEPS", step)

            step_frag.arguments = args

            return step_frag
        }
    }


    lateinit var exoPlayer : SimpleExoPlayer
    lateinit var simpleExoPlayer : SimpleExoPlayerView

    lateinit var step_description : TextView

    lateinit var step : StepsItem

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_steps_, container, false)

        simpleExoPlayer = view.findViewById(R.id.exo_player) as SimpleExoPlayerView
        step_description = view.findViewById(R.id.step_description) as TextView

        step = arguments.getSerializable("STEPS") as StepsItem

        step_description.setText(step.description)

        if(step.videoURL?.isEmpty()!!){
            simpleExoPlayer.visibility = View.GONE
        }else{
            simpleExoPlayer.visibility = View.VISIBLE
            intializePlayer(step.videoURL!!)
        }

        return view;
    }

    fun intializePlayer(mediaUrl: String) {
        simpleExoPlayer.setBackgroundColor(Color.BLACK)

        val trackSelector = DefaultTrackSelector()
        val loadControl = DefaultLoadControl()
        val exoPlayer = ExoPlayerFactory.newSimpleInstance(activity, trackSelector, loadControl)

        val videoUri = Uri.parse(mediaUrl)
        val dataSourceFactory = DefaultHttpDataSourceFactory("ExoPlayerDemo")
        val extractor = DefaultExtractorsFactory()
        val videoSource = ExtractorMediaSource(videoUri, dataSourceFactory, extractor, null, null)
        exoPlayer.prepare(videoSource)



        simpleExoPlayer.setPlayer(exoPlayer)
    }

    fun stopPlayer() {
        try {
            if (!step.videoURL?.isEmpty()!!) {
                exoPlayer.stop()
                exoPlayer.release()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onStop() {
        super.onStop()
        //Toast.makeText(activity, "Stop ${step.description}", Toast.LENGTH_SHORT).show()
        stopPlayer()
    }

    override fun onPause() {
        super.onPause()
        //Toast.makeText(activity,"Pause ${step.description}", Toast.LENGTH_SHORT).show()
        stopPlayer()
    }
}// Required empty public constructor
