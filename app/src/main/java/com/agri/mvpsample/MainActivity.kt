package com.agri.mvpsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), Contract.View, View.OnClickListener {
    // creating object of TextView class
    private var textView: TextView? = null

    // creating object of Button class
    private var button: Button? = null

    // creating object of ProgressBar class
    private var progressBar: ProgressBar? = null
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // assigning ID of the TextView
        textView = findViewById(R.id.textView)

        // assigning ID of the Button
        button = findViewById(R.id.button)

        // assigning ID of the ProgressBar
        progressBar = findViewById(R.id.progressBar)
        presenter = Presenter(this, Model())
        button!!.setOnClickListener(this)
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        textView!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
        textView!!.visibility = View.VISIBLE
    }

    override fun setString(string: String?) {
        textView!!.text = string
    }

    override fun onClick(v: View?) {
        presenter!!.onButtonClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

}