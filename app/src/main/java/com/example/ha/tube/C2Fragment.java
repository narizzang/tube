package com.example.ha.tube;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class C2Fragment extends Fragment {

    PieChart pieChart;

    public C2Fragment() {
        // Required empty public constructor
    }


    public void setData() {
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);

        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(68,"반려"));
        yValues.add(new PieEntry(15,"고양이"));
        yValues.add(new PieEntry(13,"강아지"));
        yValues.add(new PieEntry(16,"애완동물"));
        yValues.add(new PieEntry(14,"이별"));

        Description description = new Description();
        description.setText("반려동물"); //라벨
        description.setTextSize(20);
        description.setTextColor(Color.WHITE);
        pieChart.setDescription(description);

        pieChart.animateY(1000, Easing.EaseInOutCirc); //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues," 키워드");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.PASTEL_COLORS);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(20);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_c2, container, false);
        pieChart = view.findViewById(R.id.keywordChart);
        setData();
        return view;
    }

}
