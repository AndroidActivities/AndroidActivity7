package com.android.widgets.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.*;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.*;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends Activity {
    private String mPlantillaMensajeItemSelected;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_spinner);
        ListView listv = (ListView) findViewById(R.id.listView);
        registerForContextMenu(listv);
        listv.setOnItemClickListener(new ListViewInfo());

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuLV:
                AdapterContextMenuInfo info =  (AdapterContextMenuInfo) item.getMenuInfo();
                int position = (int) info.id;
                ListView lv = (ListView) findViewById(R.id.listView);
                Toast.makeText(this, lv.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menutoast:
                Toast.makeText(this, getString(R.string.toastmenu), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    /**
     * Codi Montse
     */

    private class ListViewInfo implements AdapterView.OnItemClickListener {
        private boolean isFirst = true;
        @Override
        public void onItemClick(AdapterView<?> adapterView, View selectedView, int position, long id) {
            if (isFirst) {
                isFirst = false;
            } else {
                String selection = adapterView.getItemAtPosition(position).toString();
                String message = String.format(mPlantillaMensajeItemSelected, selection);
                Toast.makeText(ListViewActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
