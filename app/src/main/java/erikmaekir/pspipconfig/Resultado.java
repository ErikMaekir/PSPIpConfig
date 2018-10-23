package erikmaekir.pspipconfig;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        checkWifiOnAndConnected();

    }

    private void checkWifiOnAndConnected() {
        WifiManager wm = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        String ip = Integer.toString(wm.getConnectionInfo().getIpAddress());

        TextView tvip = findViewById(R.id.tvip);
        TextView tvres = findViewById(R.id.tvestado);
        tvip.setText(ip);


        if (wm.isWifiEnabled()) { // Wi-Fi adapter is ON

            WifiInfo wifiInfo = wm.getConnectionInfo();

            if( wifiInfo.getNetworkId() == -1 ){
                tvres.setText("No Conectado");
                return;

            }
            tvres.setText("Conectado");
        }
        else {
            tvres.setText("WiFi no activado");
        }
    }
}
