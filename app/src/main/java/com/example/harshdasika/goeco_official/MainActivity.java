package com.example.harshdasika.goeco_official;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Integer integer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
    }

    public void slideDown(View view){
        Intent intent = new Intent(this, ConfigureActivity.class);
        startActivity(intent);
        overridePendingTransitionTB();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionTB() {
        overridePendingTransition(R.animator.slide_from_bottom, R.animator.slide_to_top);
    }

    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    public void saveMoneyLiveBetterAtWalmart(View v)
    {
        int size = ArduinoInterface.pins.size();

        if (BluetoothHelper.btSocket!=null)
        {
            try
            {
                for (int i = 0; i < size ; i++)
                {

                    BluetoothHelper.btSocket.getOutputStream().write(ArduinoInterface.pins.get(i).getBytes());
                }
                msg("Turned off");
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

}
