package com.merttoptas.fragmenttutorials

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class AFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("AFragment", "onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("AFragment", "onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("AFragment", "onDetach")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("AFragment", "onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.d("AFragment", "onStart")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("AFragment", "onDestroyView")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("AFragment", "onViewCreated")
    }

    override fun onPause() {
        super.onPause()
        Log.d("AFragment", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("AFragment", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("AFragment", "onStop")
    }
}