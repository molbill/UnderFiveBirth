/*
 * Copyright (C) 2015 UNICEF Tanzania.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tz.co.rita.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tz.co.rita.birthregistration.ChartActivity;
import tz.co.rita.birthregistration.R;
import tz.co.rita.data.TimeChartDataAdapter;


/**
 * Created by mgirmaw on 1/25/2016.
 */
public class ChartFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    private final int MAX_CHART_DRILL_IN_DEPTH = 1;
    int mNum;
    private LineChart mChart;

    public float[][] mDataSetsArray;
    public String[] mLegends;
    public String[] mXValsArray;

    ChartActivity mCallBack;



    /**
     * Create a new instance of ChartFragment, providing "num"
     * as an argument.
     */
    public static ChartFragment newInstance(int num, String year, String month) {
        ChartFragment f = new ChartFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        args.putString("year", year);
        args.putString("month", month);

        f.setArguments(args);
        return f;
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (((ChartActivity) getActivity()).mStackLevel > 1)
            ((ChartActivity) getActivity()).mStackLevel--;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chart, container, false);

        mCallBack = (ChartActivity) getActivity();
        mChart = (LineChart) v.findViewById(R.id.line_chart);
        try {
            if (mNum <= MAX_CHART_DRILL_IN_DEPTH)
                mChart.setOnChartValueSelectedListener(mCallBack);
        } catch (Exception e) {
            Log.e(TAG, "ChartActivity must implement onChart Selected Listener. " + e.getMessage());
        }
        mChart.setTouchEnabled(true);

        TimeChartDataAdapter cda = new TimeChartDataAdapter(getActivity());

        if (mNum == 1) {

            String[][] plotData = cda.getBirthRecordArray();


            if (plotData != null && plotData[0].length > 0) {
                mXValsArray = new String[plotData[0].length];
                float[] yVals = new float[plotData[0].length];
                float[] yValsMale = new float[plotData[0].length];
                float[] yValsFemale = new float[plotData[0].length];

                for (int i = 0; i < plotData[0].length; i++) {
                    mXValsArray[i] = plotData[0][i];
                    yVals[i] = Float.valueOf(plotData[1][i]);
                    yValsMale[i] = Float.valueOf(plotData[2][i]);
                    Log.i(TAG, "I +++++ " + i);
                    yValsFemale[i] = Float.valueOf(plotData[3][i]);
                }
                ((ChartActivity) getActivity()).mYearValues = mXValsArray;
                mDataSetsArray = new float[3][plotData[0].length];
                mDataSetsArray[0] = yVals;
                mDataSetsArray[1] = yValsMale;
                mDataSetsArray[2] = yValsFemale;
                mLegends = new String[3];
                mLegends[0] = "Total Registrations";
               mLegends[1] = "Male Registrations";
                mLegends[2] = "Female Registrations";
                int[] theColorsArray = {Color.BLUE, Color.RED, Color.MAGENTA};
                populateChartData(mDataSetsArray, mLegends,
                        mXValsArray, theColorsArray);
            }
        } else if (mNum == 2) {

            String SelectedYear;
            if (getArguments() != null && getArguments().getString("year") != null) {
                SelectedYear = getArguments().getString("year");

                String[][] plotData = cda.getBirthRecordArray(TimeChartDataAdapter.RECORDS_COUNT_SINGLE_YEAR,
                        SelectedYear, "", "");
                if (plotData != null && plotData[0].length > 0) {
                    mXValsArray = new String[plotData[0].length];
                    float[] yVals = new float[plotData[0].length];
                    for (int i = 0; i < plotData[0].length; i++) {
                        mXValsArray[i] = plotData[0][i];
                        yVals[i] = Float.valueOf(plotData[1][i]);
                    }
                    mDataSetsArray = new float[1][12];
                    mDataSetsArray[0] = yVals;
                    mLegends = new String[1];
                    mLegends[0] = "Total Registrations for " + SelectedYear;
                    int[] theColorsArray = {Color.BLUE};
                    populateChartData(mDataSetsArray, mLegends,
                            mXValsArray, theColorsArray);
                }
            }
        } else
            Log.e(TAG, "ChartActivity Year = Empty ");

        return v;
    }

    private void populateChartData(float[][] dataSetsArray, String[] legends,
                                   String[] xValsArray, int[] colorsArray) {

        if (dataSetsArray == null || mChart == null || legends == null ||
                dataSetsArray.length != legends.length) return;
        //empty data, chart, legend or unequal data/legend length


        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines

        leftAxis.setAxisMaxValue(50f);
        leftAxis.setAxisMinValue(-1f);
        leftAxis.setStartAtZero(true);
        //leftAxis.setYOffset(20f);
        // leftAxis.enableGridDashedLine(10f, 10f, 0f);


        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setEnabled(true);
        rightAxis.setAxisMaxValue(50f);
        rightAxis.setAxisMinValue(-1f);
        rightAxis.setStartAtZero(true);

        mChart.setDescription("");
        mChart.setNoDataTextDescription("You need to provide data for the chart.");


        XAxis xAxis = mChart.getXAxis();
        xAxis.setDrawGridLines(true);
        xAxis.setDrawAxisLine(true);


        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        for (int i = 0; i < dataSetsArray.length; i++) {
            // add data
            dataSets.add(getLineDataSet(dataSetsArray[i], legends[i], colorsArray[i]));
        }


        List<String> xVals = Arrays.asList(xValsArray);


        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);
        data.setValueTextColor(Color.BLUE);
        data.setValueTextSize(9f);
        // data.setDrawValues(true);


        // set data
        mChart.setData(data);


//        mChart.setVisibleXRange(20);
//        mChart.setVisibleYRange(20f, AxisDependency.LEFT);
//        mChart.centerViewTo(20, 50, AxisDependency.LEFT);

        mChart.animateX(500, Easing.EasingOption.EaseInOutQuart);
//        mChart.invalidate();

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        l.setYOffset(3f);
        l.setPosition(Legend.LegendPosition.ABOVE_CHART_RIGHT);


        // modify the legend ...
        // l.setPosition(LegendPosition.LEFT_OF_CHART);
        l.setForm(Legend.LegendForm.CIRCLE);

        // // dont forget to refresh the drawing
        // mChart.invalidate();

    }

    private float[] addFloatArrays(float[] first, float[] second) {
        if (first != null && second != null & first.length == second.length) {
            float[] sum = new float[first.length];
            for (int i = 0; i < first.length; i++) {
                sum[i] = first[i] + second[i];
            }
            return sum;
        }
        return null;

    }

    private float[] getLineDataArray(int count, float range) {

        float[] lineData = new float[count];
        float mult = (range + 1);
        for (int i = 0; i < count; i++) {
            lineData[i] = (float) (Math.random() * mult) + 3;// + (float)
        }
        return lineData;

    }


    private LineDataSet getLineDataSet(float[] dataArray, String legend, int plotColor) {

        if (dataArray == null) return null;
        int count = dataArray.length;
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        for (int i = 0; i < count; i++) {
            yVals.add(new Entry(dataArray[i], i));
        }


        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(yVals, legend);
        // set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        //  set1.enableDashedLine(10f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.setColor(plotColor);
        set1.setCircleColor(plotColor);
        set1.setLineWidth(2f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setFillAlpha(65);
        set1.setFillColor(plotColor);
//        set1.setDrawFilled(true);
        // set1.setShader(new LinearGradient(0, 0, 0, mChart.getHeight(),
        // Color.BLACK, Color.WHITE, Shader.TileMode.MIRROR));


        // set data
        return set1;
    }


/*
        float[] males = getLineDataArray(12, 500);
        float[] females = getLineDataArray(12, 500);
        float[] total = addFloatArrays(males, females);
        mXValsArray = getActivity().getResources().getStringArray(R.array.month_array);
        mDataSetsArray = new float[3][12];
        if(mNum == 2){
            males = getLineDataArray(12, 250);
            females = getLineDataArray(12, 250);
            total = addFloatArrays(males, females);
        }
        mDataSetsArray[0] = males;
        mDataSetsArray[1] = females;
        mDataSetsArray[2] = total;

        mLegends = new String[3];
        mLegends[0] = "Male";
        mLegends[1] = "Female";
        mLegends[2] = "Total";


        int[] colorsArray = {Color.BLUE, Color.BLACK, Color.MAGENTA};

        populateChartData(mDataSetsArray, mLegends,
                mXValsArray, colorsArray);
*/
    //   Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "OpenSans-Regular.ttf");
}