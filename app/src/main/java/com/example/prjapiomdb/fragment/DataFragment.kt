package com.example.prjapiomdb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prjapiomdb.MovieAdapter
import com.example.prjapiomdb.R
import com.example.prjapiomdb.RClient
import com.example.prjapiomdb.databinding.FragmentDataBinding
import com.example.prjapiomdb.modeldata.MovieData
import com.example.prjapiomdb.modeldata.SearchData
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class DataFragment : Fragment() {
    private var _binding: FragmentDataBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    private val list = ArrayList<MovieData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvdata.setHasFixedSize(true)
        binding.rvdata.layoutManager = LinearLayoutManager(context)

        val bundle = arguments
        val s = bundle?.getString("carimovie")
        val apikey = "9d5d828f"

        RClient.instances.getMovies(s,apikey).enqueue(object  : retrofit2.Callback<SearchData>{
            override fun onResponse(call: Call<SearchData>, response: Response<SearchData>) {
                val responseCode = response.code()

                response.body()?.let { list.addAll(it.data) }
                val adapter = MovieAdapter(list)
                binding.rvdata.adapter = adapter
            }

            override fun onFailure(call: Call<SearchData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}