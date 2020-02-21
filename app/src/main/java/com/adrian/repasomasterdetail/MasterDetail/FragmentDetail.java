package com.adrian.repasomasterdetail.MasterDetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adrian.repasomasterdetail.R;

public class FragmentDetail extends Fragment {
    // Elementos
    final static String TAG_ARG = "Argumento pasado";
    private String opcionPasada;
    private TextView textoDetalle;

    public static FragmentDetail newInstance(String opcionPasada) {
        FragmentDetail fragmentDetalle = new FragmentDetail();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG, opcionPasada);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }
    // Attachment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.getArguments() != null) {
            this.opcionPasada = this.getArguments().getString(TAG_ARG);
        }
    }
    // Create view
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_detalle, container, false);
        textoDetalle = view.findViewById(R.id.idtextodetalle);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textoDetalle.setText(opcionPasada);
    }
}
