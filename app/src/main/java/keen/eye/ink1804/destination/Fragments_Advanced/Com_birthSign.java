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
import android.widget.ImageView;
import android.widget.TextView;

import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Com_birthSign extends Fragment implements View.OnClickListener {

    private View rootView;
    private TextView tv_romantic, tv_patriarch, tv_soul, tv_equal, tv_vector, tv_text;
    int j = 0;

    private int[] birthDrawables = {R.drawable.com_birth_monkey, R.drawable.com_birth_cock,R.drawable.com_birth_dog, R.drawable.com_birth_boar,
            R.drawable.com_birth_mouse, R.drawable.com_birth_bull, R.drawable.com_birth_tiger, R.drawable.com_birth_cat,
            R.drawable.com_birth_dragon, R.drawable.com_birth_snake, R.drawable.com_birth_horse,R.drawable.com_birth_goat};
    private String[] birthNames = {"Обезьяна","Петух","Собака","Свинья(Кабан)","Крыса","Бык",
            "Тигр","Кролик(Кот)","Дракон","Змея","Лошадь","Овца(Коза)"};

    @Override
    public void onDetach() {
        birthDrawables = null;
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.com_birth_fragment,container,false);
        initViews();
        return rootView;
    }

    private void initViews(){
        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Знаки рождения");
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
                tv_text.setText(" ");
                tv_romantic.setText(" ");
                tv_romantic.setEnabled(false);
                tv_patriarch.setText(" ");
                tv_patriarch.setEnabled(false);
                tv_soul.setText(" ");
                tv_soul.setEnabled(false);
                tv_equal.setText(" ");
                tv_equal.setEnabled(false);
                tv_vector.setText(" ");
                tv_vector.setEnabled(false);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
        rootView.findViewById(R.id.comp_birth_btn_result).setOnClickListener(this);
        tv_text = (TextView)rootView.findViewById(R.id.birth_text);
        tv_text.setTypeface(tf);
        tv_patriarch = (TextView)rootView.findViewById(R.id.comp_birth_tv_patriarch);
        tv_patriarch.setOnClickListener(this);
        tv_patriarch.setTypeface(tf);
        tv_romantic = (TextView)rootView.findViewById(R.id.comp_birth_tv_romantic);
        tv_romantic.setOnClickListener(this);
        tv_romantic.setTypeface(tf);
        tv_soul = (TextView)rootView.findViewById(R.id.comp_birth_tv_soul);
        tv_soul.setOnClickListener(this);
        tv_soul.setTypeface(tf);
        tv_equal = (TextView)rootView.findViewById(R.id.comp_birth_tv_equal);
        tv_equal.setOnClickListener(this);
        tv_equal.setTypeface(tf);
        tv_vector = (TextView)rootView.findViewById(R.id.comp_birth_tv_vector);
        tv_vector.setOnClickListener(this);
        tv_vector.setTypeface(tf);
    }

    @Override
    public void onClick(View view) {
        String key = "default";
        String tag = "com_birth";
        pushDateListener listener = (pushDateListener)getActivity();
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
                    tv_text.setText("Пять типов брака:");
                    tv_patriarch.setText("Патриархальный брак: "+struct_data.getPatriarchalMarriage(j));
                    tv_romantic.setText("Романтический брак: "+struct_data.getRomanticMarriage(j));
                    tv_soul.setText("Духовный брак: "+struct_data.getSpiritualMarriage(j));
                    tv_equal.setText("Равный брак: "+struct_data.getEqualMarriage(j));
                    tv_vector.setText("Векторный брак: "+struct_data.getVectorMarriage(j));
                    tv_romantic.setEnabled(true);
                    tv_patriarch.setEnabled(true);
                    tv_soul.setEnabled(true);
                    tv_equal.setEnabled(true);
                    tv_vector.setEnabled(true);
                    break;
                default:
                    break;
            }
        if(!key.equals("default"))
            listener.onDescriptionClicked(key, tag);//key is going to new bundle
    }
}
