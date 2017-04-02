package com.android.widgets.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends Activity {

    private String mPlantillaMensajeBoton;
    private String mPlantillaMensajeImageBoton;
    private String mPlantillaMensajeToggleBotonSimple;
    private String mPlantillaMensajeToggleBoton;

    private String mPlantillaMensajeRadioBoton;
    private String mPlantillaMensajeCheck;

    private final String DESMARCADO = "Desmarcado";
    private final String MARCADO = "Marcado";

    private String radioAnterior;
    private String toggleActual;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);
        mPlantillaMensajeBoton = getString(R.string.plantilla_mensaje_boton);
        mPlantillaMensajeImageBoton = getString(R.string.plantilla_mensaje_imagebutton);
        mPlantillaMensajeToggleBotonSimple = getString(R.string.plantilla_mensaje_togglebutton_simple);
        mPlantillaMensajeToggleBoton = getString(R.string.plantilla_mensaje_togglebutton);


        mPlantillaMensajeRadioBoton = getString(R.string.plantilla_mensaje_radioboton);
        mPlantillaMensajeCheck = getString(R.string.plantilla_mensaje_check);

        radio1 = (RadioButton) findViewById(R.id.rad1);
        radio2 = (RadioButton) findViewById(R.id.rad2);
        radio3 = (RadioButton) findViewById(R.id.rad3);

        radioAnterior = "";
        toggleActual = "";
    }

    /**
     * Makes a Toast showing the label of the Button, RadioButton, or CheckBox.
     * ImageButtons do not have text, and are not subclasses of Button, so you
     * cannot pass an ImageButton to this method.
     * You need the muestraInfoImageButton method.
     */

    public void muestraTextoBoton(View clickedButton) {
        Button button = (Button) clickedButton;
        CharSequence text = button.getText();
        String message = String.format(mPlantillaMensajeBoton, text);
        showToast(message);
    }

    public void muestraTextoRadioBoton(View clickedButton) {
        RadioButton radbutton = (RadioButton) clickedButton;
        onRadioButtonClick(radbutton);
        CharSequence text = radbutton.getText();
        String message = String.format(mPlantillaMensajeRadioBoton, text);
        radioAnterior = text.toString();
        showToast(message);
    }

    public void muestraTextoCheck(View clickedButton) {
        CheckBox button = (CheckBox) clickedButton;
        CharSequence text = button.getText();
        if (button.isChecked()) {
            text = text + MARCADO;
        } else {
            text = text + DESMARCADO;
        }
        String message = String.format(mPlantillaMensajeCheck, text);
        showToast(message);
    }

    public void getRadioAnterior() {
        if (radioAnterior.isEmpty()) {
            Toast.makeText(this, "No había selección previa", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "La selección previa era: " + radioAnterior, Toast.LENGTH_LONG).show();
        }
    }

    public void onRadioButtonClick(View clickedButton) {
        getRadioAnterior();
    }

    public void muestraInfoImageButton(View clickedImageButton) {
        ImageButton imb = (ImageButton) clickedImageButton;
        int idImage = imb.getId();
        String imageString = "";
        switch (idImage) {
            case R.id.img1:
                imageString = getString(R.string.info_imagebutton_1);
                break;
            case R.id.img2:
                imageString = getString(R.string.info_imagebutton_2);
                break;
            case R.id.img3:
                imageString = getString(R.string.info_imagebutton_3);
                break;
            case R.id.img4:
                imageString = getString(R.string.info_imagebutton_4);
                break;
            case R.id.img5:
                imageString = getString(R.string.info_imagebutton_5);
                break;
            case R.id.img6:
                imageString = getString(R.string.info_imagebutton_6);
                break;
        }
        //String imageString = getString(imageId);
        String message = String.format(mPlantillaMensajeImageBoton, imageString);
        showToast(message);
    }


    /**
     * Makes a Toast showing whether you turned ToggleButton on or off. Also
     * shows the resultant text (label).
     */

    public void muestraInfoToggleBoton(View clickedToggleButton) {
        ToggleButton toggleButton = (ToggleButton) clickedToggleButton;
        String status;
        if (toggleButton.isChecked()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        toggleActual = toggleButton.getText().toString();
        String message = String.format(mPlantillaMensajeToggleBoton, status, toggleActual);

        showToast(message);
    }


    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}
