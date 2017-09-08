package br.edu.ladoss.simpifladoss.mvp.model;

import android.app.Activity;

import com.google.zxing.integration.android.IntentIntegrator;

import br.edu.ladoss.simpifladoss.mvp.HomeMVP;

/**
 * Created by Rennan on 07/09/2017.
 */

public class HomeModelImp implements HomeMVP.Model{

    private HomeMVP.Presenter presenter;

    public HomeModelImp(HomeMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void openScanner(Activity activity) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Lendo QR-Code...");
        integrator.setCameraId(0);
        integrator.initiateScan();
    }

    @Override
    public void onDestroy() {
        presenter = null;
    }
}
