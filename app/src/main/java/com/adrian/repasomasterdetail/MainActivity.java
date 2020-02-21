package com.adrian.repasomasterdetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.adrian.repasomasterdetail.MasterDetail.FragmentMaster;
import com.adrian.repasomasterdetail.MasterDetail.FragmentDetail;

public class MainActivity extends AppCompatActivity implements FragmentMaster.OnFragmentMasterListener {
    FrameLayout frameMaster, frameDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        cargaInicial();
    }

    private void instancias() {
        frameMaster = findViewById(R.id.idsitiomaster);
        frameDetail = findViewById(R.id.idsitiodetail);
    }

    private void cargaInicial() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.idlistamaster, new FragmentMaster());
        fragmentTransaction.commit();
        if (frameDetail !=null) {
            FragmentManager fm2 = getSupportFragmentManager();
            FragmentTransaction ft2 = fm2.beginTransaction();
            ft2.replace(R.id.idsitiodetail, FragmentDetail.newInstance("Carga inicial"));
            ft2.commit();
        }
    }

    @Override
    public void onFragmentMasterSelected(String opcion) {
        if (frameDetail ==null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.idsitiomaster, FragmentDetail.newInstance(opcion));
            ft.addToBackStack(null);
            ft.commit();
        }else{
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.idsitiodetail, FragmentDetail.newInstance(opcion));
            ft.commit();
        }
    }
}
