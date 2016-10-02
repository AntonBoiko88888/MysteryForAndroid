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
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Compatibility_virtual_fragment extends Fragment implements View.OnClickListener {
    private View rootView;
    private TextView tv_result,tv_male, tv_female;
    private String male,female;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.comp_virtual_fragment_viewpager, container, false);
        initViews();
        return rootView;
    }
    private void initViews(){
        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Виртуальные знаки");
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
        tv_result = (TextView)rootView.findViewById(R.id.comp_vir_tv_result);
        tv_result.setTypeface(tf);
        tv_male = (TextView)rootView.findViewById(R.id.comp_vir_tv_male);
        tv_male.setTypeface(tf);
        tv_female = (TextView)rootView.findViewById(R.id.comp_vir_tv_female);
        tv_female.setTypeface(tf);

        maleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                male = Constants.VIRTUAL_NAMES[i];
                tv_male.setText(male);
                tv_result.setText(" ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        femaleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                female = Constants.VIRTUAL_NAMES[i];
                tv_female.setText(female);
                tv_result.setText(" ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    @Override
    public void onClick(View view) {
        Data_calculation struct_data = new Data_calculation();
        tv_result.setText("Оценка взаимоотношений = " + struct_data.getVirtualPointsName(male,female));
    }
}
