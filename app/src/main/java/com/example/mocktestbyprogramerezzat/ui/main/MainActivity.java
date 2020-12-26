package com.example.mocktestbyprogramerezzat.ui.main;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mocktestbyprogramerezzat.R;
import com.example.mocktestbyprogramerezzat.data.model.RandomTestModel;
import com.example.mocktestbyprogramerezzat.ui.main.viewmodel.MainViewModel;
import com.example.mocktestbyprogramerezzat.utils.helper.Helper;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    //ui
    private ProgressBar progressRSRP, progressRSRQ, progressSNR;
    private TextView txt_RSRP, txt_RSRQ, txt_SNR;
    private LineChart chartRSRP, chartRSRQ, chartSNR;

    // var
    private MainViewModel mainViewModel;
    private String Token;
    private ArrayList<Entry> xRSRP;
    private ArrayList<String> yRSRP;
    private ArrayList<Entry> xRSRQ;
    private ArrayList<String> yRSRQ;
    private ArrayList<Entry> xSNR;
    private ArrayList<String> ySNR;
    private String legendile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadLegendFile();
        init();
        observeDataromApi();

        buildRSRP();
        buildRSRQ();
        buildSNR();


    }

    private void checkColorRSRP(double result) throws JSONException {

        try {
            JSONObject obj = new JSONObject(legendile);
            JSONArray RSRP = obj.getJSONArray("RSRP");


            if (result >= -60) {
                JSONObject jsonObject = (JSONObject) RSRP.get(6);
                String color = jsonObject.getString("Color");
                updateRSRP(result, color);
                Log.d("vvvvvvvvv", "checkColorRSRP: 1 " + color);

            } else if (result < -60 && result > -70) {
                JSONObject jsonObject = (JSONObject) RSRP.get(5);
                String color = jsonObject.getString("Color");
                updateRSRP(result, color);
                Log.d("vvvvvvvvv", "checkColorRSRP: 2 " + color);

            } else if (result < -70 && result > -80) {
                JSONObject jsonObject = (JSONObject) RSRP.get(4);
                String color = jsonObject.getString("Color");
                updateRSRP(result, color);
                Log.d("vvvvvvvvv", "checkColorRSRP: 3 " + color);

            } else if (result < -80 && result > -90) {
                JSONObject jsonObject = (JSONObject) RSRP.get(3);
                String color = jsonObject.getString("Color");
                updateRSRP(result, color);
                Log.d("vvvvvvvvv", "checkColorRSRP: 4 " + color);

            } else if (result < -90 && result > -100) {
                JSONObject jsonObject = (JSONObject) RSRP.get(2);
                String color = jsonObject.getString("Color");
                updateRSRP(result, color);
                Log.d("vvvvvvvvv", "checkColorRSRP: 5 " + color);

            } else if (result < -100 && result > -110) {
                JSONObject jsonObject = (JSONObject) RSRP.get(1);
                String color = jsonObject.getString("Color");
                updateRSRP(result, color);
                Log.d("vvvvvvvvv", "checkColorRSRP: 6 " + color);

            } else if (result >= -110) {
                JSONObject jsonObject = (JSONObject) RSRP.get(0);
                String color = jsonObject.getString("Color");
                updateRSRP(result, color);
                Log.d("vvvvvvvvv", "checkColorRSRP: 7 " + color);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void checkColorSNR(double result) throws JSONException {

        try {
            JSONObject obj = new JSONObject(legendile);
            JSONArray RSRP = obj.getJSONArray("SINR");


            if (result >= 30) {
                JSONObject jsonObject = (JSONObject) RSRP.get(6);
                String color = jsonObject.getString("Color");
                updateSIN(result, color);


            } else if (result < 30 && result > 25) {
                JSONObject jsonObject = (JSONObject) RSRP.get(5);
                String color = jsonObject.getString("Color");
                updateSIN(result, color);


            } else if (result < 25 && result > 20) {
                JSONObject jsonObject = (JSONObject) RSRP.get(4);
                String color = jsonObject.getString("Color");
                updateSIN(result, color);


            } else if (result < 20 && result > 15) {
                JSONObject jsonObject = (JSONObject) RSRP.get(3);
                String color = jsonObject.getString("Color");
                updateSIN(result, color);


            } else if (result < 15 && result > 10) {
                JSONObject jsonObject = (JSONObject) RSRP.get(2);
                String color = jsonObject.getString("Color");
                updateSIN(result, color);


            } else if (result < 10 && result > 5) {
                JSONObject jsonObject = (JSONObject) RSRP.get(1);
                String color = jsonObject.getString("Color");
                updateSIN(result, color);


            } else if (result >= 0) {
                JSONObject jsonObject = (JSONObject) RSRP.get(0);
                String color = jsonObject.getString("Color");
                updateSIN(result, color);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void checkColorRSRQ(double result) throws JSONException {

        try {
            JSONObject obj = new JSONObject(legendile);
            JSONArray RSRP = obj.getJSONArray("RSRQ");


            if (result >= -3) {
                JSONObject jsonObject = (JSONObject) RSRP.get(5);
                String color = jsonObject.getString("Color");
                updateRSRQ(result, color);


            } else if (result < -3 && result > -9) {
                JSONObject jsonObject = (JSONObject) RSRP.get(4);
                String color = jsonObject.getString("Color");
                updateRSRQ(result, color);


            } else if (result < -9 && result > -14) {
                JSONObject jsonObject = (JSONObject) RSRP.get(2);
                String color = jsonObject.getString("Color");
                updateRSRQ(result, color);


            } else if (result < -14 && result > -19.5) {
                JSONObject jsonObject = (JSONObject) RSRP.get(1);
                String color = jsonObject.getString("Color");
                updateRSRQ(result, color);


            } else if (result >= -19.5) {
                JSONObject jsonObject = (JSONObject) RSRP.get(0);
                String color = jsonObject.getString("Color");
                updateRSRQ(result, color);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateRSRP(double result, String color) {
        progressRSRP.setProgressTintList(ColorStateList.valueOf(Color.parseColor(color)));
        progressRSRP.setProgress(Math.abs((int) result));
        txt_RSRP.setText(result + "");
    }

    private void updateSIN(double result, String color) {
        progressSNR.setProgressTintList(ColorStateList.valueOf(Color.parseColor(color)));
        progressSNR.setProgress(Math.abs((int) result));
        txt_SNR.setText(result + "");
    }

    private void updateRSRQ(double result, String color) {
        progressRSRQ.setProgressTintList(ColorStateList.valueOf(Color.parseColor(color)));
        progressRSRQ.setProgress(Math.abs((int) result));
        txt_RSRQ.setText(result + "");
    }


    private void loadLegendFile() {
        legendile = Helper.loadJSONFromAsset(getApplicationContext(), "Legend.json");

    }

    private void buildRSRP() {
        xRSRP = new ArrayList<Entry>();
        yRSRP = new ArrayList<String>();
        chartRSRP = (LineChart) findViewById(R.id.lineRSRP);
        chartRSRP.setDrawGridBackground(false);
        chartRSRP.setDescription("RSRP");
        chartRSRP.setDescriptionTextSize(20);
//        chartRSRP.setTouchEnabled(true);
//        chartRSRP.setDragEnabled(true);
//        chartRSRP.setScaleEnabled(true);
//        chartRSRP.setPinchZoom(true);
        chartRSRP.getXAxis().setTextSize(15f);
        chartRSRP.getAxisLeft().setTextSize(15f);
        chartRSRP.setBorderColor(Color.WHITE);
        chartRSRP.setBackgroundColor(Color.WHITE);
        XAxis xl = chartRSRP.getXAxis();
        xl.setAvoidFirstLastClipping(true);
        YAxis leftAxis = chartRSRP.getAxisLeft();
        leftAxis.setInverted(true);
        YAxis rightAxis = chartRSRP.getAxisRight();
        rightAxis.setEnabled(false);
        Legend l = chartRSRP.getLegend();
        l.setForm(Legend.LegendForm.LINE);

    }

    private void buildRSRQ() {
        xRSRQ = new ArrayList<Entry>();
        yRSRQ = new ArrayList<String>();
        chartRSRQ = (LineChart) findViewById(R.id.lineRSRQ);
        chartRSRQ.setDrawGridBackground(false);
        chartRSRQ.setDescription("RSRQ");
        chartRSRQ.setDescriptionTextSize(20);
//        chartRSRP.setTouchEnabled(true);
//        chartRSRP.setDragEnabled(true);
//        chartRSRP.setScaleEnabled(true);
//        chartRSRP.setPinchZoom(true);
        chartRSRQ.getXAxis().setTextSize(15f);
        chartRSRQ.getAxisLeft().setTextSize(15f);
        chartRSRQ.setBorderColor(Color.WHITE);
        chartRSRQ.setBackgroundColor(Color.WHITE);
        XAxis xl = chartRSRQ.getXAxis();
        xl.setAvoidFirstLastClipping(true);
        YAxis leftAxis = chartRSRQ.getAxisLeft();
        leftAxis.setInverted(true);
        YAxis rightAxis = chartRSRQ.getAxisRight();
        rightAxis.setEnabled(false);
        Legend l = chartRSRQ.getLegend();
        l.setForm(Legend.LegendForm.LINE);

    }

    private void buildSNR() {
        xSNR = new ArrayList<Entry>();
        ySNR = new ArrayList<String>();
        chartSNR = (LineChart) findViewById(R.id.lineSNR);
        chartSNR.setDrawGridBackground(false);
        chartSNR.setDescription("SNR");
        chartSNR.setDescriptionTextSize(20);
//        chartRSRP.setTouchEnabled(true);
//        chartRSRP.setDragEnabled(true);
//        chartRSRP.setScaleEnabled(true);
//        chartRSRP.setPinchZoom(true);
        chartSNR.getXAxis().setTextSize(15f);
        chartSNR.getAxisLeft().setTextSize(15f);
        chartSNR.setBorderColor(Color.WHITE);
        chartSNR.setBackgroundColor(Color.WHITE);
        XAxis xl = chartSNR.getXAxis();
        xl.setAvoidFirstLastClipping(true);
        YAxis leftAxis = chartSNR.getAxisLeft();
        leftAxis.setInverted(true);
        YAxis rightAxis = chartSNR.getAxisRight();
        rightAxis.setEnabled(false);
        Legend l = chartSNR.getLegend();
        l.setForm(Legend.LegendForm.LINE);

    }

    private void Graph_ListRSRP(RandomTestModel randomTestModel) {

        String time = Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND);

        yRSRP.add(time);
        xRSRP.add(new Entry((float) randomTestModel.getRSRP(), yRSRP.size() - 1));


        LineDataSet set1 = new LineDataSet(xRSRP, Token);
        set1.setColors(ColorTemplate.COLORFUL_COLORS);
        set1.setLineWidth(1.5f);
        set1.setCircleRadius(4f);
        LineData data = new LineData(yRSRP, set1);

        chartRSRP.setData(data);
        chartRSRP.invalidate();


    }

    private void Graph_ListRSRQ(RandomTestModel randomTestModel) {

        String time = Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND);

        yRSRQ.add(time);
        xRSRQ.add(new Entry((float) randomTestModel.getRSRQ(), yRSRQ.size() - 1));


        LineDataSet set1 = new LineDataSet(xRSRQ, Token);
        set1.setColors(ColorTemplate.COLORFUL_COLORS);
        set1.setLineWidth(1.5f);
        set1.setCircleRadius(4f);
        LineData data = new LineData(yRSRQ, set1);

        chartRSRQ.setData(data);
        chartRSRQ.invalidate();


    }

    private void Graph_ListSNR(RandomTestModel randomTestModel) {

        String time = Calendar.getInstance().get(Calendar.MINUTE) + ":" + Calendar.getInstance().get(Calendar.SECOND);

        ySNR.add(time);
        xSNR.add(new Entry((float) randomTestModel.getSINR(), ySNR.size() - 1));


        LineDataSet set1 = new LineDataSet(xSNR, Token);
        set1.setColors(ColorTemplate.COLORFUL_COLORS);
        set1.setLineWidth(1.5f);
        set1.setCircleRadius(4f);
        LineData data = new LineData(ySNR, set1);

        chartSNR.setData(data);
        chartSNR.invalidate();


    }


    private void observeDataromApi() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.getModelMutableLiveData().observe(this, new Observer<RandomTestModel>() {
            @Override
            public void onChanged(RandomTestModel randomTestModel) {


                try {
                    updateProgressBar(randomTestModel);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                Graph_ListRSRP(randomTestModel);
                Graph_ListRSRQ(randomTestModel);
                Graph_ListSNR(randomTestModel);


            }
        });

    }


    private void updateProgressBar(RandomTestModel randomTestModel) throws JSONException {

        double num = randomTestModel.getRSRP();
        if (num != 0) {

            checkColorRSRP(num);


        }


        num = randomTestModel.getRSRQ();
        if (num != 0) {

            checkColorRSRQ(num);

        }

        num = randomTestModel.getSINR();
        if (num != 0) {
            checkColorSNR(num);
        }
    }


    private void init() {
        progressRSRP = findViewById(R.id.progressRSRP);
        txt_RSRP = findViewById(R.id.txt_RSRP);

        progressRSRQ = findViewById(R.id.progressRSRQ);
        txt_RSRQ = findViewById(R.id.txt_RSRQ);

        progressSNR = findViewById(R.id.progressSNR);
        txt_SNR = findViewById(R.id.txt_SNR);


    }


}