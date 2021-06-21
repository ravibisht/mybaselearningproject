package com.stark.learning.design

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.stark.learning.R
import com.stark.learning.recyclerview.StaggeredRecyclerView
import com.stark.learning.util.showIAlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class FragmentBottomSheet : BottomSheetDialogFragment(){

    private  val TAG = "DialogBottomSheet"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_bottom_sheet,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        dummyList.layoutManager = StaggeredGridLayoutManager(2,
            StaggeredGridLayoutManager.VERTICAL).apply {
            gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        }
        dummyList.adapter = StaggeredRecyclerView(
            mutableListOf("e","e","e")) {}

    }



/*        dummyList.adapter = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_list_item_1,
            mutableListOf(
                "1","2","3","4","5",
                "6","1","2","3","4","5",
                "6","1","2","3","4","5","6",
                "1","2","3","4","5","6","1","2",
                "3","4","5","6",
                "1","2","3","4","5","6",
                "1","2","3","4","5","6","1",
                "2","3","4","5","6","1","2","3",


                "4","5","6","1","2","3","4","5","6"
            )
        )






        dummyList.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _
                -> showIAlertDialog(requireContext(),position) }
    }*/

}
