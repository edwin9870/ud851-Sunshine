package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * Created by Edwin Ramirez Ventur on 3/12/2017.
 */

// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// TODO COMPLETED (15) Add a class file called ForecastAdapter
// TODO (22) COMPLETED Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

// TODO COMPLETED (23) Create a private string array called mWeatherData

// TODO (47) Create the default constructor (we will pass in parameters in a later lesson)

// TODO COMPLETED (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
// TODO COMPLETED (17) Extend RecyclerView.ViewHolder
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>  {

    private String[] mWeatherData;


    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {

        // TODO COMPLETED (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;
        // TODO COMPLETED (19) Create a constructor for this class that accepts a View as a parameter
        // TODO COMPLETED (20) Call super(view) within the constructor for ForecastAdapterViewHolder
        // TODO COMPLETED (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView

        public ForecastAdapterViewHolder(View itemView) {
            super(itemView);
            mWeatherTextView =  (TextView) itemView.findViewById(R.id.tv_weather_data);
        }

        void bind(int position) {
            mWeatherTextView.setText(mWeatherData[position]);
        }

    }


    // TODO COMPLETED (24) Override onCreateViewHolder
    // TODO COMPLETED (25) Within onCreateViewHolder, inflate the list item xml into a view
    // TODO COMPLETED (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter
    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int idLayaoutForItems = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(idLayaoutForItems, parent, false);
        ForecastAdapterViewHolder forecastAdapterViewHolder = new ForecastAdapterViewHolder(view);
        return forecastAdapterViewHolder;
    }

    // TODO COMPLETED (27) Override onBindViewHolder
    // TODO COMPLETED (28) Set the text of the TextView to the weather for this list item's position

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        Log.d(TAG, "#" + position);
        holder.bind(position);
    }

    // TODO COMPLETED (29) Override getItemCount
    // TODO COMPLETED (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

    @Override
    public int getItemCount() {
        if(mWeatherData==null) {
            return 0;
        }
        return mWeatherData.length;
    }

    // TODO COMPLETED (31) Create a setWeatherData method that saves the weatherData to mWeatherData
    // TODO COMPLETED (32) After you save mWeatherData, call notifyDataSetChanged
    void setWeatherData(String[] weatherData) {
        this.mWeatherData = weatherData;
        notifyDataSetChanged();
    }

}
