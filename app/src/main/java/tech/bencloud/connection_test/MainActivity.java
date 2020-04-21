package tech.bencloud.connection_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView connectionStatusTV;

    private static boolean wifiConnected = false;
    private static boolean mobileConnected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectionStatusTV = findViewById(R.id.connectionStatusTextView);

        checkNetworkConnection();
    }

    private void checkNetworkConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        if (info != null && info.isConnected()) {
            wifiConnected = info.getType() == ConnectivityManager.TYPE_WIFI;
            mobileConnected = info.getType() == ConnectivityManager.TYPE_MOBILE;

            if (wifiConnected) connectionStatusTV.setText("Wifi connection detected");
            else if (mobileConnected) connectionStatusTV.setText("Mobile connection detected");
        } else connectionStatusTV.setText("Mobile connection detected");
    }
}
