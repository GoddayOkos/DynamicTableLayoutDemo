package com.decagon.decagonlab.dynamictableviewdemo

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.setPadding

fun createTableLayout(
    hostingView: View,
    numberOfRow: Int,
    firstColumnItems: Array<String>,
    secondColumnItems: Array<String>
) {
    val tableLayout: TableLayout = hostingView.findViewById(R.id.table_main)
    val context = hostingView.context

    val tableHeaderRow = TableRow(context).apply {
        setBackgroundResource(R.drawable.border)
    }

    val tableHeaderFirstColumn = createTableHeader(context, firstColumnItems[0])
    tableHeaderRow.addView(tableHeaderFirstColumn)

    val tableHeaderSecondColumn = createTableHeader(context, secondColumnItems[0])
    tableHeaderRow.addView(tableHeaderSecondColumn)
    tableLayout.addView(tableHeaderRow)

    for (i in 1 until numberOfRow) {
        val tableRow = TableRow(context)

        val firstColumnTextView = createTableBody(context, firstColumnItems[i])
        tableRow.addView(firstColumnTextView)

        val secondColumnTextView = createTableBody(context, secondColumnItems[i])
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