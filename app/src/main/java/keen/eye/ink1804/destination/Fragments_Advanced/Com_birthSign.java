package keen.eye.ink1804.destination.Fragments_Advanced;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Com_birthSign extends Fragment implements View.OnClickListener {

    private View rootView;
    int j = 0;

    private int[] birthDrawables = {R.drawable.com_birth_monkey, R.drawable.com_birth_cock,R.drawable.com_birth_dog, R.drawable.com_birth_boar,
            R.drawable.com_birth_mouse, R.drawable.com_birth_bull, R.drawable.com_birth_tiger, R.drawable.com_birth_cat,
            R.drawable.com_birth_dragon, R.drawable.com_birth_snake, R.drawable.com_birth_horse,R.drawable.com_birth_goat};
    private String[] birthNames = {"Обезьяна","Петух","Собака","Свинья(Кабан)","Крыса","Бык",
            "Тигр","Кролик(Кот)","Дракон","Змея","Лошадь","Овца(Коза)"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.com_birth_fragment,container,false);
        initViews();
        return rootView;
    }

    private void initViews(){
        ((IToolBar)getActivity()).toolbarSetTitle("Знаки рождения");
        MaterialSpinner spinner = (MaterialSpinner) rootView.findViewById(R.id.comp_birth_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_item,
                birthNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rootView.findViewById(R.id.comp_birth_image).setBackgroundResource(birthDrawables[i]);
                j = i;
                ((TextView)rootView.findViewById(R.id.birth_text)).setText(" ");
                ((TextView)rootView.findViewById(R.id.comp_birth_tv_romantic)).setText(" ");
                (rootView.findViewById(R.id.comp_birth_tv_romantic)).setEnabled(false);
                ((TextView)rootView.findViewById(R.id.comp_birth_tv_patriarch)).setText(" ");
                (rootView.findViewById(R.id.comp_birth_tv_patriarch)).setEnabled(false);
                ((TextView)rootView.findViewById(R.id.comp_birth_tv_soul)).setText(" ");
                (rootView.findViewById(R.id.comp_birth_tv_soul)).setEnabled(false);
                ((TextView)rootView.findViewById(R.id.comp_birth_tv_equal)).setText(" ");
                (rootView.findViewById(R.id.comp_birth_tv_equal)).setEnabled(false);
                ((TextView)rootView.findViewById(R.id.comp_birth_tv_vector)).setText(" ");
                (rootView.findViewById(R.id.comp_birth_tv_vector)).setEnabled(false);
                ((TextView)rootView.findViewById(R.id.com_birth_text)).setText(" ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
        rootView.findViewById(R.id.comp_birth_btn_result).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.birth_text)).setTypeface(tf);
        (rootView.findViewById(R.id.comp_birth_tv_patriarch)).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.comp_birth_tv_patriarch)).setTypeface(tf);
        (rootView.findViewById(R.id.comp_birth_tv_romantic)).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.comp_birth_tv_romantic)).setTypeface(tf);
        (rootView.findViewById(R.id.comp_birth_tv_soul)).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.comp_birth_tv_soul)).setTypeface(tf);
        (rootView.findViewById(R.id.comp_birth_tv_equal)).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.comp_birth_tv_equal)).setTypeface(tf);
        (rootView.findViewById(R.id.comp_birth_tv_vector)).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.comp_birth_tv_vector)).setTypeface(tf);
    }

    @Override
    public void onClick(View view) {
        String key = "default";
            switch (view.getId()) {
                case R.id.comp_birth_tv_romantic:
                    key = "Романтический брак";
                    break;
                case R.id.comp_birth_tv_patriarch:
                    key = "Патриархальный брак";
                    break;
                case R.id.comp_birth_tv_soul:
                    key = "Духовный брак";
                    break;
                case R.id.comp_birth_tv_equal:
                    key = "Равный брак";
                    break;
                case R.id.comp_birth_tv_vector:
                    key = "Векторный брак";
                    break;
                case R.id.comp_birth_btn_result:
                    Data_calculation struct_data = new Data_calculation();
                    ((TextView)rootView.findViewById(R.id.birth_text)).setText("Пять типов брака:");
                    ((TextView)rootView.findViewById(R.id.comp_birth_tv_patriarch)).setText("Патриархальный брак: "+struct_data.getPatriarchalMarriage(j));
                    ((TextView)rootView.findViewById(R.id.comp_birth_tv_romantic)).setText("Романтический брак: "+struct_data.getRomanticMarriage(j));
                    ((TextView)rootView.findViewById(R.id.comp_birth_tv_soul)).setText("Духовный брак: "+struct_data.getSpiritualMarriage(j));
                    ((TextView)rootView.findViewById(R.id.comp_birth_tv_equal)).setText("Равный брак: "+struct_data.getEqualMarriage(j));
                    ((TextView)rootView.findViewById(R.id.comp_birth_tv_vector)).setText("Векторный брак: "+struct_data.getVectorMarriage(j));
                    (rootView.findViewById(R.id.comp_birth_tv_romantic)).setEnabled(true);
                    (rootView.findViewById(R.id.comp_birth_tv_patriarch)).setEnabled(true);
                    (rootView.findViewById(R.id.comp_birth_tv_soul)).setEnabled(true);
                    (rootView.findViewById(R.id.comp_birth_tv_equal)).setEnabled(true);
                    (rootView.findViewById(R.id.comp_birth_tv_vector)).setEnabled(true);

//                    new FbUtills().setStatistics(4);
                    break;
                default:
                    break;
            }
        int id =-1;
        String[] com_names = getResources().getStringArray(R.array.com_marriage_names);
        for (int i = 0; i < com_names.length; i++) {
            if (com_names[i].equals(key)) {
                id = i;
                break;
            }
        }
        if(id!=-1)
            ((TextView) rootView.findViewById(R.id.com_birth_text)).setText(setTvTextWithHtml(getResources().getStringArray(R.array.com_marriage_db)[id]));
    }

    private Spanned setTvTextWithHtml(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text);
        }

    }
}
