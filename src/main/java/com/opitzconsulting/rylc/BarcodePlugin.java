package com.opitzconsulting.rylc;

import android.app.Activity;
import android.content.Intent;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;

/**
 * @author Tobias Bosch (OPITZ CONSULTING GmbH)
 */
public class BarcodePlugin extends Plugin {
  private String callbackId;

  @Override
  public PluginResult execute(String jsAction, JSONArray jsParams, String callbackId) {
    this.callbackId = callbackId;
    IntentIntegrator integrator = new IntentIntegrator((Activity) this.ctx) {
      @Override
      protected void startActivityForResult(Intent intent, int code) {
        ctx.startActivityForResult(BarcodePlugin.this, intent, code);
      }
    };
    integrator.initiateScan();
    PluginResult r = new PluginResult(PluginResult.Status.NO_RESULT);
    r.setKeepCallback(true);
    return r;
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    super.onActivityResult(requestCode, resultCode, intent);
    IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
    if (scanResult == null) {
      return;
    }
    if (resultCode == Activity.RESULT_OK) {
      this.success(scanResult.getContents(), this.callbackId);
    } else {
      this.error("Error", this.callbackId);
    }
  }
}
