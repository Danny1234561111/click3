package com.example.tabs3.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tabs3.R
import com.example.tabs3.databinding.FragmentMainBinding
import com.example.tabsdemo.ui.main.PageViewModel

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var pageViewModel: PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this)[PageViewModel::class.java].apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root

        // Observe the index (which represents the city)
        pageViewModel.index.observe(viewLifecycleOwner) { city ->
            // Get weather data (replace with actual API call)
            val cityName = resources.getStringArray(R.array.cities)[city - 1]
            val weatherData = getWeatherData(cityName)

            // Update UI
            binding.cityName.text = "$cityName"
            binding.morningWeather.text = "Morning: ${weatherData.morning}"
            binding.afternoonWeather.text = "Afternoon: ${weatherData.afternoon}"
            binding.eveningWeather.text = "Evening: ${weatherData.evening}"
            binding.nightWeather.text = "Night: ${weatherData.night}"
        }

        return root
    }

    // Placeholder function for fetching weather data (replace with real API call)
    private fun getWeatherData(cityName: String): WeatherData {
        // Replace this with your actual API call to get weather data for the city
        return when (cityName) {
            "Москва" -> WeatherData("Sunny, 25°C", "Cloudy, 28°C", "Partly Cloudy, 26°C", "Clear, 23°C")
            "Воронеж" -> WeatherData("Rainy, 18°C", "Cloudy, 20°C", "Rainy, 19°C", "Cloudy, 17°C")
            "Иркутск" -> WeatherData("Sunny, 27°C", "Sunny, 30°C", "Clear, 28°C", "Clear, 25°C")
            else -> WeatherData("Unknown", "Unknown", "Unknown", "Unknown")
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    // Data class to hold weather information
    data class WeatherData(
        val morning: String,
        val afternoon: String,
        val evening: String,
        val night: String
    )
}