package com.ws.jamsholat.activity.ui.scrolldatepick

import android.content.Context
import android.util.AttributeSet
import android.util.Log.d
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.ws.jamsholat.R
import com.ws.jamsholat.activity.ui.scrolldatepick.model.DatePickerModel
import com.ws.jamsholat.util.getCurrentDay

class ScrollDatePicker(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) , IScrollDatePicker{
    private lateinit var mDayRecyclerView: RecyclerView
    private lateinit var mViewPagerSnapHelper: PagerSnapHelper
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private lateinit var mAdapter: RecyclerView.Adapter<*>
    private lateinit var btnLeft: ImageView
    private lateinit var btnRight: ImageView

    private var onDateChangedListener: OnDateChangedListener = context as OnDateChangedListener

    private var data: List<DatePickerModel> = listOf()
    private var currentPosition = getCurrentDay() - 1
    private var size = 0

    private fun getViewElement() {
        btnLeft = findViewById<ImageView>(R.id.iv_btn_left)
        btnRight = findViewById<ImageView>(R.id.iv_btn_right)
        mDayRecyclerView = findViewById<RecyclerView>(R.id.rv_date_picker_scroll)
    }

    private fun initView() {
        initAdapter()
        initLinearLayoutManager()
        initRecycleView()
        initViewPager()
    }


    private fun initRecycleView() {
        mDayRecyclerView.hasFixedSize()
        mDayRecyclerView.adapter = mAdapter
        mDayRecyclerView.layoutManager = mLinearLayoutManager
        mDayRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentPosition = mLinearLayoutManager.findFirstVisibleItemPosition()
                onDateChangedListener.onChanged(data[currentPosition])
            }

        })

    }

    private fun initViewPager() {
        mViewPagerSnapHelper = PagerSnapHelper()
        mViewPagerSnapHelper.attachToRecyclerView(mDayRecyclerView)
    }

    private fun initLinearLayoutManager(){
        mLinearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun initAdapter(){
        mAdapter = DatePickAdapter(data)
    }

    private fun initLayoutInflate(){
        LayoutInflater.from(context).inflate(R.layout.date_picker_layout, this, true)
    }

    private fun firstItemToShow() {
        mDayRecyclerView.scrollToPosition(currentPosition)

    }

    private fun setupButton(){
        btnLeft.setOnClickListener {
            if (currentPosition > 0) {
                currentPosition -= 1
                mDayRecyclerView.smoothScrollToPosition(currentPosition)
                onDateChangedListener.onChanged(data[currentPosition])
            }
        }
        btnRight.setOnClickListener {
            if (currentPosition < size-1) {
                currentPosition += 1
                mDayRecyclerView.smoothScrollToPosition(currentPosition)
                onDateChangedListener.onChanged(data[currentPosition])
            }
        }
    }



    fun onDateChangedListener(l: OnDateChangedListener) {

    }

    override fun setData(data: List<DatePickerModel>) {
        this.data = data
        size = data.size
    }

    override fun show(){
        initLayoutInflate()
        getViewElement()
        initView()
        setupButton()
        firstItemToShow()
    }

    interface OnDateChangedListener{
        fun onChanged(dataItem: DatePickerModel)
    }


}
