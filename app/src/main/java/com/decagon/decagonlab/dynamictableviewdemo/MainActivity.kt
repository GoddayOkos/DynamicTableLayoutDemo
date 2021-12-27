package com.decagon.decagonlab.dynamictableviewdemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rootView: View = this.findViewById<View>(android.R.id.content).rootView
        createTableLayout(rootView, 6, resources.getStringArray(R.array.column_1), resources.getStringArray(R.array.column_2))

        findViewById<Button>(R.id.button).setOnClickListener {
            showAlertDialog()
        }
    }

    private fun showAlertDialog() {
        val view = layoutInflater.inflate(R.layout.scrollable_table_layout, null)

        createTableLayout(view,6, resources.getStringArray(R.array.table_2_column_1), resources.getStringArray(R.array.table_2_column_2))

        AlertDialog.Builder(this)
            .setView(view)
            .show()
    }
}