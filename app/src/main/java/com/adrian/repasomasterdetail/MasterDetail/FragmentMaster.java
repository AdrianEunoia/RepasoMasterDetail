package com.adrian.repasomasterdetail.MasterDetail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.adrian.repasomasterdetail.R;

public class FragmentMaster extends Fragment {
    // Elementos
    ListView idlistamaster;
    OnFragmentMasterListener listener;
    // Attachment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentMasterListener) context;
        } catch (ClassCastException e){

        }
    }
    // Create view
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_master, container,false);
        idlistamaster = view.findViewById(R.id.idlistamaster);
        // Rellenar opciones
        final String[] opciones = {"opcion1","opcion2","opcion3","opcion4","opcion5"};

        ArrayAdapter<String> adapterListar = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,opciones);
        idlistamaster.setAdapter(adapterListar);
        idlistamaster.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listener.onFragmentMasterSelected(opciones[i]);
            }
        });
        return view;
    }
    // Callback
    public interface OnFragmentMasterListener{
        void onFragmentMasterSelected(String opcion);
    }
}
