package keen.eye.ink1804.destination.Fragments_Advanced;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Compatibility_zodiac_fragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private String male,female;
    private ImageView imv_male,imv_female;
    private int[] zodiacDrawables = {R.drawable.com_zod_oven, R.drawable.com_zod_telec, R.drawable.com_zod_blizneci,
            R.drawable.com_zod_rak, R.drawable.com_zod_lev, R.drawable.com_zod_deva, R.drawable.com_zod_vesi, R.drawable.com_zod_skorpion,
            R.drawable.com_zod_strelec, R.drawable.com_zod_kozerog, R.drawable.com_zod_vodoley, R.drawable.com_zod_ribi};
    private String[] ZODIAK_NAMES = {"Овен","Телец","Близнецы","Рак","Лев","Дева","Весы","Скорпион","Стрелец","Козерог","Водолей","Рыбы"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.comp_zodiac_fragment_viewpager,container,false);
        initViews();
        return rootView;
    }

    private void initViews(){
        Button btnGetResult = (Button)rootView.findViewById(R.id.comp_zod_btn_result);
        btnGetResult.setOnClickListener(this);
        imv_male = (ImageView)rootView.findViewById(R.id.comp_zod_image_male);
        imv_female = (ImageView)rootView.findViewById(R.id.comp_zod_image_female);
        MaterialSpinner maleSpinner = (MaterialSpinner) rootView.findViewById(R.id.comp_zod_male_spinner);
        MaterialSpinner femaleSpinner = (MaterialSpinner) rootView.findViewById(R.id.comp_zod_female_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,
                ZODIAK_NAMES);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        femaleSpinner.setAdapter(adapter);
        maleSpinner.setAdapter(adapter);

        maleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imv_male.setBackgroundResource(zodiacDrawables[i]);
                male = ZODIAK_NAMES[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        femaleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imv_female.setBackgroundResource(zodiacDrawables[i]);
                female = ZODIAK_NAMES[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    @Override
    public void onClick(View view) {
        String key = male + "+" + female;
        TextView tv_result = (TextView)rootView.findViewById(R.id.comp_zod_tv_result);
        String[] names = getResources().getStringArray(R.array.com_names);
        String[] details = getResources().getStringArray(R.array.com_db);
        int id = -1;
                for (int i = 0; i < names.length; i++) {
                    if (names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                tv_result.setText(Html.fromHtml(details[id]));
    }
}
