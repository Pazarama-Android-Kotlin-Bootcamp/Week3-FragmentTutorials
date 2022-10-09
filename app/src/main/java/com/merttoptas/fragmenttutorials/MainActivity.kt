package com.merttoptas.fragmenttutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnShow: Button
    private lateinit var btnDelete: Button
    private lateinit var btnAttach: Button
    private lateinit var btnDetach: Button
    private lateinit var btnReplaceA: Button
    private lateinit var btnReplaceB: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        btnShow = findViewById(R.id.btnShow)
        btnDelete = findViewById(R.id.btnDelete)
        btnAttach = findViewById(R.id.btnAttach)
        btnDetach = findViewById(R.id.btnDetach)
        btnReplaceA = findViewById(R.id.btnReplaceA)
        btnReplaceB = findViewById(R.id.btnReplaceB)

        btnShow.setOnClickListener {
            showFragmentA()
        }

        btnDelete.setOnClickListener {
            deleteFragmentA()
        }

        btnAttach.setOnClickListener {
            attachFragment()
        }

        btnDetach.setOnClickListener {
            detachFragment()
        }

        btnReplaceA.setOnClickListener {
            replaceFragmentA()
        }
        btnReplaceB.setOnClickListener {
            // replaceFragmentB()
            replaceFragmentB()
        }
    }

    private fun showFragmentA() {
        val fragmentA = AFragment()
        //val newFragmentA = supportFragmentManager.findFragmentById(R.id.mainFragment)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFragment, fragmentA)
        transaction.commit()
    }

    private fun deleteFragmentA() {
        val fragmentA = supportFragmentManager.findFragmentById(R.id.mainFragment)
        val transaction = supportFragmentManager.beginTransaction()

        fragmentA?.let { safeFragmentA ->
            transaction.remove(safeFragmentA)
            transaction.commit()
        }
    }

    private fun attachFragment() {
        val fragmentA = supportFragmentManager.findFragmentById(R.id.mainFragment)
        val transaction = supportFragmentManager.beginTransaction()
        fragmentA?.let {
            transaction.attach(it)
            transaction.commit()
        }
    }

    private fun detachFragment() {
        val fragmentA = supportFragmentManager.findFragmentById(R.id.mainFragment)
        val transaction = supportFragmentManager.beginTransaction()
        fragmentA?.let {
            transaction.detach(it)
            transaction.commit()
        }
    }

    private fun replaceFragmentB() {
        val fragmentB = supportFragmentManager.findFragmentById(R.id.mainFragment)
        val transaction = supportFragmentManager.beginTransaction()
        fragmentB?.let {
            transaction.addToBackStack("BFragment")
            transaction.replace(R.id.mainFragment, BFragment(), "BFragment")
            transaction.commit()
        }
    }

    private fun replaceFragmentA() {
        val fragmentA = supportFragmentManager.findFragmentById(R.id.mainFragment)
        val transaction = supportFragmentManager.beginTransaction()
        fragmentA?.let {
            transaction.replace(R.id.mainFragment, AFragment())
            transaction.commit()
        }
    }

    private fun sendPassingDataBFragment() {
        val fragmentB = BFragment()
        val transaction = supportFragmentManager.beginTransaction()
        //     val bundle = Bundle()
        //   bundle.putString("name", "Fragment B Name")
        //  bundle.putString("surname", "Fragment B Surname")

        // Way 2
        val newFragmentB = BFragment.newInstance("Fragment B Name", "Fragment B Surname")
        transaction.replace(R.id.mainFragment, newFragmentB)
        transaction.commit()



        /*
        fragmentB?.let {
            it.arguments = bundle
            transaction.replace(R.id.mainFragment, it)
            transaction.commit()
        }
         */

    }
}