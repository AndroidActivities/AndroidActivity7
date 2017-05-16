package com.android.widgets.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GridViewActivity extends Activity {
    private String mPlantillaMensajeItemSelected;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_spinner);
        GridView gv = (GridView) findViewById(R.id.gridView);
        List<String> futureAndroidVendors = getFutureAndroidVendors();

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, futureAndroidVendors);
        gv.setAdapter(Adapter);
        gv.setOnItemClickListener(new GridViewInfo());

    }

    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = { "RIM", "Palm", "Nokia" };
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }



    private class GridViewInfo implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View selectedView, int position, long id) {
            String selection = adapterView.getItemAtPosition(position).toString();
            String message = String.format(mPlantillaMensajeItemSelected, selection);
            showToast(message);
        }
    }

}
