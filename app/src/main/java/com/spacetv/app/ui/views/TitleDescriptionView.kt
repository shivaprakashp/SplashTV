package com.spacetv.app.ui.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.spacetv.app.R
import com.spacetv.app.ui.DataModel

class TitleDescriptionView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var title: TextView
    private var subTitle: TextView
    private var description: TextView
    init {
        inflate(context, R.layout.home_title_description_view, this)

        title = findViewById(R.id.txt_home_title)
        subTitle = findViewById(R.id.txt_home_subtitle)
        description = findViewById(R.id.txt_home_description)
    }

    fun bindData(dataList: DataModel.Result.Detail){
        title.text = dataList.title
        subTitle.text = buildString {
        append("Language : ")
        append(dataList.original_language)
    }
        description.text = dataList.overview
    }
}