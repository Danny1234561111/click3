package com.example.pavelvaleev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController

class BlankFragment6 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var returnData: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank6, container, false)
        findNavController(this).currentBackStackEntry?.savedStateHandle
            ?.getLiveData<String>("result_from_activity")
            ?.observe(viewLifecycleOwner) { s -> returnData = s }
        if (returnData != null) {
            Toast.makeText(context, returnData, Toast.LENGTH_LONG).show()
        }
//        val btn4: Button = view.findViewById(R.id.button4)
//        btn4.setOnClickListener { _ ->
//            findNavController().navigate(R.id.action_blankFragment6_to_main2Activity)
//        }
        val btn6Back: Button = view.findViewById(R.id.button6_back)
        btn6Back.setOnClickListener { _ ->
            findNavController().popBackStack()
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment4.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment4().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

