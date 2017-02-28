package keen.eye.ink1804.destination.Fragments_Advanced;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.FbUtills;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Com_virtualSign extends Fragment implements View.OnClickListener {
    private View rootView;
    private String male,female;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.com_virtual_fragment, container, false);
        initViews();
        return rootView;
    }
    private void initViews(){
        ((IToolBar)getActivity()).toolbarSetTitle("Виртуальные знаки");
        Button btnGetResult = (Button)rootView.findViewById(R.id.comp_vir_btn_result);
        btnGetResult.setOnClickListener(this);
        MaterialSpinner maleSpinner = (MaterialSpinner) rootView.findViewById(R.id.comp_vir_male_spinner);
        MaterialSpinner femaleSpinner = (MaterialSpinner) rootView.findViewById(R.id.comp_vir_female_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,
                Constants.VIRTUAL_NAMES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        femaleSpinner.setAdapter(adapter);
        maleSpinner.setAdapter(adapter);
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "brendtext.otf");
        ((TextView)rootView.findViewById(R.id.comp_vir_tv_result)).setTypeface(tf);
        ((TextView)rootView.findViewById(R.id.comp_vir_tv_male)).setTypeface(tf);
        ((TextView)rootView.findViewById(R.id.comp_vir_tv_female)).setTypeface(tf);

        maleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                male = Constants.VIRTUAL_NAMES[i];
                ((TextView)rootView.findViewById(R.id.comp_vir_tv_male)).setText(male);
                ((TextView)rootView.findViewById(R.id.comp_vir_tv_result)).setText(" ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        femaleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                female = Constants.VIRTUAL_NAMES[i];
                ((TextView)rootView.findViewById(R.id.comp_vir_tv_female)).setText(female);
                ((TextView)rootView.findViewById(R.id.comp_vir_tv_result)).setText(" ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    @Override
    public void onClick(View view) {
        ((TextView)rootView.findViewById(R.id.comp_vir_tv_result)).setText("Оценка взаимоотношений = " + new Data_calculation().getVirtualPointsName(male,female));
        new FbUtills().setStatistics(4);
    }
}
