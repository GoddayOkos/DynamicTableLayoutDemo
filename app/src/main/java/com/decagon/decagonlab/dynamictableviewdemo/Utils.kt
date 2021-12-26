package com.decagon.decagonlab.dynamictableviewdemo

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding

fun createTableLayout(view: View, numOfRow: Int, column1Text: Array<String>, column2Text: Array<String>) {
    val tableLayout: TableLayout = view.findViewById(R.id.table_main)
    val tableHeaderRow = TableRow(view.context).apply {
        setBackgroundResource(R.drawable.border)
    }

    val tableHeaderFirstColumn = createTableHeader(view.context, column1Text[0])
    tableHeaderRow.addView(tableHeaderFirstColumn)

    val tableHeaderSecondColumn = createTableHeader(view.context, column2Text[0])
    tableHeaderRow.addView(tableHeaderSecondColumn)

    tableLayout.addView(tableHeaderRow)

    for (i in 1 until numOfRow) {
        val tableRow = TableRow(view.context)

        val firstColumnTextView = createTableBody(view.context, column1Text[i])
        tableRow.addView(firstColumnTextView)

        val secondColumnTextView = createTableBody(view.context, column2Text[i])
        tableRow.addView(secondColumnTextView)

        tableLayout.addView(tableRow)
    }
}

private fun createTableHeader(context: Context, title: String): TextView {
    return TextView(context).apply {
        setBackgroundResource(R.drawable.header_boarder)
        gravity = Gravity.CENTER
        mSetTextAppearance(context, R.style.TextAppearance_MaterialComponents_Headline6)
        setPadding(3)
        text = title
    }
}

private fun createTableBody(context: Context, title: String): TextView {
    val paddingDp = 5
    val density = context.resources.displayMetrics.density
    val paddingPixel = (paddingDp * density).toInt()

    return TextView(context).apply {
        text = title
        setBackgroundResource(R.drawable.border)
        setPadding(paddingPixel, 0, 0, 0)
    }
}

private fun TextView.mSetTextAppearance(context: Context, resId: Int) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        this.setTextAppearance(context, resId)
    } else {
        this.setTextAppearance(resId)
    }
}