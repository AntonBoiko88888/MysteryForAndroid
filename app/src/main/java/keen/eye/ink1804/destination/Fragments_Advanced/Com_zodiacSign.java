package keen.eye.ink1804.destination.Fragments_Advanced;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.FbUtills;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Com_zodiacSign extends Fragment implements View.OnClickListener {

    private View rootView;
    private String male,female;
    private int[] zodiacDrawables = {R.drawable.com_zod_oven, R.drawable.com_zod_telec, R.drawable.com_zod_blizneci,
            R.drawable.com_zod_rak, R.drawable.com_zod_lev, R.drawable.com_zod_deva, R.drawable.com_zod_vesi, R.drawable.com_zod_skorpion,
            R.drawable.com_zod_strelec, R.drawable.com_zod_kozerog, R.drawable.com_zod_vodoley, R.drawable.com_zod_ribi};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.com_zodiac_fragment,container,false);
        initViews();
        return rootView;
    }

    private void initViews(){
        ((IToolBar)getActivity()).toolbarSetTitle("Знаки зодиака");
        Button btnGetResult = (Button)rootView.findViewById(R.id.comp_zod_btn_result);
        btnGetResult.setOnClickListener(this);
        MaterialSpinner maleSpinner = (MaterialSpinner) rootView.findViewById(R.id.comp_zod_male_spinner);
        MaterialSpinner femaleSpinner = (MaterialSpinner) rootView.findViewById(R.id.comp_zod_female_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,
                Constants.ZODIAK_NAMES_normal);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        femaleSpinner.setAdapter(adapter);
        maleSpinner.setAdapter(adapter);
        maleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rootView.findViewById(R.id.comp_zod_image_male).setBackgroundResource(zodiacDrawables[i]);
                male = Constants.ZODIAK_NAMES_normal[i];
                ((TextView)rootView.findViewById(R.id.comp_zod_tv_result)).setText(" ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        femaleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rootView.findViewById(R.id.comp_zod_image_female).setBackgroundResource(zodiacDrawables[i]);
                female = Constants.ZODIAK_NAMES_normal[i];
                ((TextView)rootView.findViewById(R.id.comp_zod_tv_result)).setText(" ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    @Override
    public void onClick(View view) {
        String key = male + "+" + female;
        String[] names = getResources().getStringArray(R.array.com_zodiacRelat_names);
        String[] details = getResources().getStringArray(R.array.com_zodiacRelat_db);
        int id = -1;
                for (int i = 0; i < names.length; i++) {
                    if (names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            ((TextView)rootView.findViewById(R.id.comp_zod_tv_result)).setText(Html.fromHtml(details[id], Html.FROM_HTML_MODE_LEGACY));
        } else {
            ((TextView)rootView.findViewById(R.id.comp_zod_tv_result)).setText(Html.fromHtml(details[id]));
        }
        new FbUtills().setStatistics(4);
    }
}
